import sbt._

class DemoProject(info: ProjectInfo) extends DefaultProject(info) {

	val slf4j_api = "org.slf4j" % "slf4j-api" % "1.6.1" % "compile->default"
	val slf4j_nop = "org.slf4j" % "slf4j-nop" % "1.6.1" % "compile->default"

	// mongodb
	val casbah = "com.mongodb.casbah" % "casbah_2.8.1" % "2.1.0"
	val mongo_scala = "com.osinka" % "mongo-scala-driver" % "0.8.10"
	val mongo_java = "org.mongodb" % "mongo-java-driver" % "2.3"

	val scalatest = "org.scalatest" % "scalatest" % "1.3" % "test->default"
	val junit = "junit" % "junit" % "4.5" % "test->default"

}
