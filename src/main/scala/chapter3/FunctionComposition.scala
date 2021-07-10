package learningscala
package chapter3

object FunctionComposition extends App {

//  USING andThen: f andThen g = g(f()) -----------------------------
  val totalCost: Double = 10

  val applyDiscountValFunction = (amount: Double) => {
    val discount = 2
    amount - discount
  }

  val applyTaxValFunction = (amount: Double) => {
    val tax = 1
    amount + tax
  }

  val finalPrice = (applyDiscountValFunction andThen applyTaxValFunction)(totalCost)
  println(finalPrice)

// USING compose: f compose g = f(g()) ---------------------------------------
  val finalPriceWithCompose = (applyTaxValFunction compose applyDiscountValFunction)(totalCost)
  println(finalPriceWithCompose)
}
