object Version {
  val scala          = "2.13.2"
}

object Deps {
  import sbt._
  import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
  import org.scalajs.sbtplugin.ScalaJSPlugin
  import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

  val client = Def.setting(
    "io.github.cquiroz"          %%% "scala-java-time"      % "2.0.0" ::
    "io.github.cquiroz"          %%% "scala-java-time-tzdb" % "2.0.0" ::
    Nil)
}
