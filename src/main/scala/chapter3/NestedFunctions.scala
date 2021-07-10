package learningscala
package chapter3

object NestedFunctions extends App {
  def checkDonutAvailability(donutName: String): Boolean = {
    val listDonutsFromStock: List[String] = List("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")
    donutName.nonEmpty && (listDonutsFromStock contains donutName)
  }

  def checkDonutAvailabilityWithNestedFunction(donutName: String): Boolean = {
    val listDonutsFromStock: List[String] = List("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")

    val validate = (name: String) => {
      name.nonEmpty
    }
    validate(donutName) && (listDonutsFromStock contains donutName)
  }


}
