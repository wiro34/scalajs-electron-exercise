import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.Keys._

lazy val githubRepo = RootProject(uri("git://github.com/simonlischka/akka.js.git#master"))

lazy val root = (project in file(".")).
  settings(
    name := "Garoonify",
    scalaVersion := "2.11.7",
    resolvers += Resolver.mavenLocal,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    libraryDependencies += "scala-js-actors" %%% "scala-js-actors" % "0.1.0-SNAPSHOT"
  ).
  enablePlugins(ScalaJSPlugin).
  dependsOn(githubRepo)


//
//resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
//
//resolvers += "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
//
//libraryDependencies ++= {
//  Seq(
//    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
//    "akka.js" %%% "akkaactor" % "0.2-SNAPSHOT"
//  )
//}
