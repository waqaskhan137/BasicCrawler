import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 * @contributors rmw
 * @Purpose: Handles only Data base
 */
public class DBHandler {
	// initiating logger
	private static final Logger log = Logger.getLogger(DBHandler.class
			.getName());
	DBCollection collection;

	private void initializer() throws UnknownHostException {
		// connect to mongoDB, IP and port number
		Mongo mongo = new Mongo("localhost", 27017);
		// get database from MongoDB,
		// if database doesn't exists, mongoDB will create it automatically
		DB db = mongo.getDB("URL");

		// if collection doesn't exists, mongoDB will create it automatically
		collection = db.getCollection("URLBank");

	}

	boolean insert(ArrayList<String> urlList) throws UnknownHostException {

		initializer();

		// insert the object as a Array List
		// create a document to store key and value
		BasicDBObject document = new BasicDBObject();
		document.put("id", 1000);
		document.put("msg", "Whatever");

		collection.insert(document);
		log.log(Level.INFO, "Document which is being Insert: \n" + document);
		return true;
	}

	String fetch() throws UnknownHostException {

		initializer();

		// search query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", 1000);

		// query it
		DBCursor cursor = collection.find(searchQuery);
		String data = null;
		// loop over the cursor and display the retrieved result
		while (cursor.hasNext()) {
			data += cursor.next();
		}

		log.log(Level.INFO, "Query Done\n" + data);
		return data;

	}

}