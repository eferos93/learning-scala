package learningscala
package chapter4

object CompanionObjectPt2 extends App {
  class Donut(name: String, productCode: Option[Long] = None) {
    def print(): Unit = println(s"Donut name = $name, productCode = $productCode")
  }

  class GlazedDonut(name: String) extends Donut(name)
  class VanillaDonut(name: String) extends Donut(name)

  object Donut {
    def apply(name: String): Donut = {
      name match {
        case "Glazed Donut" => new GlazedDonut(name)
        case "Vanilla Donut" => new VanillaDonut(name)
        case _ => new Donut(name)
      }
    }
  }
}
