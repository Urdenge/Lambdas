import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

class Main6 {
    private static final Path ARTIESTEN_PATH = Paths.get("/data/albumsartists.txt");

    public static void main(String[] args) {
    
        try (Stream<String> stream = Files.lines(ARTIESTEN_PATH)) {
            stream.map((regel -> regel.substring(regel.indexOf(',') + 1)))
                  .sorted()
                  .distinct()
                  .forEach(
            artiesten -> System.out.println(artiesten));
        } catch (Exception ex) {ex.printStackTrace();}
        
    }
}