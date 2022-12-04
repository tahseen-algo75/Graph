/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */

// It compares two WebPages by their Url in alphabetical order.
import java.util.*;
public class UrlComparator implements Comparator<WebPage> {
    public int compare(WebPage web1,WebPage web2){
        return web1.getUrl().compareTo(web2.getUrl());
    }
}


