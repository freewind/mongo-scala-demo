package test

import org.scalatest.{ FlatSpec, BeforeAndAfterEach, BeforeAndAfterAll }
import org.scalatest.matchers.ShouldMatchers
import org.scalaeye.mongodb._
import com.mongodb._
import models._

class BaseSuite extends FlatSpec with ShouldMatchers
	with BeforeAndAfterEach with BeforeAndAfterAll {

	initMongo(new Mongo(), "smongodb")
	val users = User.collection
	val questions = Question.collection

	override def beforeEach {
		println("######### drop all")
		users.drop()
		questions.drop()
	}

	//	protected def createUser(email: String = "aaa@aaa.com", password: String = "abc", name: String = "AAA"): User = {
	//		User(email, password, name)
	//	}
	//
	//	protected def createQuestion(user: User, title: String = "question_title", content: String = "question_content"): Question = {
	//		Question(title, content, user)
	//	}
	//
	//	protected def createAnswer(user: User, question: Question, content: String = "answer_content"): Answer = {
	//		Answer(content, question, user)
	//	}
	//
	//	protected def createTag(user: User, name: String = "scala"): Tag = {
	//		Tag(name, user)
	//	}

}
