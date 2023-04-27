import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Links {
    private ArrayList<String> filteredTextAndUrls = new ArrayList<>();
    private String word;

    public Links(String word) {
        this.filteredTextAndUrls = removeUnwantedStrings(JsoupGetLinks(word));
    }

    public ArrayList getLinks() {
        this.filteredTextAndUrls = removeUnwantedStrings(JsoupGetLinks(word));
        return filteredTextAndUrls;
    }
    public void setWord(String word) {
        this.word = word;
    }
    //    generates links form body of wiki page based on user choices
    public ArrayList<String> JsoupGetLinks(String word) {
        Document document;
        ArrayList<String> textsAndUrls = new ArrayList<>();
        try {
            //Get Document object after parsing the html from given url.
            document = Jsoup.connect("https://en.wikipedia.org/wiki/" + word).get();
            //Get links from document object.
            Elements text = document.select("#bodyContent");
            Elements links = text.select("a[href]");
            //Iterate links and print link attributes.
            for (Element link : links) {
                textsAndUrls.add(link.text());
                textsAndUrls.add(link.attr("href"));
            }
            return textsAndUrls;
        } catch (IOException e) {
            e.printStackTrace();
            return textsAndUrls;
        }
    }
    //    removes links from user choices if links aren't needed
    public ArrayList<String> removeUnwantedStrings(ArrayList<String> textAndUrls) {
        for (int i = 0; i < textAndUrls.size(); i++) {
            if (i % 2 != 0) {
                String url = textAndUrls.get(i);
                String text = textAndUrls.get(i - 1);

                if (url.contains("wiki/")) {
                    filteredTextAndUrls.add(text);
                    filteredTextAndUrls.add(url);
                }
            }
        }
        return filteredTextAndUrls;
    }
}
