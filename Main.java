import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
     static ArrayList JsoupGetLinks(String word){
        Document document;
        ArrayList<String> texts_and_urls = new ArrayList<>();
        try {
//Get Document object after parsing the html from given url.
            document = Jsoup.connect("https://en.wikipedia.org/wiki/"+ word).get();
//Get links from document object.
            Elements text = document.select("#bodyContent");
            Elements links = text.select("a[href]");

//Iterate links and print link attributes.
            for (Element link : links) {
                texts_and_urls.add(link.text());
                texts_and_urls.add(link.attr("href"));
            }
            return texts_and_urls;
        } catch (IOException e) {
            e.printStackTrace();
            return texts_and_urls;
        }
    }
    static ArrayList removeUnwantedStrings(ArrayList text_and_urls){
        ArrayList<String> filteredText_and_urls = new ArrayList<>();
        for (int i = 0; i < text_and_urls.size(); i++) {
            if (i % 2 != 0) {
                String url = text_and_urls.get(i).toString();
                String text = text_and_urls.get(i-1).toString();

                if (url.contains("wiki/")) {
                    filteredText_and_urls.add(text);
                    filteredText_and_urls.add(url);
                }
            }
        }
        return filteredText_and_urls;
    }
    static String userChoiceCheck(String word,ArrayList text_and_urls ){
        try {
            for (int i = 0; i < text_and_urls.size(); i++) {
                String text = text_and_urls.get(i).toString();
                if(word.equals(text)){
                    String url = text_and_urls.get(i+1).toString();
                    String[] strArray = url.split("/");
                    word = strArray[1];
                    return word;
                }
            }
            throw new IllegalArgumentException("Wrong input (this is not an option)");
        } catch (ArithmeticException e) {
            // throw an exception with an error message
            throw new ArithmeticException("Wrong input (this is not an option)");
        }
    }
    static void wikiRaceIterator(String word, String lastWord) {
        ArrayList<String> texts_and_urls = new ArrayList<>();
        ArrayList<String> filteredText_and_urls = new ArrayList<>();
        texts_and_urls = JsoupGetLinks(word);
        boolean validInput = false;
//        filteredText_and_urls = removeUnwantedStrings(texts_and_urls);
        for(String text_and_urls:texts_and_urls) {
            System.out.println(text_and_urls);
        }
        Scanner scanner = new Scanner(System.in);
        while (!validInput) {
            try {
                System.out.println("Enter your word link:");
                word = scanner.nextLine();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid input.");
                scanner.nextLine(); // clear the input buffer
            }
        }
        System.out.println(word);

        if (!word.equals(lastWord)) {
            wikiRaceIterator(word, lastWord);
        } else {
            System.out.println("You win!!!");

        }
    }

    public static void main(String[] args) {
        String randomWord = Word.generate();
        System.out.println(randomWord);
        String firstWord = "Maryland";
        String lastWord = "Orange";
        wikiRaceIterator(firstWord,lastWord);
    }
}