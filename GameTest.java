import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class GameTest {

    //   Normal Test Cases
    @Test
    public void testWord_rerun() {
        WikiWord firstWord = new WikiWord();
        WikiWord lastWord = new WikiWord();

        ArrayList <WikiWord> actualLinks = Main.word_rerun(firstWord,lastWord);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testUserChoiceCheck() {
        String word = "Maryland";
        Links links = new Links(word);
        ArrayList<String> filteredText_and_urls = links.getLinks();
        String actualChoice = Main.userChoiceCheck(word,filteredText_and_urls);
        // Perform assertions to validate the expected behavior
        assertNotNull(actualChoice);
        assertFalse(actualChoice.isEmpty());
        assertEquals(4, actualChoice.length());
        // ... add more assertions based on your expected results
    }

    //    Empty Test cases
    @Test
    public void testWord_rerunEmpty() {
        WikiWord firstWord = new WikiWord();
        WikiWord lastWord = new WikiWord();
        firstWord.setUrl("");
        lastWord.setUrl("");

        ArrayList <WikiWord> actualLinks = Main.word_rerun(firstWord,lastWord);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testUserChoiceCheckEmpty() {
        String word = "";
        Links links = new Links(word);
        ArrayList<String> filteredText_and_urls = links.getLinks();
        String actualChoice = Main.userChoiceCheck(word,filteredText_and_urls);
        // Perform assertions to validate the expected behavior
        assertNotNull(actualChoice);
        assertFalse(actualChoice.isEmpty());
        assertEquals(4, actualChoice.length());
        // ... add more assertions based on your expected results
    }
    // Null Test cases
    @Test
    public void testWord_rerunNull() {
        WikiWord firstWord = new WikiWord();
        WikiWord lastWord = new WikiWord();
        firstWord.setUrl(null);
        lastWord.setUrl(null);

        ArrayList <WikiWord> actualLinks = Main.word_rerun(firstWord,lastWord);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testUserChoiceCheckNull() {
        String word = null;
        Links links = new Links(word);
        ArrayList<String> filteredText_and_urls = links.getLinks();
        String actualChoice = Main.userChoiceCheck(word,filteredText_and_urls);
        // Perform assertions to validate the expected behavior
        assertNotNull(actualChoice);
        assertFalse(actualChoice.isEmpty());
        assertEquals(4, actualChoice.length());
        // ... add more assertions based on your expected results
    }
    //  Wrong value types test cases
    @Test
    public void testWord_rerunWrongType() {
        WikiWord firstWord = new WikiWord();
        WikiWord lastWord = new WikiWord();
        firstWord.setUrl(null);
        lastWord.setUrl(null);

        ArrayList <WikiWord> actualLinks = Main.word_rerun(firstWord,lastWord);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testUserChoiceCheckWrongType() {
        String word = null;
        Links links = new Links(word);
        ArrayList<String> filteredText_and_urls = links.getLinks();
        String actualChoice = Main.userChoiceCheck(word,filteredText_and_urls);
        // Perform assertions to validate the expected behavior
        assertNotNull(actualChoice);
        assertFalse(actualChoice.isEmpty());
        assertEquals(4, actualChoice.length());
        // ... add more assertions based on your expected results
    }
}
