package learningscala
package chapter4

object TypedClass extends App {
  abstract class Donut(name: String) {
    def printName(): Unit
  }

  case class VanillaDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  case class GlazedDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

//  define a class that expects a particular type parameter
//  [D <: Donut] restricts generic type to Donut type
  class  ShoppingCart[D <: Donut](donuts: Seq[D]) {
    def printCartItems(): Unit = donuts.foreach(_.printName())
  }

  val vanillaDonut: VanillaDonut = VanillaDonut("Vanilla Donut")

//  this line gives compilation error as
//  ShoppingCart[VanillaDonut] is NOT considered a subtype of ShoppingCart[Donut]
//  val shoppingCart: ShoppingCart[Donut] = new ShoppingCart[VanillaDonut](Seq(vanillaDonut))

//  this line also gives compiler error obiviously
//  val shoppingCart: ShoppingCart[String] = new ShoppingCart(Seq("VanillaDonut"))

// COVARIANCE ---------------------------------------------------------------------------------------------------
  class ShoppingCart2[+D <: Donut](donuts: Seq[D]) {
    def printCartItems(): Unit = donuts.foreach(_.printName())
  }
//  A type parameter T of a generic class is made covariant with
//  +T, thus for some class C[+T], it implies that if two types A, B where
//  B <: A then C[B] <: C[A]
//  so, in this case, what written in line 26 works
  val shoppingCart2: ShoppingCart2[Donut] = new ShoppingCart2[VanillaDonut](Seq(VanillaDonut("Vanilla Donut")))

//  CONTRAVARIANCE -------------------------------------------------------------------------------------------------
  class ShoppingCart3[-D <: Donut](donuts: Seq[D]) {
    def printCartItems(): Unit = donuts.foreach(_.printName())
  }
// at the contrary, contravariance permits to have a contravariant type T, with notation -T
//  s.t. for some class C[-T], it implies that if two types A and B where B <: A then C[A] <: C[B]
//  therefore, the following is valid
  val shoppingCart3: ShoppingCart3[VanillaDonut] = new ShoppingCart3[Donut](Seq(GlazedDonut("Glazed Donut")))

}
