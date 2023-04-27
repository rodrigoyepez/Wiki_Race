import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LinksTest {
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
}
