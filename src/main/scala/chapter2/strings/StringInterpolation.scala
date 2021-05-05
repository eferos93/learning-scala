package learningscala
package chapter2.strings

object StringInterpolation extends App {
  val favoriteDonut: String = "Glazed Donut"
  println(s"My favourite donut: $favoriteDonut")

//  string interp. with object properties
//  for now see a case class as a Plain Old Java Object (object with just getters and setters)
  case class Donut(name: String, tasteLevel: String)

  val secondFavouriteDonut: Donut = Donut("glazed donut", "tastyyy")
  println(s"My favourite donut name ${secondFavouriteDonut.name}, taste level ${secondFavouriteDonut.tasteLevel}")

//  evaluate expressions
  val numberOfDonuts = 10
  println(s"Are we buying 10 donuts? ${numberOfDonuts == 10}")

//  formatting text
  val donutName = "Vanilla Donut"
  val donutTasteLevel = "Super tasty"
// prepends 20 white spaces
  println(f"$donutName%20s $donutTasteLevel")

//  format numbers
  val donutPrice = 2.5
  println(s"Donut price: $donutPrice")
  println(f"Donut price formatted: $donutPrice%.2f")

//  raw interpolation: symbols like \t are now evaluated, they are treated as string
  println(raw"Favourite donut \t$donutName")
}
