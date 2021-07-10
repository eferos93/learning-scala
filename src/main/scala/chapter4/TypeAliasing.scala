package learningscala
package chapter4

object TypeAliasing extends App {
  case class Donut(name: String, price: Double, productCode: Option[Long] = None)

//  I create an alias for the type Tuple2[Donut, Int]
  type CartItem[Donut, Int] = (Donut, Int)
  val cartItem = new CartItem(Donut("Vanilla", 5), 2)
}
