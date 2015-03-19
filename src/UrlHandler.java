import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 * @contributor rmw
 * @Purpose: This class handles only URL
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

			org.jsoup.nodes.Document doc = Jsoup.connect(getSeedUrl()).get();

			org.jsoup.select.Elements resultLinks = doc.select("a");
			// int urlSize = ((org.jsoup.select.Elements) resultLinks).size();

			ArrayList<String> href = new ArrayList<String>();

			for (Element link : resultLinks) {

				// Adding regular expression for filtering out the url

				// Adding the urls to the Array List
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
		ArrayList<String> html = new ArrayList<String>();

		PageFetcher pageObj = new PageFetcher();
		Parser parserObj = new Parser();
		for (int i = 0; i < url.size(); i++) {
			String unUrl = url.get(i);
			// sending it to the Page fetcher and getting back the html of the
			// page
			html.add(pageObj.fetchPage(unUrl));

			// Putting it in visited url list
			visitedUrl(unUrl);
		}

		parserObj.Parsing(html);

		// Under consideration
		urlBank(url, type);

	}

	// Do we really need this ? for storing visited and unvisited url storage?
	void urlBank(ArrayList<String> url, String type) {
		/**
		 * storing the Array list of URLs in MongoDB With time stamp
		 */

	}

}