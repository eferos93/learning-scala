package learningscala
package chapter3

object ImplicitFunctions extends App {
  class DonutString(s: String) {
    def isFavouriteDonut: Boolean = s == "Glazed Donut"
  }

  object DonutConversions {
    implicit def stringToDonutString(s: String): DonutString = new DonutString(s)
  }

  import DonutConversions._
  //  println("\nStep 4: How to create String values")
  val glazedDonut = "Glazed Donut"
  val vanillaDonut = "Vanilla Donut"

  println("\nStep 5: How to access the custom String function called isFavaoriteDonut")
  println(s"Is Glazed Donut my favorite Donut = ${glazedDonut.isFavouriteDonut}")
  println(s"Is Vanilla Donut my favorite Donut = ${vanillaDonut.isFavouriteDonut}")
}