package models

import com.mongodb._
import com.osinka.mongodb._, shape._

class User extends MongoObject with Oid {
	var email: String = _
	def questions = (Question where (Question.user is_== this) in Question.collection).toList
}

object User extends MongoObjectShape[User] {
	lazy val collection = db.getCollection("users") of User
	lazy val email = Field.scalar("email", _.email, (u: User, v: String) => u.email = v)
	override lazy val * = email :: Nil
	override def factory(dbo: DBObject) = Some(new User)
}
