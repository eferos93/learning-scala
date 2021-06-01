package learningscala
package chapter3

object GenericTypedFunctions extends App {

  def applyDiscount[T](discount: T): Unit = {
    discount match {
      case d: String =>
        println(s"Lookup percentage discount in database for $d")
      case d: Double =>
        println(s"Apply discount $d")
      case _ =>
        println(s"Unsupported Discount type")
    }
  }

//  how to call it
  applyDiscount("Coupon123")
  applyDiscount(10)
  applyDiscount(10.0)
//  explicit
  applyDiscount[String]("Coupon123")
  applyDiscount[Double](10)

//  POLYMORPHIC TYPED FUNCTIONS
  def applyDiscountWithReturnType[T](discount: T): Seq[T] = {
    discount match {
      case d: String =>
        println(s"Lookup percentage discount in database for $d")
        Seq[T](discount)
      case d: Double =>
        println(s"Apply discount $d")
        Seq[T](discount)
      case _ =>
        println("Unsupported disocunt type")
        Seq[T](discount)
    }
  }

  println("\nStep 4: How to call a generic typed function which also has a generic return type")
  println(s"Result of applyDiscountWithReturnType with String parameter = ${applyDiscountWithReturnType[String]("COUPON_123")}")

  println()
  println(s"Result of applyDiscountWithReturnType with Double parameter = ${applyDiscountWithReturnType[Double](10.5)}")

  println()
  println(s"Result of applyDiscountWithReturnType with Char parameter = ${applyDiscountWithReturnType[Char]('U')}")
}
