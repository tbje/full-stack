lazy val client = (project in file("js")).settings(
  scalaVersion := Version.scala,
  scalaJSUseMainModuleInitializer := true,
).enablePlugins(ScalaJSPlugin)


scalaVersion := Version.scala
