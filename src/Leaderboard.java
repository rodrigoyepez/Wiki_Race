import java.io.*;
import java.util.*;

public class Leaderboard {
    private static final String FILENAME = "leaderboard.txt";
    private List<String> data;

    public Leaderboard() {
        this.data = new ArrayList<String>();
    }

    public void addEntry(String entry) {
        this.data.add(entry);
    }

    public void saveData() throws IOException {
        FileWriter writer = new FileWriter(FILENAME);
        for (String entry : this.data) {
            writer.write(entry + "\n");
        }
        writer.close();
    }

    public void loadData() throws IOException {
        FileReader reader = new FileReader(FILENAME);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            this.data.add(line);
        }
        reader.close();
    }

    public void printData() {
        for (String entry : this.data) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) throws IOException {

    }
}

