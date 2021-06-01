package learningscala
package chapter3

object FunctionsAsSymbols extends App {

  class DonutCostCalculator {
    val totalCost = 100

    def minusDiscount(discount: Double): Double = {
      totalCost - discount
    }

    def -(discount: Double): Double = {
      totalCost - discount
    }
  }

  val donutCostCalculator = new DonutCostCalculator()

  println(donutCostCalculator.-(3.0))
//  or
  println(donutCostCalculator - 5.0)
}
