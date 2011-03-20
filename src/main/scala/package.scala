import com.osinka.mongodb._
import com.mongodb._

package object models {

	var mongo: Mongo = _
	var db: DB = _
	def initMongo(mongo: Mongo, dbname: String) = {
		this.mongo = mongo
		this.db = mongo.getDB(dbname)
	}

	trait Oid { this: MongoObject =>
		def oid = this.mongoOID.get
	}
}
