import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

class Main12 {
    private static final Path PATH = Paths.get("/data/acteurs-actrices.csv");

    public static void main(String[] args) {
//        try (Stream<String> stream = Files.lines(PATH)) {
//            stream.anyMatch(actrice -> actrice.toUpperCase().equals("VICKI"))
//                  .forEach(actrice -> System.out.println(actrice));
//        } catch (Exception ex) {ex.printStackTrace();}
        
        
//        try (Stream<String> stream = Files.lines(PATH)) {
//            System.out.println(stream.map(regel -> regel.split(";")[0])
//            System.out.println(stream.filter()
//                                     .anyMatch(voornaam -> "Vicki".equals(voornaam)) ? (actrice -> System.out.println(actrice)) : "komt niet voor");
//            } catch (IOException ex) {ex.printStackTrace();}
//        

 
    System.out.print("Naam:");
    try (Scanner scanner = new Scanner(System.in)) {
        String woord = scanner.next().toUpperCase();
        try (Stream<String> stream = Files.lines(PATH)) {
//            stream.map((regel -> regel.substring(regel.indexOf(';') + 1)))
                    stream
                  .filter(naam -> naam.toUpperCase().contains(woord))
                  .filter(regel -> regel.substring(regel.lastIndexOf(";")).contains("F")) 
                  .forEach(naam -> System.out.println(naam)); 
        } catch (Exception ex) {ex.printStackTrace();}
    }
}

}