package learningscala
package chapter3

object CurriedFunctions extends App {

//  curried function
  def totalCost(donutType: String)(quantity: Int)(discount: Double): Double = {
    println(s"Calculating total cost for $quantity $donutType with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }

  println(totalCost("Ciao")(2)(0.05))


//  PARTIALLY APPLIED FUNCTION FROM A CURRIED FUNCTION

//  the type of this funct is Int => Double => Double. Recall Haskell
  val totalCostForGlazedDonuts = totalCost("Glazed Donut") _

  println(totalCostForGlazedDonuts(2)(0.07))
}
