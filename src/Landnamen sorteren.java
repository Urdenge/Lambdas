import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

class Main7 {
    private static final Path LANDNAMEN_PATH = Paths.get("/data/countries.txt");

    public static void main(String[] args) {
    
        try (Stream<String> stream = Files.lines(LANDNAMEN_PATH)) {
            stream.map(regel -> regel.substring(regel.indexOf(' ') + 1))
                  .sorted()
                  .distinct()
                  .forEach(land -> System.out.println(land));
        } catch (Exception ex) {ex.printStackTrace();}
        
    }
}