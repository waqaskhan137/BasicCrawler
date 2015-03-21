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

	String fetchPage(String url) throws IOException {
		String html = Jsoup.connect(url).get().html();
		return html;
	}
}