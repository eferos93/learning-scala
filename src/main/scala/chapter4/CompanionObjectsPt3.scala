package learningscala
package chapter4

object CompanionObjectsPt3 extends App {
  class Donut(name: String, productCode: Option[Long] = None){

    def print(): Unit = println(s"Donut name = $name, productCode = ${productCode.getOrElse(0)}, uuid = ${Donut.uuid}")

  }

  object Donut {
    private val uuid = 1

    def apply(name: String, productCode: Option[Long]): Donut = {
      new Donut(name, productCode)
    }

    def apply(name: String): Donut = {
      new Donut(name)
    }
  }
}
