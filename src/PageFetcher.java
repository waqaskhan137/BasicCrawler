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
<<<<<<< HEAD
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
=======

	String fetchPage(String url) throws IOException {
		String html = Jsoup.connect(url).get().html();
>>>>>>> d90eb94e8adc121a15f5cd244c430df482ff14f2
		return html;
	}
}