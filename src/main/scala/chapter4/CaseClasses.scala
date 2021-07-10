package learningscala
package chapter4

object CaseClasses extends App {
//  A case class is similar to a class, but it creates also
//  its companion object
//  case class also creates hashcode(), equals() and copy()
  case class Donut(name: String, price: Double, productCode: Option[Long] = None)
//  you do not need new keyword
  val glazedDonut = Donut("Glazed donut", 5)
}
