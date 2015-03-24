import java.io.IOException;

import org.jsoup.Jsoup;

/**
 * @contributor rmw
 * @Purpose: This class fetches the web pages
 * 
 * @Task - Do we need logging here? -
 * 
 */
class PageFetcher {
	/**
	 * It just fetch the required page
	 * 
	 * @param URL
	 *            URL to be fetched
	 * @return String of html
	 * @throws IOException
	 *             [description]
	 */
	String fetchPage(String URL) throws IOException {
		String html = Jsoup.connect(URL).get().html();
		return html;
	}
}