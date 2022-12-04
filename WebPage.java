/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
import java.util.*;
public class WebPage {
   private String url;
   private int index;
   private int rank;
   private ArrayList<String> keywords;

   public WebPage(){}

   public WebPage(String url, int index, int rank, ArrayList<String>keywords){
       this.url = url;
       this.index = index;
       this.rank = rank;
       this.keywords = keywords;
   }
   /* @ return
        It returns the url of the webPage as a String.
    */
   public String getUrl(){
       return getUrl();
   }
   /* @ return
        It returns the index of the webPage as an integer.
    */
   public int getIndex(){
       return index;
   }
   /* @ return
        It returns the rank of the WebPage as an integer.
   */
   public int getRank(){
       return rank;
   }
   /* @ return
        It returns the keywords of the webPage as a String.
   */
   public ArrayList<String> getKeywords(){
       return keywords;
   }
   /* @ param url
        It can change the url of the webPage.
   */
   public void setUrl(String url){
       this.url = url;
   }
   /* @ param index
        It can change the index of the webPage.
   */
   public void setIndex(int index){
       this.index = index;
   }
   /* @ param rank
        It can change the rank of the webPage.
   */
   public void setRank(int rank){
       this.rank = rank;
   }
   /* @ param keywords
        It can change the keywords of the webPage.
   */
   public void setKeywords(ArrayList<String>keywords){
       this.keywords = keywords;
   }
   /* @ return
        It returns string of data members in tabular form
   */
   public String toString(){
       return String.format("%-7s | %-27s | %-11s | %-46s |", index, url, rank, keywords);
   }
}


