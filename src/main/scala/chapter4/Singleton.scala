package learningscala
package chapter4

object Singleton extends App {

//  this is a singleton
  object DonutShoppingCartCalculator {

//  discount is a global field (a class field would be called in java)
    val discount: Double = 0.01
  }


}
