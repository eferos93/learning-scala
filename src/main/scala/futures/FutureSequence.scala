package learningscala
package futures
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FutureSequence extends App {

  def donutStocks(donut: String): Future[Option[Int]] = Future {
//    println("getting donut stock, sleep for 2s")
    Thread.sleep(2000)
    donut match {
      case "vanilla donut" => Some(10)
      case _ => None
    }
  }

  def buyDonuts(quantity: Int): Future[Boolean] = Future {
//    println("buying donuts, sleep for 3s")
    Thread.sleep(3000)
    quantity > 0
  }

  def processPayment(): Future[Unit] = Future {
    println("processing payment, sleep for 1s")
    Thread.sleep(1000)
  }

  val futureSeq: List[Future[Any]] = List(donutStocks("vanilla donut"), buyDonuts(10), processPayment())
  val futureSeqResult = Future.sequence(futureSeq)
  futureSeqResult.onComplete {
    case Success(value) => println(s"Results: $value")
    case Failure(exception) => println(s"Error: ${exception.getMessage}")
  }

//  Future.traverse is similar to Future.sequence, but it lets apply operations

  val futureOperations = List(
    donutStocks("vanilla donut"),
    donutStocks("plain donut"),
    donutStocks("chocolate donut")
  )

  val futureTraversalResult = Future.traverse(futureOperations){
    futureSomeQuantity =>
      futureSomeQuantity.map(someQuantity => someQuantity.getOrElse(0))
  }

  futureTraversalResult.onComplete {
    case Success(value) => println(s"result: $value")
    case Failure(exception) => println(s"Error: ${exception.getMessage}")
  }

// OTHER USEFUL FUNCTIONS ARE
//  Future.foldLeft (or right)
//  Future.reduceLeft (or right)
}
