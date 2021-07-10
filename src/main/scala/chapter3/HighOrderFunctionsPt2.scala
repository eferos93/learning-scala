package learningscala
package chapter3

import scala.util.Random

object HighOrderFunctionsPt2 extends App {
  val listOrders = List(("Glazed donut", 5, 2.5), ("Vanilla Donut", 10, 3.5))

//  CALL-BY-VALUE function
//  here parameter exchangeRate: meaning that any exchange rate passed through is evaluated once
  def placeOrder(orders: List[(String, Int, Double)])(exchangeRate: Double): Double = {
    orders.map{order =>
      order._2 * order._3 * exchangeRate
    }.sum
  }

//  CALL-BY-NAME functions
//  here will evaluate any exchangeRate function each time it is called
  def placeOrderWithByNameParameter(orders: List[(String, Int, Double)])(exchangeRate: => Double): Double = {
    orders.map { order =>
      order._2 * order._3 * exchangeRate
    }.sum
  }

  val randomExchangeRate = new Random(10)
  def usdToGbp: Double = {
    val rate = randomExchangeRate.nextDouble()
    println(s"Rate: $rate")
    rate
  }

//  note that the output of this println shows how the exchange rate is different every time
//  meaning that for each item in the list, an exchangerate is created
  println(placeOrderWithByNameParameter(listOrders)(usdToGbp))

//  while in this case, usdToGbp is evaluated only once
  println(placeOrder(listOrders)(usdToGbp))

}
