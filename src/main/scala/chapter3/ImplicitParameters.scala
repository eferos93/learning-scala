package learningscala
package chapter3

object ImplicitParameters extends App {
//  in the same scope, we must define an implicit value discount
  def totalCost(donutType: String, quantity: Int)(implicit discount: Double): Double = {
    println(s"Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }
  implicit val discount: Double = 0.1
  println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost("Glazed Donut", 5)}""")
//  how to pass the implicit parameters manually
  println(s"${totalCost("Tasty", 5)(0.3)}")
//  It is a good practice to encapsulate your implicit values into an Object or a Package Object.
}
