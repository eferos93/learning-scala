package learningscala
package chapter3

object TrampolineTailRecursion extends App {
  import scala.util.control.TailCalls._
  def verySweetDonut(donutList: List[String]): TailRec[Boolean] = {
    if (donutList.isEmpty) {
      done(false)
    } else {
      if (Set(donutList.head).subsetOf(Set("Vanilla Donut","Strawberry Donut","Glazed Donut"))) {
        done(true)
      } else {
        tailcall(notSweetDonut(donutList))
      }
    }
  }

  def notSweetDonut(donutList: List[String]): TailRec[Boolean] = {
    if (donutList.isEmpty) {
      done(false)
    } else {
      tailcall(verySweetDonut(donutList.tail))
    }
  }
}
