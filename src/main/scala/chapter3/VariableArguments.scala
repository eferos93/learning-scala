package learningscala
package chapter3

object VariableArguments extends App {

  def printReport(names: String*): Unit = {
    println(s"""Donut report = ${names.mkString(" - ")}""")
  }

  printReport("Eros", "Marco", "Giulio")

//  can you pass a list?
//  yes, but you need to use TYPE ASCRIPTION
  val listDonuts: List[String] = List("Ciao", "Come", "Stai")

  printReport(listDonuts: _*) // : _* is the type ascription, to use for each type of sequence/array/list

}
