package learningscala
package chapter5

object TraitMixinAndLinearization extends App {

  case class Donut(name: String)

  val donuts = Seq(Donut("PlainDonut"), Donut("VanillaDonut"))

  trait ShoppingCart[T] {
    def printItems(items: Seq[T]): Unit
  }

  class DonutShoppingCart extends ShoppingCart[Donut] {
    override def printItems(items: Seq[Donut]): Unit = {
      items.foreach(println(_))
    }
  }

//  now we have a new requiremnt: print is required in upper case
//  thus we create a trait that extends ShoppingCart
  trait PrettyPrintUpperCase[T] extends ShoppingCart[T] {
    override def printItems(items: Seq[T]): Unit = items.foreach(item => println(item.toString.toUpperCase()))
  }
//  then we can mixin this new trait with an object or instance of
//  DonutShoppingCart
  val donutCartPretty = new DonutShoppingCart() with PrettyPrintUpperCase[Donut]
  donutCartPretty.printItems(donuts)

//  LINEARIZATION ----------------------------------------------------
  trait PrettyPrintLowerCase[T] extends ShoppingCart[T] {
    override def printItems(items: Seq[T]): Unit = items.foreach(item => println(item.toString.toLowerCase))
  }

  val donutCart3 = new DonutShoppingCart() with PrettyPrintUpperCase[Donut] with PrettyPrintLowerCase[Donut]
//  the following will print lower case
//  meaning you should bear in mind with the linearization of traits
//  as the order in which you mixin matters
  donutCart3.printItems(donuts)
}
