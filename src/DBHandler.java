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
 * @Task - Finding efficient storage format
 */
public class DBHandler {
	// initiating logger
	static final Logger LOG = Logger.getLogger(DBHandler.class.getName());
	private DBCollection collection;

	private void initializer() {
		try {
			// connect to mongoDB, IP and port number
			String server = "localhost";
			int port = 27017;
			Mongo mongo;
			mongo = new Mongo(server, port);
			// get database from MongoDB,
			// if database doesn't exists, mongoDB will create it automatically
			DB db = mongo.getDB("URL");
			// if collection doesn't exists, mongoDB will create it
			// automatically
			this.collection = db.getCollection("URLBank");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	boolean insert(ArrayList<String> urlList) {
		initializer();
		// insert the object as a Array List
		// create a document to store key and value
		BasicDBObject document = new BasicDBObject();
		document.put("id", "WTF");
		document.put("msg", "Whatever");
		this.collection.insert(document);
		LOG.log(Level.INFO,
				"Document which is being Insert: "
						+ System.getProperty("line.separator") + document);
		return true;
	}

	String fetch() {
		initializer();
		// search query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", "yeah");
		// query it
		DBCursor cursor = this.collection.find(searchQuery);
		String data = null;
		// loop over the cursor and display the retrieved result
		while (cursor.hasNext()) {
			data += cursor.next();
		}
		LOG.log(Level.INFO, "Query Done" + System.getProperty("line.separator")
				+ data);
		return data;
	}
}