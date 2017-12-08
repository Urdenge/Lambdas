import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

class Main10 {
    private static final Path LANDEN_PATH = Paths.get("/data/landcodes.txt");

    public static void main(String[] args) {
    
        try (Stream<String> stream = Files.lines(LANDEN_PATH)) {
 
            stream.map(regel -> regel.substring(regel.indexOf(' ') + 1))
                  .max((land1, land2) -> land1.compareToIgnoreCase(land2))
                  .ifPresent(laatste -> System.out.println(laatste));
        } catch (Exception ex) {ex.printStackTrace();}
        
        
    }
}