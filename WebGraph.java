/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
import java.util.*;
import java.io.*;
public class WebGraph {
   public static final int MAX_PAGES = 40;
   private static ArrayList<WebPage> pages = new ArrayList<>();
   static int [][] graphEdges = new int[MAX_PAGES][MAX_PAGES];
   public static int rank, start;


   /* This method constructs a WebGraph object using the indicated files as the
      source for pages and edges. It returns the WebGraph constructed from the text files.
    */
   public static WebGraph buildFromFiles(String pagesFile, String linksFile) throws IllegalArgumentException{
       WebGraph webGraph = new WebGraph();
       try{
           FileInputStream fis = new FileInputStream(pagesFile);
           FileInputStream link = new FileInputStream(linksFile);
           InputStreamReader inStream = new InputStreamReader(fis);
           BufferedReader reader = new BufferedReader(inStream);
           String data = "";

           while((data=reader.readLine())!=null) {
               System.out.println(data);
               String[] key = data.trim().split("");
               String url = key[0];
               ArrayList<String> keyword = new ArrayList<>();
               for (int i = 1; i < key.length; i++) {
                   keyword.add(key[i]);
               }
               webGraph.addPage(url, keyword);
           }

       }catch (Exception e){
           System.out.println("Exception");
       }
       return webGraph;
   }
   /* This method add a page to the WebGraph. It throws an IllegalArgument Exception
      if the url and keyword is null. It's also add the page in the webPage and update
      the page rank.
   */
   public static void addPage(String url, ArrayList<String> keywords) throws IllegalArgumentException{
       if(url == null) {
           throw new IllegalArgumentException("Invalid URL");
       }
       if(keywords == null) {
           throw new IllegalArgumentException("Invalid Keywords");
       }
       if(pages.contains(url)) {
           throw new IllegalArgumentException("The pages is already contains the URL!");
       }
       pages.add(new WebPage());
       updatePageRanks();
   }
   /* It throws an IllegalArgument Exception if the url and the destination is null.
      It adds a link from the WebPage with the URL indicated by source to the WebPage with
      the URL indicated by destination
    */
   public static void addLink(String source, String destination) throws IllegalArgumentException{

       if(source == null) {
           throw new IllegalArgumentException("Source is missing");
       }
       if(destination == null) {
           throw new IllegalArgumentException("Destination is missing");
       }
       updatePageRanks();
   }
   public static void removePage(String url){
       updatePageRanks();
   }
   public static void removeLink(String source, String destination){
       updatePageRanks();

   }
   // It Calculates and assigns the PageRank for every page in the WebGraph
   public static void updatePageRanks(){
       for(WebPage webPage : pages){
           start = webPage.getIndex();
           if(graphEdges[start][webPage.getIndex()] == 1){
               rank +=1;
           }
           webPage.setRank(rank);
       }
   }

   // It prints the WebGraph in tabular form by using the string formatter and toString method.
    public static void printTable() {
       WebPage webPage = new WebPage();
       System.out.println(String.format("%-7s | %-21s | %-11s | %-25s | %-30s", "Index", "\t\tURL", "  PageRank", "\t\tLinks", "\tKeywords"));
       System.out.println("-----------------------------------------------------------------------------------------------------------------");

       }
   }

