import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
<<<<<<< HEAD
 * @contributor rmw This class handles only URL - Improving UrlFinder() -
 *              Regular Expression for url Depth - URLBank?
=======
 * @contributor rmw
 * @Purpose: This class handles only URL
 * @Task - Improving UrlFinder() - Regular Expression for url Depth - URLBank?
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
 */
class UrlHandler {
	// initiating logger
	private static final Logger LOG = Logger.getLogger(UrlHandler.class
			.getName());
	private String seedUrl = null;
	// Need to define the depth of the url
	// 1 = external & internal all
	// 0 = internal only
	@SuppressWarnings("unused")
	private int depth;

	/**
	 * Set the seed url
	 * 
	 * @param startingUrl
	 *            Starting URL
	 * @param uDepth
	 *            Search Depth of Domain
	 */
	public void setUrlSeeder(String startingUrl, int uDepth) {
		this.depth = uDepth;
		this.seedUrl = startingUrl;
	}

	/**
	 * Getter for Seed url
	 * 
	 * @return seed url
	 */
	public String getSeedUrl() {
		return this.seedUrl;
	}

	/**
	 * Determines the url Depth using Regular expression
	 * 
	 * @param url
	 *            given url for check
	 * @return return bool
	 */
	boolean urlDepth(String url) {
		// Regular Expression comes in if statement
		if (url != null) {
			// Same domain url [{\\String example.com/*}]
			return true;
		} else {
			return false;
		}
	}

	/**
	 * It explores the url
	 */
	void urlExplorer() {
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
<<<<<<< HEAD

=======
				// Adding regular expression for filtering out the url
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
				// Adding the urls to the Array List
				href.add(link.attr("href"));
			}
			unvisitedUrl(href);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
<<<<<<< HEAD
			log.log(Level.SEVERE, "urlExplorer Exception: ", e);

=======
			LOG.log(Level.SEVERE, e.toString());
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.log(Level.SEVERE, e.toString());
		}
	}

	/**
	 * Deal with visited URL
	 * 
	 * @param URL
	 *            Any url given to it which is been visited
	 * @param fetchCheck
	 *            to check if url has been visited to or not
	 */
	@SuppressWarnings("null")
	void visitedUrl(String URL, int fetchCheck) {
		/**
		 * Storing the Visited urls to the url bank
		 */
		// fecthCheck 1= fetched, 0 = not fetched
		String type = "visited";
		ArrayList<String> vUrl = null;
		// Add those in Array List
		vUrl.add(URL);
		// Have to think over this
		urlBank(vUrl, type);
	}

<<<<<<< HEAD
	/**
	 * The url not visted yet
	 * 
	 * @param url
	 *            url to visit
	 */
	void unvisitedUrl(ArrayList<String> url) {

		try {
			String type = "unvisited";
			/**
			 * sending the urls to the Page Fethcer and to the URL bank for
			 * storage
			 */
			ArrayList<String> html = new ArrayList<String>();

			PageFetcher pageObj = new PageFetcher();
			Parser parserObj = new Parser();
			for (int i = 0; i < url.size(); i++) {
				String unUrl = url.get(i);
				// sending it to the Page fetcher and getting back the html of
				// the

				if (depth == 0) {

					if (urlDepth(unUrl) != false) {

						html.add(pageObj.fetchPage(unUrl));

						// Putting it in visited url list
						visitedUrl(unUrl, 1);

					} else {
						visitedUrl(unUrl, 0);

					}
				} else {
					html.add(pageObj.fetchPage(unUrl));
					visitedUrl(unUrl, 1);
				}

			}

			parserObj.Parsing(html);

			// Under consideration
			urlBank(url, type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.log(Level.WARNING, "Parsing Exception", e);
		}

=======
	void unvisitedUrl(ArrayList<String> url) throws IOException {
		String type = "unvisited";
		/**
		 * sending the url to the Page Fetcher and to the URL bank for storage
		 */
		ArrayList<String> html = new ArrayList<String>();
		PageFetcher pageObj = new PageFetcher();
		Parser parserObj = new Parser();
		for (int i = 0; i < url.size(); i++) {
			String unUrl = url.get(i);
			// sending it to the Page fetcher and getting back the html of the
			if (urlDepth(unUrl)) {
				html.add(pageObj.fetchPage(unUrl));
				// Putting it in visited url list
				visitedUrl(unUrl, 1);
			} else {
				visitedUrl(unUrl, 0);
			}
		}
		parserObj.parsing(html);
		// Under consideration
		urlBank(url, type);
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
	}

	/**
	 * Storage of URL
	 * 
	 * @param url
	 *            url
	 * @param type
	 *            visited or not
	 */
	// Do we really need this ? for storing visited and unvisited url storage?
	void urlBank(ArrayList<String> url, String type) {
		/**
		 * storing the Array list of URLs in MongoDB With time stamp
		 */
	}
}