package test

import org.scalatest.{ FlatSpec, BeforeAndAfterEach, BeforeAndAfterAll }
import org.scalatest.matchers.ShouldMatchers
import models._

class UserTest extends BaseSuite {

	"user" should "be inserted correctly" in {
		val user = new User
		user.email = "aaa@aaa.com"
		users << user

		users.size should equal(1)
	}

	it should "have many questions" in {
		val user = new User
		users << user
		val q1 = new Question(user)
		val q2 = new Question(user)
		questions << q1
		questions << q2

		user.questions should have size (2)
	}
}
