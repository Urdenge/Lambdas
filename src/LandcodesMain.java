
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class LandcodesMain {

    private static final Path LANDCODES_PATH = Paths.get("/data/landcodes.txt"); 
    private static Optional<String> landNaam(String landcode) {
        try (BufferedReader reader = Files.newBufferedReader(LANDCODES_PATH)) {
            for (String regel; (regel = reader.readLine()) != null;) {
                int spatieIndex = regel.indexOf(' ');
                if (landcode.equals(regel.substring(0, spatieIndex))) {
                    return Optional.of(regel.substring(spatieIndex+1));
                }
            }
        }
        catch (Exception ex) { ex.printStackTrace(); }    
        
        return Optional.empty();
    }

public static void main(String[] args) {
landNaam("NL").ifPresent(landNaam -> System.out.println(landNaam));
landNaam("RU").ifPresent(landNaam -> System.out.println(landNaam));
}    
    
    
    
}
