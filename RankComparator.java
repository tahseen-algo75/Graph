/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */

// It compares two WebPages by their rank in descending order.
import java.util.*;
public class RankComparator implements Comparator<WebPage>{
    public int compare(WebPage web1, WebPage web2){
        if(web1.getRank() > web2.getRank()){
            return -1;
        }
        else if(web1.getIndex() == web2.getIndex()){
            return 0;
        }
        else{
            return 1;
        }
    }
}

