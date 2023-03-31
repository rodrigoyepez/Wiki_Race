import java.io.IOException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiLink {

    private static final String WIKI_URL = "https://en.wikipedia.org";
    private static final int MAX_DEPTH = 10;

    public static String getRandomWikiPage() throws IOException {
        Random random = new Random();
        String startingPage = "/wiki/Special:Random";
        String nextPage = startingPage;
        Document doc = null;
        for (int i = 0; i < MAX_DEPTH; i++) {
            doc = Jsoup.connect(WIKI_URL + nextPage).get();
            Elements links = doc.select("#content a[href^=/wiki/]");
            if (links.isEmpty()) {
                return null;
            }
            Element link = links.get(random.nextInt(links.size()));
            nextPage = link.attr("href");
            if (!nextPage.startsWith("/wiki/Template:") && !nextPage.startsWith("/wiki/File:")
                    && !nextPage.startsWith("/wiki/Help:") && !nextPage.startsWith("/wiki/Wikipedia:")
                    && !nextPage.startsWith("/wiki/Category:") && !nextPage.startsWith("/wiki/Portal:")
                    && !nextPage.startsWith("/wiki/Special:")) {
                return WIKI_URL + nextPage;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

    }
}
