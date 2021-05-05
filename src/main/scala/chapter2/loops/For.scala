package learningscala
package chapter2.loops

object For extends App {
  for (numberOfDonuts <- 1 to 5) {
    println(s"i am donut number $numberOfDonuts")
  }

//  not inclusive loop
  for (numberOfDonuts <- 1 until 5) {
    println(s"i am donut number $numberOfDonuts")
  }

//  list
  val donutIngredients = List("flour", "sugar", "egg", "syrup")
  for (ingredient <- donutIngredients if ingredient == "sugar") {
    println(s"Found sweetening ingredient: $ingredient")
  }

//  Filter values using if conditions in for loop and return the result back using the yield keyword
  val sweeteningIngredients = for {
    ingredient <- donutIngredients
    if ingredient == "sugar" || ingredient == "syrup"
  } yield ingredient

//  for for two dim array

  val twoDimArray = Array.ofDim[String](2, 2)
  twoDimArray(0)(0) = "flour"
  twoDimArray(0)(1) = "sugar"
  twoDimArray(1)(0) = "egg"
  twoDimArray(1)(1) = "syrup"

  for {
    x <- 0 until 2
    y <- 0 until 2
  } println(s"donut ingredient at index ${(x,y)} = ${twoDimArray(x)(y)}")
}
