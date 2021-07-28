package learningscala
package chapter5

object FactoryPattern extends App {
  object Cakes {
    trait Cake {
      def name: String
    }

    class UnknownCake extends Cake {
      override def name: String = "Unknown Cake"
    }

    class Cupcake extends Cake {
      override def name: String = "Cupcake"
    }

    class Donut extends Cake {
      override def name: String = "Donut"
    }
  }

  object CakeFactory {
    import Cakes._

    def apply(cake: String): Cake = {
      case "cupcake" => new Cupcake
      case "donut" => new Donut
      case _ => new UnknownCake
    }
  }
}
