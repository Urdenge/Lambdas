
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Streams {
private final static Path LANGUAGES_PATH = Paths.get("/data/languages.txt");
private final static Path DATA_PATH = Paths.get("/data");

public static void main(String[] args) {

        "Lambdafun".chars()
        .forEach(unicode->System.out.println((char) unicode));
    
    
        System.out.println("\n");
        Map<String, String> talen = new LinkedHashMap<>();
        talen.put("NL", "Nederlands");
        talen.put("FR", "Frans");
        talen.entrySet().stream()
        .forEach(entry -> System.out.println(entry.getKey() + ':' +
        entry.getValue()));
    
        
        try (Stream<String> stream = Files.lines(LANGUAGES_PATH)) { 
            stream.forEach(regel -> System.out.println(regel));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("\n");
        try (Stream<Path> stream = Files.list(DATA_PATH)) {
        stream.forEach(entry -> System.out.println(entry.getFileName()));
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        
        System.out.println("\nSorted");
        Stream.of("sla", "wortel", "kool", "biet")
        .sorted()
        .forEach(pruts -> System.out.println(pruts));
        
        System.out.println("\nSorted andersom");
        Comparator<String> comparator =
        (groente1, groente2) -> groente2.compareTo(groente1); 
        Stream.of("sla", "wortel", "kool", "biet")
        .sorted(comparator)
        .forEach(pruts -> System.out.println(pruts));
        
        System.out.println("\nOp lengte");
        Stream.of("sla", "wortel", "kool", "biet")
        .sorted((groente1, groente2) -> groente1.length() - groente2.length()) 
        .forEach(pruts -> System.out.println(pruts));
        
        System.out.println("\nRechthoek");
        Stream.of(new Rechthoek(6, 2), new Rechthoek(3, 1), new Rechthoek(5, 4))
        .map(rechthoek -> rechthoek.getOppervlakte()) 
        .sorted() 
        .forEach(oppervlakte -> System.out.println(oppervlakte));
        
        System.out.println("\nAll match");
        System.out.println(
        Stream.of("sla", "wortel", "kool", "biet")
        .allMatch(groente -> groente.length() == 4));
        
        
        
    }
    
}