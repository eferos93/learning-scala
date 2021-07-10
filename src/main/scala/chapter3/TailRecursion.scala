package learningscala
package chapter3

object TailRecursion extends App {
  val arrayDonuts: Array[String] = Array("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")

//  annotation will optimize the code and transform it into a loop

  @annotation.tailrec
  def search(donutName: String, donuts: Array[String], index: Int): Option[Boolean] = {
    if (donuts.length == index) {
      None
    } else if(donuts(index) == donutName) {
      Some(true)
    } else {
      search(donutName, donuts, index + 1)
    }
  }

//  TAIL REC WITH scala.util.control.TailCall
  import scala.util.control.TailCalls._

  def tailSearch(donutName: String, donuts: Array[String], index: Int): TailRec[Option[Boolean]] = {
    if(donuts.length == index) {
      done(None) // NOTE: done is imported from scala.util.control.TailCalls._
    } else if(donuts(index) == donutName) {
      done(Some(true))
    } else {
      val nextIndex = index + 1
      tailcall(tailSearch(donutName, donuts, nextIndex)) // NOTE: tailcall is imported from  scala.util.control.TailCalls._
    }
  }

  val tailFound = tailcall(tailSearch("Glazed Donut", arrayDonuts, 0))
  println(tailFound.result)
}
