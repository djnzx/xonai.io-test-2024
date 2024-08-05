package org.apache.spark.sql.catalyst.plans.physical
package src
// since we have `scala.collection.Seq` (imporded by Predef), not `scala.collection.immutable.Seq` we deal with 2.12;

// @ScalaSignature(???)
// added by scala-compiler, doesn't hold code-related things
// since we have .copy() - we deal with the case class
case class HashPartitioning(
  // private final thing go to the case class fields
  expressions: Seq[Expression],
  numPartitions: Int
)
 extends Expression[TreeNode] // ???
   with Partitioning // trait with some functionality mixed in,
   with Unevaluable  // trait with some functionality mixed in,
   with Serializable // java marker interface, nothing usual, but gives ability to serialize natively by Java
 {
  
  // class constructor generated automatically by the Scala Compiler
  // public HashPartitioning(final Seq<Expression> expressions, final int numPartitions) {
  //   this.expressions = expressions;
  //   this.numPartitions = numPartitions;
  //   Partitioning.$init$(this); // standard construction to mix traits 
  //   Unevaluable.$init$(this);  // to ensure all declared vals are initialized
  // }

  // field accessor, provided by scala compiler due to the `case` class notation
  // def expressions: Seq[Expression] = ???
  // field accessor, provided by scala compiler due to the `case` class notation
  // def numPartitions: Int = ???

  // added by the compiler automatically, to convert apply(A, B): C
  // to apply(t: (A, B)) => C
  // public static Function1<Tuple2<Seq<Expression>, Object>, HashPartitioning> tupled() {
  //   return HashPartitioning$.MODULE$.tupled();
  // }

  // added by the compiler automatically, to convert apply(A, B): C
  // to apply(a: A): (b: B) => C
  // public static Function1<Seq<Expression>, Function1<Object, HashPartitioning>> curried() {
  //  return HashPartitioning$.MODULE$.curried();
  // }

  // added by the compiler, it's not clear to me for now, why to we have static NOT on the companion object
  // public static Option<Tuple2<Seq<Expression>, Object>> unapply(final HashPartitioning x$0) {
  //  return HashPartitioning$.MODULE$.unapply(x$0);
  // }

  // added by the compiler
  // public HashPartitioning copy(final Seq<Expression> expressions, final int numPartitions) {
  //   return new HashPartitioning(expressions, numPartitions);
  // }

  // added by the compiler, to provide default values in .copy()
  // public Seq<Expression> copy$default$1() {
  //   return this.expressions();
  // }

  // public int copy$default$2() {
  //   return this.numPartitions();
  // }

  // convenient user-friendly name for the field accessor
  def children: Seq[Expression] =
    expressions

  // convenient name for .copy()
  def withNewChildrenInternal(newChildren: IndexedSeq[Expression]): HashPartitioning =
    copy(expressions = newChildren)

  // synthetic (bridge) method to conform Java Generic erasure
  // generated automatically by scala compiler
  // def withNewChildrenInternal(newChildren: IndexedSeq[_]): TreeNode =
  //   withNewChildrenInternal(newChildren)

  // from Product trait, in Scala any case class extends Product, since case class is a `product` of it's members
  // public String productPrefix() {
  //  return "HashPartitioning";
  // }

  // from Product trait, number of case class members
  // public int productArity() {
  //  return 2;
  // }

  // from Product trait, each field is accessible by index
  // public Object productElement(final int x$1) {
  //   Object var10000;
  //   switch (x$1) {
  //     case 0:
  //       var10000 = this.expressions();
  //       break;
  //     case 1:
  //       var10000 = BoxesRunTime.boxToInteger(this.numPartitions());
  //       break;
  //     default:
  //       throw new IndexOutOfBoundsException(Integer.toString(x$1));
  //   }
  //   return var10000;
  // }

  // from Product trait, we can iterate over the case class members
  // public Iterator<Object> productIterator() {
  //   return scala.runtime.ScalaRunTime..MODULE$.typedProductIterator(this);
  // }

  // Product extends Equals. canEqual goes from Equals
  // added by Scala compile due to `case` class notation
  // public boolean canEqual(final Object x$1) = {
  //  return x$1 instanceof HashPartitioning;
  // }

  // Product extends Equals. equals goes from Equals
  // added by Scala compile due to `case` class notation
  // public boolean equals(final Object x$1) {
  //   boolean var6;
  //   if (this != x$1) {
  //     label55: {
  //       boolean var2;
  //       if (x$1 instanceof HashPartitioning) {
  //         var2 = true;
  //       } else {
  //         var2 = false;
  //       }
  // 
  //       if (var2) {
  //         label38: {
  //           label37: {
  //             HashPartitioning var4 = (HashPartitioning)x$1;
  //             Seq var10000 = this.expressions();
  //             Seq var5 = var4.expressions();
  //             if (var10000 == null) {
  //               if (var5 != null) {
  //                 break label37;
  //               }
  //             } else if (!var10000.equals(var5)) {
  //               break label37;
  //             }
  // 
  //             if (this.numPartitions() == var4.numPartitions() && var4.canEqual(this)) {
  //               var6 = true;
  //               break label38;
  //             }
  //           }
  // 
  //           var6 = false;
  //         }
  // 
  //         if (var6) {
  //           break label55;
  //         }
  //       }
  // 
  //       var6 = false;
  //       return var6;
  //     }
  //   }
  // 
  //   var6 = true;
  //   return var6;
  // }

  // created by scala-compiler
  // in any class has at least one lmbda in the code
  // used to deserialize lambdas after their serialization
  // private static Object $deserializeLambda$(SerializedLambda var0) {
  //   return Class.lambdaDeserialize<invokedynamic>(var0);
  // }

  // lambda1 from the method satisfies0
  // def $anonfun$satisfies0$1(x0$1: (Expression, Expression)): Boolean = x0$1 match {
  //   case (l, r) => l.semanticEquals(r)
  // }

  // lambda2 from the method satisfies0
  // def $anonfun$satisfies0$2(requiredClustering$1 Seq[_], x: Expression): Boolean = 
  //   requiredClustering$1.exists(x => $anonfun$satisfies0$3(x, x$6))

  // BoxesRunTime.boxToBoolean:
  // java boolean => java Boolean


  // lambda3 from the method satisfies0
  // def $anonfun$satisfies0$3(final Expression x$22, final Expression x$6): Boolean = 
  //   x$6.semanticEquals(x$22)
  
  // lambda from the method project
  // def $anonfun$project$2(x$7: Seq[_]): Boolean =
  //   x$7.isEmpty

  // it seems next methods are from Unevaluable trait (has companion object also)
  // and they are in the different file
  // import org.apache.spark.sql.catalyst.expressions.Unevaluable
  trait Unevaluable {

    def foldable: Boolean =
      Unevaluable.foldable$(this);
   
    def eval (input: InternalRow): Object =
      Unevaluable.eval$(this, input)
   
    def eval$default$1(): InternalRow =
      Unevaluable.eval$default$1$(this)
   
    def doGenCode(ctx: CodegenContext, ev: ExprCode): ExprCode =
      Unevaluable.doGenCode$(this, ctx, ev)

  }

  // next group of methods are from Partitioning trait (has companion object also)
  trait Partitioning {

    def satisfies(required: Distribution): Boolean =
      Partitioning.satisfies$(this, required)
  
    def flatten(): Seq[Partitioning] =
      Partitioning.flatten$(this)

    // Distribution is a abstract or trait or java interface
    //  can be StatefulOpClusteredDistribution
    //  can be ClusteredDistribution
    //  or something else. we don't have it code 
    def satisfies0(required: Distribution): Boolean = required match {

      case _ if Partitioning.satisfies0$(this, required) => true
  
      case v4 @ StatefulOpClusteredDistribution if 
        this.expressions().length() == v4.expressions().length() &&
        // zip(...)(implicit canBuildFrom())
        (IterableLike)this.expressions().zip(v4.expressions()) // Tuple
          .forall { case (l, r) => l.semanticEquals(r) } => true

      case v5 @ ClusteredDistribution if v5.requireAllClusterKeys =>
        var5.areAllClusterKeysMatched(this.expressions())

      case v5 @ ClusteredDistribution => 
        val requiredClustering = v5.clustering()
        this.expressions()
          .forall(xx => requiredClustering.exists(x => xx.semanticEquals(x))

      case _ => false
    }
  
    def project(projectList: Seq[NamedExpression]): Partitioning = {
      
      val projection = new ExpressionProjection(projectList)

      val projectedExprs = expressions()
        .map(ex => projection.replaceWithAlias(ex)) // (implicit canBuildFrom)

      if (projectedExprs.exists($anonfun$project$2)) // body $anonfun$project$2 here
        new UnknownPartitioning(this.numPartitions())
      else {
        val newExpressions = projectedExprs.map(_.head) // (impicit canBuildFrom)
        if (newExpressions != this.expressions())
          new HashPartitioning(newExpressions, this.numPartitions())
        else 
          this
      } // else
    } // def
  } // trait

  // these are probably come from Expression Trait/abstract class
  trait Expression {

     def nullable: Boolean =
       false
   
     // ??? something spark related, 
     // but then object HashPartitioning should extend DataType...
     def dataType(): DataType = 
       .MODULE$
     
     def createShuffleSpec(distribution: ClusteredDistribution): ShuffleSpec =
       new HashShuffleSpec(this, distribution)
   
     def partitionIdExpression(): Expression =
       new Pmod( // Pmod should extend Expression
         new Murmur3Hash(this.expressions()),
         // org.apache.spark.sql.catalyst.expressions.Literal
         Literal(this.numPartitions), // expects java Integer (actually Object, Any), not an int (Scala's Int is a primitive)
         // org.apache.spark.sql.catalyst.expressions.Pmod
         Pmod() // apply$default$3() is one of Pmod.apply overloads without 3rd parameter
                // since Pmod has constructor with 3 parameters Pmod.apply(A, B, C): Pmod
                // here we have ETA to function Pmod.apply(A, B): Pmod which is (A, B) => Pmod
       ) 

  }

}

// this whole class (object) is created automatically by scala compiler due to `case` class notation
// `$` in the end is the convention for every object in Scala
object HashPartitioning
  // apply should be able to be used as lambda, 
  // so we need to extend (Seq[Expression], Object) => HashPartitioning, since we have case class 2 members
  extends AbstractFunction2[Seq[Expression], Object, HashPartitioning]
  with Serializable

  // MODULE$ is a synthetic method to access HashPartitioning instance, added by the compiler
  // public static HashPartitioning$ MODULE$;

  // Java's static initialization block added by the compiler to create the intstance
  // static { new HashPartitioning$(); }
  
  // constructor is private, so nobody can make instance, only by static initialization block
  // private HashPartitioning$() {
  //  MODULE$ = this;
  // }

  // object instance accessor(compiler-level)
  // private Object readResolve() {
  //   return MODULE$;
  // }

  // toString implementation due to `case` class notation (added by the compiler automatically) 
  // public final String toString() {
  //   return "HashPartitioning";
  // }

  // apply implementation due to `case` class notation (added by the compiler automatically)
  // def apply(expressions: Seq[Expression], numPartitions: Int): HashPartitioning = ???

  // unapply implementation due to `case` class notation (added by the compiler automatically)
  // here we have Object and boxing Java's int (Scala's Int) => java Integer 
  // def unapply(HashPartitioning x$0): Option[(Seq[Expression], Object)]

  // synthetic method to ensure compatibility due to Java Generics erasure
  // created by the compiler
  // in our case Seq[Expression], 
  // public Object apply(final Object v1, final Object v2) {
  //  return this.apply((Seq)v1, BoxesRunTime.unboxToInt(v2));
  // }

}
