package learningscala
package chapter2.enumerations



object Donut extends Enumeration {
  type Donut = Value
  val Glazed      = Value("Glazed")
  val Strawberry  = Value("Strawberry")
  val Plain       = Value("Plain")
  val Vanilla     = Value("Vanilla")
}

object Enum extends App {
//  print enum value
  println(s"Vanilla's Donut = ${Donut.Vanilla}")
//  print id
  println(s"Vanilla's id ${Donut.Vanilla.id}")
//  iterate and pattern match
  Donut.values.foreach {
    case d if (d == Donut.Strawberry) => println("Favorurite donut!")
    case _ => None
  }
}
