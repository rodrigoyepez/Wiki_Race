import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//    Checks that user has entered valid choice
    public static String userChoiceCheck(String word,ArrayList text_and_urls ){
        try {
            for (int i = 0; i < text_and_urls.size(); i++) {
                String text = text_and_urls.get(i).toString();
                if(word.equals(text)){
                    String url = text_and_urls.get(i+1).toString();
                    String[] strArray = url.split("/");
//                    strArray = strArray[2].split(":");
                    word = strArray[2];
                    return word;
                }
            }
            throw new IllegalArgumentException("Wrong input (this is not an option)");
        } catch (ArithmeticException e) {
            // throw an exception with an error message
            throw new ArithmeticException("Wrong input (this is not an option)");
        }
    }
//    iterates through the link selection
    static int wikiRaceIterator(String word, String lastWord, int result ) {
        Links links = new Links(word);
        String input_word = null;
        boolean validInput = false;
        ArrayList<String> filteredText_and_urls = links.getLinks();
        for(String text_and_urls:filteredText_and_urls) {
            System.out.println(text_and_urls);
        }
        Scanner scanner = new Scanner(System.in);
        while (!validInput) {
            try {
                System.out.println("Current Word: "+word+" Last Word:  "+lastWord);

                System.out.println("Enter your word link:");
                input_word = scanner.nextLine();
                word = userChoiceCheck(input_word, filteredText_and_urls);
                validInput = true;
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid input.");
                input_word = scanner.nextLine(); // clear the input buffer
                word = userChoiceCheck(input_word, filteredText_and_urls);
            }
        }

        result=+1;
        if (!word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").contains(lastWord.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""))) {
            wikiRaceIterator(word, lastWord, result);
        }
        else {
            System.out.println("You win!!!");
            return result;
        }
        return result;
    }
//    generates new words for the user
    static ArrayList<WikiWord> word_rerun(WikiWord firstWord, WikiWord lastWord) {
        boolean rerun = true;
        boolean validInput = false;
        ArrayList<WikiWord> WikiWords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Get new words(Y/N)?");
        String input = scanner.nextLine();
        if (input.equals("N")) {
            validInput = true;
        }
        while (!validInput) {
            try {
                if (input.equals("Y")) {
                    while (rerun) {
                        firstWord.setUrl(firstWord.wikiWrord_generator());
                        lastWord.setUrl(lastWord.wikiWrord_generator());
                        System.out.println("First Word: " + firstWord.getUrl() + " Second Word:  " + lastWord.getUrl());
                        System.out.println("Get new words(Y/N)?");
                        input = scanner.nextLine();
                        if (input.equals("N")) {
                            validInput = true;
                            rerun = false;
                        }
                        else if (!input.equals("Y")) {
                            throw new IllegalArgumentException("Wrong input (this is not an option)");
                        }
                    }
                }
                else if (input.equals("N")) {
                    validInput = true;
                }
                throw new IllegalArgumentException("Wrong input (this is not an option)");
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid input.");
                input = scanner.nextLine(); // clear the input buffer
                if (input.equals("N")) {
                    validInput = true;
                }
            }

        }
        WikiWords.add(firstWord);
        WikiWords.add(lastWord);
        return WikiWords;
    }
    public static void main(String[] args) throws IOException {

        Leaderboard leaderboard = new Leaderboard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Whats your User Name?");
        String userName =  scanner.nextLine();
        ArrayList<WikiWord> wikiWords = new ArrayList<>();
        leaderboard.loadData();
        leaderboard.printData();
        WikiWord firstWord = new WikiWord();
        WikiWord lastWord = new WikiWord();
        System.out.println("First Word: "+firstWord.getUrl()+" Second Word:  "+lastWord.getUrl());
        wikiWords = word_rerun(firstWord, lastWord);
        firstWord.setUrl(String.valueOf(wikiWords.get(0).getUrl()));
        lastWord.setUrl(String.valueOf(wikiWords.get(1).getUrl()));
        int result = wikiRaceIterator(firstWord.getUrl(),lastWord.getUrl(), 0);
        String leaderBoardEntry = userName+ " : "+result;
        leaderboard.addEntry(leaderBoardEntry);
        leaderboard.saveData();
        leaderboard.printData();


     }
}