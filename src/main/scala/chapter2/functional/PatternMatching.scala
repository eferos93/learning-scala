package learningscala
package chapter2.functional

object PatternMatching extends App {
  println("Step 1: Pattern matching 101 - a very basic example")
  val donutType = "Glazed Donut"
  donutType match {
    case "Glazed Donut" => println("Very tasty")
    case "Plain Donut" => println("Tasty")
  }

  val tasteLevel = donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
  }

  //  wildcard
  val tasteLevel2 = donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }

  //  two or more items on same cond
  val tasteLevel3 = donutType match {
    case "Glazed Donut" | "Strawberry Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }

  //  pattern matching with if clause
  val tasteLevel4 = donutType match {
    case donut if donut.contains("Glazed") || donut.contains("Strawberry") => "Very Tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }

//  pattern matching by type

//  note that Any is the root of Scala's type hierarchy
  val priceOfDonut: Any = 2.5
  val priceType = priceOfDonut match {
    case _: Int => "Int"
    case _: Double => "Double"
    case _: Float => "Float"
    case _: String => "String"
    case _: Boolean => "Boolean"
    case _: Char => "Char"
    case _: Long => "Long"
  }
  println(priceType)

}
