package learningscala
package chapter4

object ClassedAndObjects extends App {
  class Donut(name: String, productCode: Long) {
    def print(): Unit = println(s"Donut name = $name, productCode = $productCode")
  }
}
