# BasicCrawler
##Purpose: 

to fetch the data from web 

##Algorithm 

Algorithm of a basic web crawler:-

* Add one or more seed URLS to linksToBeVisited. The method to add a URL to linksToBeVisited must be synchronized.
* Pop an element from linksToBeVisited and add this to linksVisited. This pop method to pop URL from linksToBeVisited must be synchronized.

* Fetch the page from INTERNET.

* Parse the file and add any till now not visited link found in the page to linksToBeVisited. URL's can be filtered if needed. The user can give a set of rules to filter which url's to be scanned.

* The necessary information found on the page is saved in database or file.

* repeat step 2 to 5 until queue is linksToBeVisited empty.

###Contribute 
Just open it in Eclipse and start contributing 
Or open an issue if you have any trouble