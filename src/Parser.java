import java.net.UnknownHostException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;

/**
 * @contributor rmw
 * @Purpose: Only handles the Parsing of the web pages
 * 
 * @Task - Get any element of page - Efficiency - Logging
 *
 */
class Parser {

	void parsing(ArrayList<String> html) throws UnknownHostException {

		String tag = "body";

		// getting body text of the page
		ArrayList<String> text = new ArrayList<String>();
		String page;
		for (int i = 0; i < html.size(); i++) {
			page = html.get(i);
			Document nD = new Document(page);
			org.jsoup.select.Elements resultLinks = nD.select(tag);

			// adding it the Array List
			// Converting it to the string again? not sure but will look at at
			// later
			text.add(resultLinks.toString());
		}

		// DB object
		DBHandler db = new DBHandler();
		// Sending it to the DB
		db.insert(text);

	}

}