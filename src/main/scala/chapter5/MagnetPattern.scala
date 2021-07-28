package learningscala
package chapter5

object MagnetPattern extends App {
//  magnet pattern is useful to provide different overloaded methods that
//  are type safe
//def applyDiscount(couponCode: String): Unit =
//  println(s"Lookup percentage discount in database for $couponCode")
//
//  def applyDiscount(percentageDiscount: Double): Unit =
//    println(s"$percentageDiscount discount will be applied")

  // step 1: define magnet trait to express the parameters and return type of the overloaded functions
  import scala.language.implicitConversions
  sealed trait MagnetDiscount {
    type Out // we could define this as a type parameter instead of type member
    def apply(): Out
  }
//  step 2: define discount funct that takes the magnet as parameter
  def discount(magnet: MagnetDiscount): magnet.Out = magnet() // this will call apply()

  object MagnetDiscount {
    implicit def discountStringCouponCode(couponCode: String) =
      new MagnetDiscount {
        override type Out = Unit

        override def apply(): Out = println(s"MagnetDiscout->discountStringCouponCode($couponCode)")
      }

    implicit def discountDoubleCouponCode(percentageDiscount: Double) =
      new MagnetDiscount {
        override type Out = Double

        override def apply(): Out =  {
          println(s"MagnetDiscount->discountDoubleCouponCode($percentageDiscount%)")
          percentageDiscount
        }
      }
  }

  discount("COUPON_1234")
  discount(15.0)
//  why using magnet patter?
//  the following will return a compiler error as they will have the same tipe after erasure
//  def applyDiscount(coupons: List[String]): Unit = ???
//  def applyDiscount(coupons: List[Int]): Unit = ???
//  cause type erasure will not consider the type parameters
//  with magnet patter you just add two new implicit functions like we did before and it will work
}
