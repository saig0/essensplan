import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "essensplan"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
	
      // Add your project dependencies here,
	  "postgresql" % "postgresql" % "8.4-702.jdbc4",
	  "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
