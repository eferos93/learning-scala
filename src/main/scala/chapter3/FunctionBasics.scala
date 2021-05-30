package learningscala
package chapter3

object FunctionBasics extends App{
  def calculateCost(donutName: String,
                    quantity: Int,
                    couponCode: Option[String] = None): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity, couponCode = $couponCode")
    couponCode match {
      case Some(_) =>
        val discount = 0.1
        val totalCost = 2.5 * quantity * (1 - discount)
        totalCost
      case _ => 2.5 * quantity
    }
  }


  def dailyCouponCode(): Option[String] = {
    // look up in database if we will provide our customers with a coupon today
    val couponFromDb = "COUPON_1234"
    Option(couponFromDb).filter(_.nonEmpty)
  }

  val coupon: Option[String] = dailyCouponCode()
  println(s"Coupon code ${coupon.getOrElse("No Coupon!")}")
//  or
  val coupon2: String = dailyCouponCode().fold("No coupon Available!")(couponCode => couponCode)
  println(s"Coupon code extracted with fold: ${coupon2}")
}
