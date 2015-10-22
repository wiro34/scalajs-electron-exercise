import java.nio.charset.Charset
import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.Keys._

lazy val githubRepo = RootProject(uri("git://github.com/simonlischka/akka.js.git#master"))

lazy val root = (project in file(".")).
  settings(
    name := "Garoonify",
    scalaVersion := "2.11.7",
    resolvers += Resolver.mavenLocal,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
    //libraryDependencies += "scala-js-actors" %%% "scala-js-actors" % "0.1.0-SNAPSHOT",
    libraryDependencies += "akka.js" %%% "akkaactor" % "0.2-SNAPSHOT",
//    jsDependencies += RuntimeDOM,
    skip in packageJSDependencies := false,
    persistLauncher in Compile := true,
    persistLauncher in Test := false
  ).
  enablePlugins(ScalaJSPlugin).
  dependsOn(githubRepo)

val electronMainPath = SettingKey[File]("electron-main-path", "The absolute path where to write the Electron application's main.")

val electronMain = TaskKey[File]("electron-main", "Generate Electron application's main file.")

electronMainPath := {
  baseDirectory.value / "src" / "electron" / "main2.js"
}

// we generate the code for electron's main by aggregating the fastOptJS code, the launcher code and a little hack for the global stuff
// we do not include the jsDependencies in the main (for now)
electronMain := {
  // TODO here we rely on the files written on disk but it would be better to be able to get the actual content directly
  // from the tasks. I am not sure it's possible just yet though.
  val jsCode: String = IO.read((fastOptJS in Compile).value.data, Charset.forName("UTF-8"))
  val launchCode = IO.read((packageScalaJSLauncher in Compile).value.data, Charset.forName("UTF-8"))
  // we don't need jsDeps here but want it to be generated anyway so that we can start the Electron app right away
  val jsDeps = (packageJSDependencies in Compile).value

  // hack to get require and __dirname to work in the main process
  // see https://gitter.im/scala-js/scala-js/archives/2015/04/25
  val hack =
    """
  var addGlobalProps = function(obj) {
    obj.require = require;
    obj.__dirname = __dirname;
  }
  if((typeof __ScalaJSEnv === "object") && typeof __ScalaJSEnv.global === "object") {
    addGlobalProps(__ScalaJSEnv.global);
  } else if(typeof  global === "object") {
    addGlobalProps(global);
  } else if(typeof __ScalaJSEnv === "object") {
    __ScalaJSEnv.global = {};
    addGlobalProps(__ScalaJSEnv.global);
  } else {
    var __ScalaJSEnv = { global: {} };
    addGlobalProps(__ScalaJSEnv.global)
  }
    """

  val dest = electronMainPath.value
  IO.write(dest, hack + jsCode + launchCode, Charset.forName("UTF-8"))
  dest
}
