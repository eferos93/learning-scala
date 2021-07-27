package learningscala
package chapter4

object PackageObjects extends App {
//  useful to package common objects and implicit conversions

  val vanillaDonut: Donut = Donut("Vanilla", 1.5)
  println(vanillaDonut.uuid)
}
