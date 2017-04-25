import NativePackagerHelper._
import de.heikoseeberger.sbtheader.HeaderPattern
import de.heikoseeberger.sbtheader.license.Apache2_0
import de.heikoseeberger.sbtheader.CommentStyleMapping._

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(AutomateHeaderPlugin)
  .configs( IntegrationTest )
  .settings( Defaults.itSettings : _* )
  .settings(
    inThisBuild(List(
      organization := "org.northrop.leanne",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "projectnamenotdefined",
    libraryDependencies ++= App() ++ Test(),
    scalaSource in IntegrationTest <<= baseDirectory / "src/it/scala",
    resourceDirectory in IntegrationTest <<= baseDirectory / "src/it/resources",
    parallelExecution in IntegrationTest := false,
    testOptions in IntegrationTest += Tests.Argument(TestFrameworks.ScalaTest, "-n", "org.scalatest.tags.Slow"),
    headers := createFrom(Apache2_0, "2017", "Leanne Northrop")
  )

HeaderPlugin.settingsFor(IntegrationTest)
AutomateHeaderPlugin.automateFor(IntegrationTest)
