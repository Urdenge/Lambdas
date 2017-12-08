
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArtiestenEnAlbums {
private static final Path ARTIESTEN_PATH = Paths.get("/data/albumsartists.txt");

public static void main(String[] args) {

    try (Stream<String> stream = Files.lines(ARTIESTEN_PATH)) {
        
        Map<String, List<String>> albumsPerArtiest = stream.collect(Collectors.groupingBy(regel -> regel.substring(regel.indexOf(',') + 1)));
        
        albumsPerArtiest.entrySet()
                        .stream()
                        .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                        .forEach(entry -> {System.out.println(entry.getKey());
        
        entry.getValue().stream()
                        .map(regel -> regel.substring(0, regel.indexOf(',')))
                        .sorted()
                        .forEach(album -> System.out.println("\t" + album));
        });
    } catch (IOException ex) {
        ex.printStackTrace();
        }

    }
    
}
