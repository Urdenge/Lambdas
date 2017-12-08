import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Main4 {
    private static final Path STERRENBEELDEN_PATH = Paths.get("/data/sterrenbeelden.txt");

    public static void main(String[] args) {
    
    try (Stream<String> stream = Files.lines(STERRENBEELDEN_PATH)) {
            stream.sorted((groente1, groente2) -> groente1.length() - groente2.length())
                  .forEach(sterrenbeeld -> System.out.println(sterrenbeeld));
    } catch (Exception ex) {ex.printStackTrace();}
    }
}