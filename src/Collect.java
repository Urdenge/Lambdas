
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Main {
public static void main(String[] args) {
Map<Integer, List<String>> groentenPerLengte =
Stream.of("sla", "kool", "wortel", "biet", "boon", "witlof", "erwt", "pastinaak", "mierikswortel", "ramenas", "tomaat", "ui", "erwt")
.collect(Collectors.groupingBy( 
groente -> groente.length())); 
groentenPerLengte.entrySet().stream()

.forEach(entry -> {System.out.print(entry.getKey()); 
entry.getValue().stream()
.forEach(groente -> System.out.print(", " + groente));
System.out.println();}); 

    System.out.println("\nCount...");
System.out.println(Stream.of("sla", "boontjes", "boontjes", "tomaat", "wortel", "kool", "biet").count());

}
}