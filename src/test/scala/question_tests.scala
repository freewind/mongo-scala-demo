package test

import org.scalatest.{ FlatSpec, BeforeAndAfterEach, BeforeAndAfterAll }
import org.scalatest.matchers.ShouldMatchers
import org.scalaeye.mongodb._
import models._

class QuestionTest extends BaseSuite {

	"question" should "be inserted correctly" in {
		val user = new User
		users << user

		val question = new Question(user)
		question.title = "title"
		questions << question

		questions.size should equal(1)
	}

	it should "have some comments" in {
		val user = new User
		users << user
		val question = new Question(user)
		val comment1 = new QComment(question)
		val comment2 = new QComment(question)
		question.comments = List(comment1, comment2)

		questions << question

		// found
		val q = questions.headOption.get
		println("#############: " + q.comments.size)
	}

}
