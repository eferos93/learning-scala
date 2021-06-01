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

}
