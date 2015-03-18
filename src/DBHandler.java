import java.net.UnknownHostException;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 * @contributors rmw
 */
public class DBHandler {
	DBCollection collection;

	private void initializer() throws UnknownHostException {
		// connect to mongoDB, IP and port number
		Mongo mongo = new Mongo("localhost", 27017);
		// get database from MongoDB,
		// if database doesn't exists, mongoDB will create it automatically
		DB db = mongo.getDB("dineshonjavaDB");

		// Get collection from MongoDB, database named "dineshonjavaDB"
		// if collection doesn't exists, mongoDB will create it automatically
		collection = db.getCollection("dineshonjavaCollection");

	}

	boolean insert(ArrayList<String> urlList) throws UnknownHostException {

		initializer();

		// insert the object as a Array List
		// create a document to store key and value
		BasicDBObject document = new BasicDBObject();
		document.put("id", 1000);
		document.put("msg", "Hello World mongoDB in Java! Dinesh On Java");

		// save it into collection named "dineshonjavaCollection"
		collection.insert(document);

		return true;
	}

	String fetch() throws UnknownHostException {
		
		initializer();

		// search query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", 1000);

		// query it
		DBCursor cursor = collection.find(searchQuery);

		// loop over the cursor and display the retrieved result
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

		System.out.println("Done");
		return "";

	}

}