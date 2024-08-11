case class HashPartitioning(
  expressions: Seq[Expression],
  numPartitions: Int
) extends Expression[TreeNode] with Partitioning with Unevaluable {

  def children: Seq[Expression] = expressions

  def withNewChildrenInternal(newChildren: IndexedSeq[Expression]): HashPartitioning =
    copy(expressions = newChildren)

  def satisfies0(required: Distribution): Boolean = required match {
    case _ if Partitioning.satisfies0$(this, required) => true
  
    case d : StatefulOpClusteredDistribution =>
      expressions.length() == d.expressions.length() &&
      expressions.zip(d.expressions)
        .forall { case (l, r) => l.semanticEquals(r) }

    case d : ClusteredDistribution if d.requireAllClusterKeys =>
      d.areAllClusterKeysMatched(expressions)

    case d : ClusteredDistribution => 
      val requiredClustering = d.clustering()
      expressions
        .forall(x => requiredClustering.exists(x.semanticEquals(_))

    case _ => false
  }


  def project(projectList: Seq[NamedExpression]): Partitioning = {
    val projection = new ExpressionProjection(projectList)
    val projectedExprs = expressions
      .map(x => projection.replaceWithAlias(x))

    if (projectedExprs.exists(_.isEmpty))
      new UnknownPartitioning(numPartitions)
    else {
      val newExs = projectedExprs.map(_.head)
      if (newExs != expressions())
        withNewChildrenInternal(newExs)
      else 
        this
    }
  }

  def createShuffleSpec(distribution: ClusteredDistribution): ShuffleSpec =
    new HashShuffleSpec(this, distribution)
     
  def partitionIdExpression(): Expression =
    new Pmod(
      new Murmur3Hash(expressions),
      Literal(numPartitions),
      Pmod()
    ) 

}
