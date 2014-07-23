import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play2pdf"
    val appVersion      = "2.2.1-SNAPSHOT"

    val appDependencies = Seq(
      "org.xhtmlrenderer" % "flying-saucer-pdf" % "9.0.6",
      "nu.validator.htmlparser" % "htmlparser" % "1.4",
      "com.lowagie" % "itext" % "2.1.7"
    )

    val main =play.Project(appName, appVersion, appDependencies).settings(
      // hack to suppress javadoc error, see: https://play.lighthouseapp.com/projects/82401/tickets/898-javadoc-error-invalid-flag-g-when-publishing-new-module-local#ticket-898-7
      publishArtifact in(Compile, packageDoc) := false,
      organization := "de.joergviola"
    )

}
