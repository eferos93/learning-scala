package learningscala
package chapter1.runconfig

object HelloWorldWithArguments extends App {
  println("Hello with args")
  println("Command line args: ")
//  remember to set up the run config
  println(args.mkString(", "))
}
