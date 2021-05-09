package learningscala
package chapter2.functional

object Tuples extends App {
  println("Step 1: Using Tuple2 to store 2 data points")
  val glazedDonutTuple = Tuple2("Glazed Donut", "Very Tasty")
  println(s"Glazed Donut with 2 data points = $glazedDonutTuple")

//  accessing typle elems
  val donutType = glazedDonutTuple._1
  val donutTaste = glazedDonutTuple._2

//  you can use Tuple3, Tuple4,.....

  val glazedDonut = Tuple3("Glazed Donut", "Very Tasty", 2.50)
  val strawberryDonut = Tuple3("Strawberry Donut", "Very Tasty", 2.50)
  val plainDonut = Tuple3("Plain Donut", "Tasty", 2)

  val donutList = List(glazedDonut, strawberryDonut, plainDonut)

//  PATTERN MATCHING
  val priceOfDonut: Unit = donutList.foreach {
    case ("Plain Donut", _, price) => println(s"Donut type = Plain Donut, price = $price")
    case d if d._1 == "Glazed Donut" => println(s"Donut type = ${d._1}, price = ${d._3}")
    case _ => None
  }

//  tuples can be created with the following SHORTCUT
  val chocolateDonut = ("Chocolate Donut", "Very Tasty", 3.0)
}
