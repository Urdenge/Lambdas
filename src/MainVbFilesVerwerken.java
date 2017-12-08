import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

class MainVbFilesVerwerken {
    private final static Path DATA_PATH = Paths.get("/data"); 
    private final static Path COUNTRIES_PATH = DATA_PATH.resolve("countries.txt"); 
    private final static Path COUNTRIES_BACKUP_PATH = DATA_PATH.resolve("countries.bak");
    private final static Path LANGUAGES_PATH = DATA_PATH.resolve("languages.txt");
    private final static Path LANGUAGES_BACKUP_PATH = DATA_PATH.resolve("languages.bak");
    
    private static void legeRegelsVerwijderen() {
        try {
            Files.deleteIfExists(COUNTRIES_BACKUP_PATH);
            Files.move(COUNTRIES_PATH, COUNTRIES_BACKUP_PATH); 

            try (BufferedReader reader = Files.newBufferedReader(COUNTRIES_BACKUP_PATH);
                Writer bufferedWriter = Files.newBufferedWriter(COUNTRIES_PATH);
                PrintWriter writer = new PrintWriter(bufferedWriter)) {
                for (String regel; (regel = reader.readLine()) != null;) { 
                    if (!regel.isEmpty()) { 
                        writer.printf("%s%n", regel); 
                    }
                }
            }
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    
    private static void dubbelsVerwijderen() {
        Set<String> uniekeTalen = new LinkedHashSet<>();
        try {
            Files.deleteIfExists(LANGUAGES_BACKUP_PATH);
            Files.move(LANGUAGES_PATH, LANGUAGES_BACKUP_PATH);

            try (BufferedReader reader=Files.newBufferedReader(LANGUAGES_BACKUP_PATH)) {
                for (String regel; (regel = reader.readLine()) != null;) { 
                    uniekeTalen.add(regel); 
                }
            }

            try (Writer bufferedWriter = Files.newBufferedWriter(LANGUAGES_PATH);
                PrintWriter writer = new PrintWriter(bufferedWriter)) {
                for (String taal : uniekeTalen) {
                    writer.printf("%s%n", taal); 
                }
                }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    
    public static void main(String[] args) {
        new Thread(() -> legeRegelsVerwijderen()).start(); 
        new Thread(() -> dubbelsVerwijderen()).start();
    }
    
}