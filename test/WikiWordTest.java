import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WikiWordTest {

    @Test
    public void testWikiWrord_generator() {
        WikiWord word = new WikiWord();
        String actualFiltered = word.wikiWrord_generator();

        // Perform assertions to validate the expected behavior
        assertNotNull(actualFiltered);
        assertFalse(actualFiltered.isEmpty());
        assertEquals(4, actualFiltered.length());
        // ... add more assertions based on your expected results
    }
}
