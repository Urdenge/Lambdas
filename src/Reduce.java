import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

class Main8 {
public static void main(String[] args) {
    System.out.println(
    Stream.of(
    BigDecimal.valueOf(1.1), BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.5))
              .reduce(BigDecimal.ZERO, (vorigeSom, getal) -> vorigeSom.add(getal)));
    
    Stream.of(
    BigDecimal.valueOf(1.1), BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.5))
              .reduce((vorigeSom, getal) -> vorigeSom.add(getal))
              .ifPresent(som -> System.out.println(som));
    
    Stream.of("The lord of the rings", "The hobbit")
          .map(titel -> titel.split(" ")) 
          .flatMap(array -> Arrays.stream(array)) 
          .map(woord -> woord.toLowerCase()) 
//          .distinct()
//          .sorted()
          .forEach(woord -> System.out.println(woord));
    
}
}