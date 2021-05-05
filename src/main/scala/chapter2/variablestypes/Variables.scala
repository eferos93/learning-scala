package learningscala
package chapter2.variablestypes

object Variables extends App {
//  IMMUTABLE VAR (you cannot reassign it)
  val donutsToBuy: Int = 5
//  MUTABLE VAR
  var bananasToBuy: Int = 5
//  bananasToBuy = "Ciao" ==> type mismatch!
  bananasToBuy = 8

//  LAZY indication: variable is initialised only when it is consumed by the app
  lazy val donutService = "init donut service"

//  var with no initialisation
  var leastFavoriteDonut: String = _ // _ is the wildcard operator



}
