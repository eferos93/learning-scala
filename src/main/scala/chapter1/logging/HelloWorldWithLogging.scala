package learningscala
package chapter1.logging

import com.typesafe.scalalogging.LazyLogging

// LazyLogging is a trait
object HelloWorldWithLogging extends App with LazyLogging {
  logger.info("Hello World from Logger")
}
