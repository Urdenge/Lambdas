import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Main11 {
    private static final Path ACTEURS_PATH = Paths.get("/data/acteurs-actrices.csv");
    
    public static void main(String[] args) {
    try (Stream<String> stream = Files.lines(ACTEURS_PATH)) {
        System.out.println(stream.map(regel->regel.split(";")[2])
                                 .filter(geslacht -> "F".equals(geslacht))
                                 .count());
    } catch (IOException ex) {ex.printStackTrace();}
}
}