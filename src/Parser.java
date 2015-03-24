import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;

/**
 * @contributor rmw
 * @Purpose: Only handles the Parsing of the web pages
 * 
 * @Task - Get any element of page - Efficiency - Logging
 *
 */
class Parser {
	// initiating logger
	private static final Logger log = Logger.getLogger(DBHandler.class
			.getName());

<<<<<<< HEAD
	/**
	 * Parse the Fetched page
	 * 
	 * @param html
	 *            html of the page
	 */
	void Parsing(ArrayList<String> html) {
=======
	void parsing(ArrayList<String> html) throws UnknownHostException {
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2

		try {
			String tag = "body";

<<<<<<< HEAD
			// getting body text of the page
			ArrayList<String> text = new ArrayList<String>();

			for (int i = 0; i < html.size(); i++) {
				String page = html.get(i);
				Document nD = new Document(page);

				org.jsoup.select.Elements resultLinks = ((Element) nD)
						.select(tag);

				// adding it the Array List
				// conveting it to the string again? not sure but will look at
				// at
				// later
				text.add(resultLinks.toString());
			}

			// DB object
			DBHandler db = new DBHandler();
			// Sending it to the DB

			db.insert(text);
=======
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
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2

		} catch (Exception e) {

			log.log(Level.WARNING,
					"Exception at Inserting in DB\n" + e.toString());
		}

	}

}