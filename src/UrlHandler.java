import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
/**
 * This class handles only URL 
 */
class  UrlHandler {
	
	protected String seedUrl = null;

	@SuppressWarnings("unused")
	private void setUrlSeeder(String startingUrl){

		seedUrl = startingUrl;
	}

	public String getSeedUrl(){

		return seedUrl;
	}

	void urlFinder() {
		/**
		 * Finding the Hyper links and jumping and storing those in Queue 
		 */
		try {
			Document doc = (Document) Jsoup.parse(new URL("http://www.bits4beats.it/"), 2000);
			Elements resultLinks = (Elements) ((Element) doc).select("a");
		    int  urlSize = ((org.jsoup.select.Elements) resultLinks).size();
		   
		    ArrayList href = new ArrayList();
		    
		    for (Element link : resultLinks) {
		    	
		     href.add(link.attr("href"));
		    }
		    
		    unvisitedUrl(href);
		    
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void visitedUrl() {
		
	}
	
	void unvisitedUrl(ArrayList<String> url ) {
		
		
			
	}

	void urlBank(String url) {
		/**
		 * storing the URL in a queue and sending it to the page fetcher 
		 */
	}

}