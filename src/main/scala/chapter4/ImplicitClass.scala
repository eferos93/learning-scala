package learningscala
package chapter4

object ImplicitClass extends App {
//  implicit classes are used to extend the functionality
//  of an obj
  case class Donut(name: String, price: Double, productCode: Option[Long] = None)

//  it is a good practice to encapsulate an implicit class inside an obj
  object DonutImplicit {
    implicit class AugmentedDonut(donut: Donut) {
//      methods inside an implicit class are known as extension methods
      def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(124)}"
    }
  }

  val vanillaDonut = Donut("Vanilla donut", 5)

  import DonutImplicit._

  println(s"Vanilla donut uuid: ${vanillaDonut.uuid}")
}
