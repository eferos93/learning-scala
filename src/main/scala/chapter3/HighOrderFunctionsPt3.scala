package learningscala
package chapter3

object HighOrderFunctionsPt3 extends App {

//  call-by-name callbacks
  def printReport(sendEmailCallback: Option[() => Unit]): Unit = {
    println("Pirnting report... started")
    println("Printing report... finished")
    sendEmailCallback.foreach(callback => callback())
  }
}
