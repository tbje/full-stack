lazy val client = (project in file("js")).settings(
  scalaVersion := Version.scala,
  scalaJSUseMainModuleInitializer := true,
  libraryDependencies ++= Deps.client.value
).enablePlugins(ScalaJSPlugin)


scalaVersion := Version.scala
