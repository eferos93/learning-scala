package learningscala
package chapter3

object HighOrderFunctions extends App {
  println("\nStep 2: How to define a higher order function which takes another function as parameter")
  def totalCostWithDiscountFunctionParameter(donutType: String)
                                            (quantity: Int)
                                            (discount: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $donutType")
    val totalCost = 2.50 * quantity
    discount(totalCost)
  }

//  call it with lambda funct
  val cost =
    totalCostWithDiscountFunctionParameter("Delicious")(3){
      totalCost =>
        val discount = 2
        totalCost - discount
    }
    println(cost)

//  pass a function

  def applyDiscount(totalCost: Double): Double = {
    val discount = 2
    totalCost - discount
  }

  val totalCost =
    totalCostWithDiscountFunctionParameter("fnjsan")(3)(applyDiscount)

  println(totalCost)
}
