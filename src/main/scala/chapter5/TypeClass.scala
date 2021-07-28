package learningscala
package chapter5

// http://allaboutscala.com/tutorials/chapter-5-traits/type-class-for-adhoc-polymorphism/
object TypeClass extends App {
  case class Donut(name: String, price: Double, productCode: Option[Long] = None)
  case class CupCake(name: String)

  trait UniversalId[T] {
    def uuid(t: T): String
  }

  object UniversalId {
//    the implicit parameter is a trigger for the compiler to look for
//    implicit values that match the UniversalId[T] types
    def apply[T](implicit id: UniversalId[T]): UniversalId[T] = id

    object Instances {
      def instance[T](func: T => String): UniversalId[T] =
        (t: T) => func(t) // creates an instance of UniversalId[T] with the body of the method as the function defined here

      implicit val donutId: UniversalId[Donut] =
        instance(donut => s"${donut.name} - ${donut.name.hashCode}")

      implicit val cupcakeId: UniversalId[CupCake] =
        instance(cupcake => s"${cupcake.name} - ${cupcake.name.hashCode}")

    }
    object ops {
//       note how the implicit class makes use of the CONTEXT BOUND
//       [T: UniversalId], which role is to enforce that a required implicit value
//       of type UniversalId[T] is in scope
      implicit class UniversalOps[T: UniversalId](t: T) {
        def uniqueId(): String = UniversalId[T].uuid(t)
      }
    }



  }

  import UniversalId.ops._
  import UniversalId.Instances._
  val plainDonut = Donut("PlainDonut", 1.5)
  println(plainDonut.uniqueId())
  val cupCake = CupCake("VanillaCupCake")
  println(cupCake.uniqueId())



}
