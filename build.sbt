name := "introcs-scala-examples"

version := "0.0.1"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.0.1-SNAP" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.1" % "test"
)

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")
