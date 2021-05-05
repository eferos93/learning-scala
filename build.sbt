name := "learning-scala"

version := "0.1"

scalaVersion := "2.13.5"

idePackagePrefix := Some("learningscala")

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.3",
  "ch.qos.logback" % "logback-classic" % "1.3.0-alpha5"
)
