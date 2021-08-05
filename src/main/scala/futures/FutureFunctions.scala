package learningscala
package futures

import futures.FutureBasics.donutStock

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FutureFunctions extends App {

  val listOfFutures: List[Future[Int]] = List(
    donutStock("vanilla donut"),
    donutStock("ciao"),
    donutStock("strawberry")
  )

  val futureFirstCompletedResult = Future.firstCompletedOf(listOfFutures)
  futureFirstCompletedResult.onComplete {
    case Success(value) => println(s"results: $value")
    case Failure(exception) => println(s"error: ${exception.getMessage}")
  }

//  zip: function that permits to zip the results of two futures into a tuple
//  zipWith: same as zip, but applies a given function to the results

//  andThen: used to apply a side-effect function to the future result
  donutStock("vanilla donut").andThen { case quantity => println(quantity.getOrElse(0)) }

//  recover: ----------------------------------------------------------------------------------------
  def donutStock(donut: String): Future[Int] = Future {
    donut match {
      case "vanilla donut" => 10
      case _ => throw new IllegalStateException("Out of Stock")
    }
  }

  donutStock("ciao").onComplete {
    case Success(value) => println(s"Results: $value")
    case Failure(exception) => println(s"Error: ${exception.getMessage}")
  }

//  how to recover?
  donutStock("ciao")
    .recover {case exception: IllegalStateException if exception.getMessage == "Out of Stock" => 0 }
    .onComplete {
      case Success(value) => println(s"Results: $value")
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }
//  you can use recoverWith for returning a future type
  donutStock("ciao")
    .recoverWith {case exception: IllegalStateException if exception.getMessage == "Out of Stock" => Future.successful(0) }
    .onComplete {
      case Success(value) => println(s"Results: $value")
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }
//  --------------------------------------------------------------------------------------------------------
//  fallBackTo(): provide a function to execute in case of failure
  def alternativeStock(donut: String): Future[Int] = Future {
    println("Looking in backup stock")
    donut match {
      case "vanilla donut" => 20
      case _ => 5
    }
  }
  donutStock("ciao")
    .fallbackTo(alternativeStock("vanilla donut"))
    .onComplete {
      case Success(value) => println(s"Results: $value")
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }

}
