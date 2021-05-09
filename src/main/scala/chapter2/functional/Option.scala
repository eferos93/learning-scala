package learningscala
package chapter2.functional

object Option extends App {
  val glazedDonutTaste: Option[String] = Some("Very Tasty")
  println(s"Glazed donut taste: ${glazedDonutTaste.get}")

//  .get() would throw a NoSuchElementExc if there is None
  val glazedDonutName: Option[String] = None
  println(s"Glazed Donut name: ${glazedDonutName.getOrElse("Glazed Donut")}")

//  Option and pattern matching
  glazedDonutName match {
    case Some(name) => println(s"Receiving donut name: $name")
    case None => println("No donut name found!")
  }

//  if you want to filtering out None, you can user foreach
  glazedDonutName.foreach(name => println(name)) // it will do nothing
  glazedDonutTaste.foreach(taste => println(taste))


}
