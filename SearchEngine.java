/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
import java.util.*;
public class SearchEngine {
    public static final String PAGES_FILE = "pages.txt";
    public static final String LINKS_FILE = "links.txt";
    private static WebGraph web;

    public static void main(String[] args) {
        System.out.println("Loading WebGraph data...");
        try {
            web = WebGraph.buildFromFiles(PAGES_FILE, LINKS_FILE);
            System.out.println("Success!!!!");
        }catch(Exception e){
            web = new WebGraph();
            System.out.println("Something went wrong");

        }
        String menu = "\n(AP) - Add a new page to the graph.\n" + "(RP) - Remove a page from the graph.\n" +
                "(AL) - Add a link between  pages in the graph.\n" + "(RL) - Remove a link between pages " +
                "in the graph.\n" + "(P)  - Print the graph.\n"  + "(S)  - Search for pages with a keyword.\n" +
                "(Q)  - Quit." + "\n";

        String option = " ";
        while(option != "Q"){
            System.out.println(menu);
            Scanner reader = new Scanner(System.in);
            System.out.println("Please select an option : ");
            option = reader.nextLine().toUpperCase().trim();

            switch(option){
                case "AP":
                    System.out.println("Enter a URL : ");
                    String url = reader.nextLine();
                    System.out.println("Enter keywords (space-separated) : ");
                    String keywords = reader.nextLine();
                    String[] keys = keywords.split(" ");
                    ArrayList<String> keywordList = new ArrayList<>();

                    for(int i = 0; i < keys.length; i++)
                        keywordList.add(keys[i]);

                    try{
                        WebGraph.addPage(url,keywordList);
                        System.out.println(url + " successfully added to the WebGraph!");
                    }catch(Exception e){
                        System.out.println("Exception");
                    }
                    break;

                case "RP":
                    System.out.println("Enter a URL");
                    url = reader.nextLine();
                    WebGraph.removePage(url);
                    System.out.println(url + "has been removed from the graph!");
                    break;

                case "AL":
                    System.out.println("Enter a source URL:");
                    String sourceUrl = reader.nextLine();
                    System.out.println("Enter a destination URL");
                    String destUrl = reader.nextLine();
                    try{
                        WebGraph.addLink(sourceUrl, destUrl);
                        System.out.println("Link successfully added from" + sourceUrl + "to" + destUrl);
                    }catch(Exception e){
                        System.out.println("Failed to link from source url to the destination url");
                    }
                    break;

                case "RL":
                    System.out.println("Enter a source URL:");
                    sourceUrl = reader.nextLine();
                    System.out.println("Enter a destination URL");
                    destUrl = reader.nextLine();
                    WebGraph.removeLink(sourceUrl, destUrl);
                    System.out.println("Link removed from" + sourceUrl + "to" + destUrl);
                    break;

                case "P":
                    String sortingOption = "\n(I) Sort based on index (ASC)\n" + "(U) Sort based on URL (ASC)\n" +
                            "(R) Sort based on rank (DSC)\n";

                    System.out.println("Please select an option : ");
                    System.out.println(sortingOption);
                    option = reader.nextLine();

                    WebGraph.printTable();


                    break;

                case "S":
                    System.out.println("Search keyword:");
                    keywords = reader.nextLine();

                    break;

                case "Q":
                    System.out.println("GoodBye");
                    System.exit(0);
            }
        }
    }
}









