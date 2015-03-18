/*
 * import java.util.ArrayList;


import com.mongodb.*;
public class DBHandler {
	
	boolean insert(ArrayList<String> urlList ){
		
		//insert the object as a Array List
		
		return true;
	}
	boolean update(){
		
		return true;
		
	}
	String fetch(){
		
		return ""; 
		
	}
	

}

*/
  
import java.net.UnknownHostException;  
  
import com.mongodb.BasicDBObject;  
import com.mongodb.DB;  
import com.mongodb.DBCollection;  
import com.mongodb.DBCursor;  
import com.mongodb.Mongo;  
import com.mongodb.MongoException;  
  
/** 
 * @author Dinesh Rajput 
 * 
 */  
public class DBHandler {  
  
 /** 
  * @param args 
  */  
 public static void main(String[] args) {  
  try {  
   // connect to mongoDB, IP and port number  
   Mongo mongo = new Mongo("localhost", 27017);  
   
   // get database from MongoDB,  
   // if database doesn't exists, mongoDB will create it automatically  
   DB db = mongo.getDB("dineshonjavaDB");  
   
   // Get collection from MongoDB, database named "dineshonjavaDB"  
   // if collection doesn't exists, mongoDB will create it automatically  
   DBCollection collection = db.getCollection("dineshonjavaCollection");  
   
   // create a document to store key and value  
   BasicDBObject document = new BasicDBObject();  
   document.put("id", 1000);  
   document.put("msg", "Hello World mongoDB in Java! Dinesh On Java");  
   
   // save it into collection named "dineshonjavaCollection"  
   collection.insert(document);  
   
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
   
  } catch (UnknownHostException e) {  
   e.printStackTrace();  
  } catch (MongoException e) {  
   e.printStackTrace();  
  }  
   
 }  
  
}  