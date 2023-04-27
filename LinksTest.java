import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LinksTest {

//   Normal Test Cases
    @Test
    public void testJsoupGetLinks() {
        Links links = new Links("Java");
        ArrayList<String> actualLinks = links.JsoupGetLinks("Java");

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testRemoveUnwantedStrings() {
        Links links = new Links("Java");
        ArrayList<String> inputList = links.JsoupGetLinks("Java");
        ArrayList<String> actualFiltered = links.removeUnwantedStrings(inputList);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualFiltered);
        assertFalse(actualFiltered.isEmpty());
        assertEquals(4, actualFiltered.size());
        // ... add more assertions based on your expected results
    }

//    Empty Test cases
    @Test
    public void testJsoupGetLinksEmpty() {
        Links links = new Links("");
        ArrayList<String> actualLinks = links.JsoupGetLinks("Java");

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testRemoveUnwantedStringsEmpty() {
        Links links = new Links("");
        ArrayList<String> inputList = links.JsoupGetLinks("Java");
        ArrayList<String> actualFiltered = links.removeUnwantedStrings(inputList);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualFiltered);
        assertFalse(actualFiltered.isEmpty());
        assertEquals(4, actualFiltered.size());
        // ... add more assertions based on your expected results
    }
// Null Test cases
    @Test
    public void testJsoupGetLinksNull() {
        Links links = new Links(null);
        ArrayList<String> actualLinks = links.JsoupGetLinks("Java");

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testRemoveUnwantedStringsNull() {
        Links links = new Links(null);
        ArrayList<String> inputList = links.JsoupGetLinks("Java");
        ArrayList<String> actualFiltered = links.removeUnwantedStrings(inputList);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualFiltered);
        assertFalse(actualFiltered.isEmpty());
        assertEquals(4, actualFiltered.size());
        // ... add more assertions based on your expected results
    }
//  Wrong value types test cases
    @Test
    public void testJsoupGetLinksWrongType() {
        Links links = new Links(Double.toString(1.0));
        ArrayList<String> actualLinks = links.JsoupGetLinks("Java");

        // Perform assertions to validate the expected behavior
        assertNotNull(actualLinks);
        assertFalse(actualLinks.isEmpty());
        assertEquals(20, actualLinks.size());
        // ... add more assertions based on your expected results
    }

    @Test
    public void testRemoveUnwantedStringsWrongType() {
        Links links = new Links(Double.toString(1.0));
        ArrayList<String> inputList = links.JsoupGetLinks("Java");
        ArrayList<String> actualFiltered = links.removeUnwantedStrings(inputList);

        // Perform assertions to validate the expected behavior
        assertNotNull(actualFiltered);
        assertFalse(actualFiltered.isEmpty());
        assertEquals(4, actualFiltered.size());
        // ... add more assertions based on your expected results
    }
}
