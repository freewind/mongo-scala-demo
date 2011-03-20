package models

import com.mongodb._
import com.osinka.mongodb._, shape._

class Question(val user: User) extends MongoObject with Oid {
	var title: String = _
	var comments: List[QComment] = Nil
}

object Question extends MongoObjectShape[Question] { shape =>
	lazy val collection = db.getCollection("questions") of Question
	lazy val user = Field.ref("user", User.collection, _.user)
	lazy val title = Field.scalar("title", _.title, (q: Question, v: String) => q.title = v)
	object comments extends ArrayEmbeddedField[QComment]("comments", _.comments, Some((q: Question, v: Seq[QComment]) => {
		println("########## set comments to question: "+v)
		q.comments = v.toList
	})) with QCommentIn[Question]
	lazy override val * = List(user, title, comments)
	override def factory(dbo: DBObject) = for (user(u) <- Some(dbo); comments(c) <- Some(dbo)) yield {
		val q = new Question(u)
		q.comments = c.toList
		q
	}
}

class QComment(val question: Question) extends MongoObject with Oid {
	var content: String = _
}

trait QCommentIn[T] extends ObjectIn[QComment, T] {
	lazy val question = Field.ref("question", Question.collection, _.question)
	lazy val content = Field.scalar("content", _.content, (c: QComment, v: String) => c.content = v)
	lazy override val * = question :: content :: Nil
	override def factory(dbo: DBObject) = for (question(q) <- Some(dbo)) yield new QComment(q)
}

object QComment extends MongoObjectShape[QComment] with QCommentIn[QComment] {}
