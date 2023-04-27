import org.junit.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LeaderBoardTest {
    private static final String TEST_FILENAME = "test_leaderboard.txt";

    @Test
    void testSaveData() {
        try {
            // Create a new leaderboard instance
            Leaderboard leaderboard = new Leaderboard();

            // Add some sample entries
            leaderboard.addEntry("John: 10");
            leaderboard.addEntry("Alice: 15");
            leaderboard.addEntry("Bob: 8");

            // Save the data to a test file
            leaderboard.saveData(TEST_FILENAME);

            // Read the test file and compare the content
            List<String> expectedData = Arrays.asList("John: 10", "Alice: 15", "Bob: 8");
            List<String> actualData = readTestData(TEST_FILENAME);
            assertEquals(expectedData, actualData);

            // Clean up the test file
            deleteTestData(TEST_FILENAME);
        } catch (IOException e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testLoadData() {
        try {
            // Create a test file with some data
            writeTestData(TEST_FILENAME, Arrays.asList("John: 10", "Alice: 15", "Bob: 8"));

            // Create a new leaderboard instance and load the data
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.loadData(TEST_FILENAME);

            // Verify the loaded data
            List<String> expectedData = Arrays.asList("John: 10", "Alice: 15", "Bob: 8");
            List<String> actualData = leaderboard.getData();
            assertEquals(expectedData, actualData);

            // Clean up the test file
            deleteTestData(TEST_FILENAME);
        } catch (IOException e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

    private List<String> readTestData(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines;
    }

    private void writeTestData(String filename, List<String> data) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (String entry : data) {
            writer.write(entry + "\n");
        }
        writer.close();
    }

    private void deleteTestData(String filename) {
        File file = new File(filename);
        file.delete();
    }
}
