package test

import org.scalatest.{ FlatSpec, BeforeAndAfterEach, BeforeAndAfterAll }
import org.scalatest.matchers.ShouldMatchers
import com.mongodb._
import models._

class BaseSuite extends FlatSpec with ShouldMatchers
	with BeforeAndAfterEach with BeforeAndAfterAll {

	initMongo(new Mongo(), "smongodb")
	val users = User.collection
	val questions = Question.collection

	override def beforeEach {
		users.drop()
		questions.drop()
	}

}
