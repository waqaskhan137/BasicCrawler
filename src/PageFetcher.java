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

	String fetchPage(String URL) throws IOException {
		String html = Jsoup.connect(URL).get().html();
		return html;
	}
}