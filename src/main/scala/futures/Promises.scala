package learningscala
package futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success, Try}
object Promises extends App {
  def donutStockNormal(donut: String): Int = {
    if(donut == "vanilla donut") 10
    else throw new IllegalStateException("Out of stock")
  }

  val donutPromise = Promise[Int]()

//  with the promise we capture the intent of out method
  val donutStockFuture = donutPromise.future
  donutStockFuture.onComplete {
    case Success(value) => println(s"stock for vanilla donut = $value")
    case Failure(exception) => println(s"Error, failed to find vanilla stock: ${exception.getMessage}")
  }

  val donut = "vanilla donut"
  if(donut == "vanilla donut") {
    donutPromise.success(donutStockNormal(donut))
  } else {
    donutPromise.failure(Try(donutStockNormal(donut)).failed.get)
  }
//
//  val donutStockPromise2 = Promise[Int]()
//  val donutStockFuture2 = donutStockPromise2.future
//  donutStockFuture2.onComplete {
//    case Success(stock) => println(s"Stock for vanilla donut = $stock")
//    case Failure(e)     => println(s"Failed to find vanilla donut stock, exception = $e")
//  }
//  donutStockPromise2.complete(Try(donutStockNormal("unknown donut")))

  Thread.sleep(3000)
}
