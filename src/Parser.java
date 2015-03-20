import java.net.UnknownHostException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @contributor rmw
 * @Purpose: Only handles the Parsing of the web pages
 */
class Parser {

	void Parsing(ArrayList<String> html) throws UnknownHostException {

		// getting body text of the page
		ArrayList<String> text = new ArrayList<String>();

		for (int i = 0; i < html.size(); i++) {
			String page = html.get(i);
			Document nD = new Document(page);
			// getting body tag, Not sure about this will look at t later
			org.jsoup.select.Elements resultLinks = ((Element) nD)
					.select("body");

			// adding it the Array List
			text.add(resultLinks.toString());
		}

		// DB object
		DBHandler db = new DBHandler();
		// Sending it to the DB
		db.insert(text);

	}

}