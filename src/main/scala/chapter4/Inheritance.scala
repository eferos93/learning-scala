package learningscala
package chapter4

object Inheritance extends App {
  abstract class Donut(name: String) {
    def printName(): Unit
  }

  class VanillaDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

//  now I create a companion obj for the implementation
  object VanillaDonut {
    def apply(name: String): Donut = new VanillaDonut(name)
  }

//  then, you can you the base type to define a var and assign to it references to subclasses istances, like Java

//  EXTEND CASE CLASSES

  case class StrawberryDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }
}
