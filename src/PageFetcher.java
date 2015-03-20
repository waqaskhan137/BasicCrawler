import java.io.IOException;

import org.jsoup.Jsoup;

/**
 * @contributor rmw
 * @Purpose: This class fetches the web pages
 * 
 * @Task - Logging -
 * 
 */
class PageFetcher {

	String fetchPage(String URL) throws IOException {
		String html = Jsoup.connect(URL).get().html();
		return html;
	}
}