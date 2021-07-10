//name := "learning-scala"
//
//version := "0.1"
//
//scalaVersion := "2.13.5"

idePackagePrefix := Some("learningscala")

//libraryDependencies ++= Seq(
//  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.3",
//  "ch.qos.logback" % "logback-classic" % "1.3.0-alpha5"
//)

lazy val artifacts = new {
  // artifacts versions
  val scalaV            = "2.13.5"
  val realworldAllaboutscalaV = "1.0"
  val akkaActorV        = "2.6.14"
  val akkaHttpV         = "10.2.4"
  val akkaHttpTestkitV  = "10.2.4"
  val scalaLoggingV     = "3.9.3"
  val logbackV          = "1.3.0-alpha5"
  val scalaTestV        = "3.2.2"
  val pureconfigV       = "0.11.1"

  val akkaHttp = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaActorV,
    "com.typesafe.akka" %% "akka-stream" % akkaActorV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.akka" %% "akka-testkit" % akkaActorV % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpTestkitV % "test"
  )

  val scalaLogging = Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingV,
    "ch.qos.logback" % "logback-classic" % logbackV
  )

//  val jodaTime = Seq(
//    "joda-time" % "joda-time" % "2.10.11-SNAPSHOT",
//    "org.joda" % "joda-convert" % "1.8"
//  )

  val scalatest = Seq("org.scalatest" %% "scalatest" % scalaTestV % "test")
  val pureconfig = Seq("com.github.pureconfig" %% "pureconfig" % pureconfigV)
}

lazy val commonSettings = Seq(
  organization          := "com.realworld.allaboutscala",
  scalaVersion          := artifacts.scalaV,
  version               := artifacts.realworldAllaboutscalaV,
  logLevel              := Level.Info,
  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-Xfatal-warnings",
    "-deprecation",
    "-feature",
    "-unchecked",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-language:existentials",
    "-language:postfixOps",
    "-Ywarn-dead-code"
  )
)

lazy val testSettings = Seq(
  Test / fork := false,
  Test / parallelExecution := false,
  libraryDependencies ++= artifacts.scalatest
)

lazy val realWorldAllAboutScala = (project in file("."))
  .settings(name:= "learning-scala")
  .settings(commonSettings: _*)
  .settings(testSettings: _*)
  .settings(libraryDependencies ++= artifacts.scalaLogging ++ artifacts.akkaHttp ++ artifacts.pureconfig)
  .settings(resolvers += Resolver.sonatypeRepo("releases"))
  .settings(resolvers += Resolver.sonatypeRepo("snapshots"))