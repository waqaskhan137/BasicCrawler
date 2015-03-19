import com.mongodb.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 * @contributor rmw Purpose: This class handles only URL
 */
class UrlHandler {
	// initiating logger
	private static final Logger log = Logger.getLogger(UrlHandler.class
			.getName());

	protected String seedUrl = null;
	protected String depth = null;

	@SuppressWarnings("unused")
	private void setUrlSeeder(String startingUrl, String uDepth) {

		depth = uDepth;
		seedUrl = startingUrl;
	}

	public String getSeedUrl() {

		return seedUrl;
	}

	void urlFinder() {
		/**
		 * 1- Finding the Hyper links 2- Restriction of the same domain Link
		 * search, Regular Expression 3- jumping and storing those in Array List
		 */
		try {
			Document doc = (Document) Jsoup.parse(new URL(getSeedUrl()), 2000);
			Elements resultLinks = (Elements) ((Element) doc).select("a");
			int urlSize = ((org.jsoup.select.Elements) resultLinks).size();

			ArrayList<String> href = new ArrayList<String>();

			for (Element link : resultLinks) {

				href.add(link.attr("href"));
			}

			unvisitedUrl(href);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, e.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.SEVERE, e.toString());
		}

	}

	@SuppressWarnings("null")
	void visitedUrl(String URL) {
		/**
		 * Storing the Visited urls to the url bank
		 */
		String type = "visited";

		ArrayList<String> vUrl = null;
		// Add those in Array List
		vUrl.add(URL);

		// Have to think over this
		urlBank(vUrl, type);
	}

	void unvisitedUrl(ArrayList<String> url) throws IOException {

		String type = "unvisited";
		/**
		 * sending the urls to the Page Fethcer and to the URL bank for storage
		 */
		PageFetcher pObj = new PageFetcher();
		Parser paObj = new Parser();
		for (int i = 0; i < url.size(); i++) {
			String unUrl = url.get(i);
			String html = pObj.fetchPage(unUrl);
			visitedUrl(unUrl);
			paObj.Parsing(html);

		}
		urlBank(url, type);

	}

	void urlBank(ArrayList<String> url, String type) {
		/**
		 * storing the Array list of URLs in MongoDB With time stamp
		 */

	}

}