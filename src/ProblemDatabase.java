import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ProblemDatabase {
    private Map<Integer, List<MathProblem>> problemsByTopic;

    public ProblemDatabase() throws IOException {
        this("src/problems.txt");
    }

    public ProblemDatabase(String filename) throws IOException {
        problemsByTopic = new HashMap<>();
        loadFromFile(filename);
    }

    public ProblemDatabase(Map<Integer, List<MathProblem>> emptyMap) {
        problemsByTopic = emptyMap;
    }

    private void loadFromFile(String filename) throws IOException {
        System.out.println("Loading problems from: " + Paths.get(filename).toAbsolutePath());

        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            String[] parts = line.split("\\|");
            if (parts.length == 3) {
                try {
                    int topic = Integer.parseInt(parts[0].trim());
                    String question = parts[1].trim();
                    String answer = parts[2].trim();

                    problemsByTopic.computeIfAbsent(topic, k -> new ArrayList<>())
                            .add(new MathProblem(question, answer, topic));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        }

        System.out.println("Loaded problems for topics: " + problemsByTopic.keySet());
    }

    public MathProblem getRandomProblem(int topic) {
        List<MathProblem> problems = problemsByTopic.get(topic);
        if (problems == null || problems.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return problems.get(random.nextInt(problems.size()));
    }
}