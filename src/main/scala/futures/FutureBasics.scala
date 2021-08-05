package learningscala
package futures
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureBasics extends App {
  def donutStock(donut: String): Future[Option[Int]] = Future {
    println("checking donut stock")
    donut match {
      case "vanilla donut" => Some(10)
      case _ => None
    }
  }

  def buyDonuts(quantity: Int): Future[Boolean] = Future {
    println(s"buying $quantity donuts")
    quantity > 0
  }

  donutStock("vanilla donut").onComplete{
    stock =>
      println(stock.getOrElse(0))
  }

//  we can combine results of different futures

  val resultWithFlatMap: Future[Boolean] =
    donutStock("vanilla donut")
    .flatMap(stock => buyDonuts(stock.getOrElse(0)))

  val resultWithMap: Future[Future[Boolean]] =
    donutStock("vanilla donut")
      .map(stock => buyDonuts(stock.getOrElse(0)))
}
