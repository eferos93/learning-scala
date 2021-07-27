package learningscala
package chapter5

import chapter2.oop.TailWagger

object Traits extends App {
//  a trait is like an interface in java:
//  it cannot be instantiated, cannot have parameters
//  but they can have concrete functions
//  abstract methods needs to be implemented of course
//  traits can have type parameters
  trait Speaker {
    def speak(): String
  }
  trait TailWinger {
    def startTail(): Unit = println("tail is wagging")
    def stopTail(): Unit = println("tail is stopped")
  }
  trait Runner {
    def startRunning(): Unit = println("I am running")
    def stopRunning(): Unit = println("Stopped running")
  }

  class Dog(name: String) extends Speaker with TailWagger with Runner {
    def speak(): String = "Woof!"
  }

//  or you can add traits when creating an instance of a class
  class Dog2(name: String)
  val dog = new Dog2("Fido") with TailWagger with Runner
}
