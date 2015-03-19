import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;

/**
 * @contributor rmw
 * @Purpose: Only handles the Parsing of the web pages
 */
class Parser {

	void Parsing(ArrayList<String> html) {

		// getting body text of the page
		ArrayList<String> text = new ArrayList<String>();

		for (int i = 0; i < html.size(); i++) {
			String page = html.get(i);
			// getting body tag, Not sure about this will look at t later
			org.jsoup.select.Elements resultLinks = ((Element) page).select("body");

			// adding it the Array List
			text.add(resultLinks.toString());
		}

		// DB object
		DBHandler db = new DBHandler();
		// Sending it to the DB
		db.insert(text);

	}

}