package learningscala
package chapter4

object CompanionObjects extends App {
  class Donut(name: String, productCode: Long) {
    def print(): Unit = println(s"Donut name = $name, productCode = $productCode")
  }
//  now we create a Companion Object for the donut class
// companion object should have the same name as the companion class
  object Donut {
//  should define also the method apply, that is essentialy a factory method
    def apply(name: String, productCode: Long): Donut = {
      new Donut(name, productCode)
    }
  }

//  now, to create an instance, we don't need the new keyword
  val donut = Donut("Glazed", 1111)
}
