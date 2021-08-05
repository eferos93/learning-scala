package learningscala
package chapter3

object PartialFunctions extends App {
  val donut = "Glazed Donut"
  val tasteLevel = donut match {
    case "Glazed Donut" | "Strawberry Donut" => "Very Tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }


//  this function will throw scala.MatchError if it does not have a matching case
  val isVeryTasty: PartialFunction[String, String] = {
    case "Glazed Donut" | "Strawberry Donut" => "Very Tasty"
  }

  val isTasty: PartialFunction[String, String] = {
    case "Plain Donut" => "Tasty"
  }

  val unknownTaste: PartialFunction[String, String] = {
//        operator @ binds a matched pattern (in this case _) to a variable
//        (in this case, donut)
    case donut @ _ => s"unknown taste for donut $donut"
  }

  val donutTaste = isVeryTasty orElse isTasty orElse unknownTaste

}
