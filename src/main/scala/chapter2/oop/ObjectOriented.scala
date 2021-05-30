package learningscala
package chapter2.oop

//traits
// similar to interfaces, they can have concrete methods and fields

trait Speaker {
  def speak(): String
}

trait TailWagger {
  def startTail(): Unit = println("tail is wagging")
  def stopTail(): Unit = println("tail is stopped")
}

trait Runner {
  def startRunning(): Unit = println("I'm running")
  def stopRunning(): Unit = println("Stopped running")
}

//class Dog(name: String) extends Speaker, TailWagger, Runner {
//  def speak (): String = "Woof!"
//}

//object ObjectOriented extends App {
//
//}
