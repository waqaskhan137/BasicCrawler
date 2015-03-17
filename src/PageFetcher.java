import java.io.IOException;

import org.jsoup.Jsoup;

/**
 * This class fetches the web pages 
 */
class PageFetcher {

	String fetchPage(String URL) throws IOException{
		
	 String html = Jsoup.connect(URL).get().html();
	 UrlHandler uobj= new UrlHandler();
	 
	 uobj.visitedUrl(URL);
	 return html;
	}
}