import java.io.IOException;

import org.jsoup.Jsoup;

/**
 * @author Waqas
 * @Purpose: This class fetches the web pages
 * 
 * @Task - Do we need logging here? -
 * 
 */
class PageFetcher {

	/**
	 * @ It just fetch the required page
	 * 
	 * @param URL
	 *            to be fetched
	 * @return String of html
	 */

	String fetchPage(String url) {

		String html = null;
		try {
			html = Jsoup.connect(url).get().html();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return html;
	}
}