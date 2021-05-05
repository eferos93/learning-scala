package learningscala
package chapter2.loops

object range extends App {
  val from1to5 = 1 to 5
  println(s"Range: $from1to5")
//  exclusiver
  val from1to5Exclusive = 1 until 5

//  setting the step
  val from1to10by2 = 1 to 10 by 2

//  alphabetical range (can apply the step operator too)
  val alphabet = 'a' to 'z'

//  convert into collections
  val list1to5 = (1 to 5).toList // toSet, toSeq, toArray
//  println(s"list: ${list1to5.mkString(" ")}")
  list1to5.foreach(print(_))
}
