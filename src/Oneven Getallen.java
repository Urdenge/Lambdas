import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class Main5 {
    private static final Path STERRENBEELDEN_PATH = Paths.get("/data/sterrenbeelden.txt");

    public static void main(String[] args) {
    
    List<Integer> getallen = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    for (int getal; (getal = scanner.nextInt()) != 0;) {
        getallen.add(getal);
        
    }
        System.out.println("\nRij van getallen...");
    getallen.stream().sorted().filter(getal -> getal %2 == 1).forEach(nummer -> System.out.println(nummer));
    
    }
}