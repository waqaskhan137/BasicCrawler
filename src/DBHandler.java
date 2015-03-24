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
<<<<<<< HEAD
 * 
 * @Task - Finding efficient storage formate - close the db connection
 */
public class DBHandler {
	// initiating logger
	private static final Logger log = Logger.getLogger(DBHandler.class
			.getName());
	DBCollection collection;

	/**
	 * to initialize the DB connection
	 */
	private void initializer() {
		try {
			// connect to mongoDB, IP and port number
			Mongo mongo;

			mongo = new Mongo("localhost", 27017);

			// get database from MongoDB,
			// if database doesn't exists, mongoDB will create it automatically
			DB db = mongo.getDB("URL");

			// if collection doesn't exists, mongoDB will create it
			// automatically
			collection = db.getCollection("URLBank");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.WARNING, "Initializer Exception: \n", e);
		}

	}

	/**
	 * Insert the data
	 * 
	 * @param urlList
	 *            URL Array List
	 * @return Bool
	 */
	boolean insert(ArrayList<String> urlList) {

=======
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
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
		initializer();
		// insert the object as a Array List
		// create a document to store key and value
		BasicDBObject document = new BasicDBObject();
		document.put("id", "WTF");
		document.put("msg", "Whatever");
<<<<<<< HEAD

		collection.insert(document);
		log.log(Level.INFO, "Document which is being Insert: \n" + document);

		// Closing the DB connection
		return true;
	}

	/**
	 * Fetch the data from DB
	 * 
	 * @return String
	 */
	String fetch() {

=======
		this.collection.insert(document);
		LOG.log(Level.INFO,
				"Document which is being Insert: "
						+ System.getProperty("line.separator") + document);
		return true;
	}

	String fetch() {
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
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
<<<<<<< HEAD
		// closing the db connection
		log.log(Level.INFO, "Query Done\n" + data);
=======
		LOG.log(Level.INFO, "Query Done" + System.getProperty("line.separator")
				+ data);
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
		return data;
	}
}