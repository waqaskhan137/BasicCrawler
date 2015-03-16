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
		 * Finding the Hyper links and jumping and storing those in Array List 
		 */
		try {
			Document doc = (Document) Jsoup.parse(new URL(getSeedUrl()), 2000);
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

	void visitedUrl(String URL) {
		/**
		 * Storing the Visited urls to the url bank 
		 */
		String type = "visited";
		
		ArrayList vUrl = new ArrayList<String>();
		//until job is done 
		while(true){
		//Store URL until job is done 
		
		
		//Add those in Array List 
		vUrl.add(URL);
		}
		
		urlBank(vUrl, type);
	}
	
	void unvisitedUrl(ArrayList<String> url ) {
		/**
		 * sending the urls to the Page Fethcer and to the URL bank for storage
		 */
		
		
			
	}

	void urlBank(ArrayList<String> url, String type) {
		/**
		 * storing the Array list of URLs in MongoDB
		 */
		
	}

}