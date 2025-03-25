import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ProblemDatabase {
    private Map<Integer, List<MathProblem>> problemsByTopic;

    public ProblemDatabase() {
        problemsByTopic = new HashMap<>();
        try {
            loadFromFile("problems.txt");  // Note the quotes around the filename
        } catch (IOException e) {
            System.err.println("Error loading problem database: " + e.getMessage());
        }
    }

    private void loadFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            // Skip empty lines and comments
            if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                continue;
            }

            String[] parts = line.split("\\|");
            if (parts.length == 3) {
                try {
                    int topic = Integer.parseInt(parts[0].trim());
                    String question = parts[1].trim();
                    double answer = Double.parseDouble(parts[2].trim());

                    problemsByTopic.computeIfAbsent(topic, k -> new ArrayList<>())
                            .add(new MathProblem(question, answer, topic));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        }
    }

    // Rest of your methods...
}