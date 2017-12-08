
import java.util.Optional;

public class EersteCijferMain {

    private static Optional<Integer> eersteCijfer(String string) {
        for (int index = 0; index != string.length(); index++) {
            char teken = string.charAt(index);
            if (Character.isDigit(teken)) {
                return Optional.of(Character.getNumericValue(teken));
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {

        Optional<Integer> optioneelCijfer = eersteCijfer("all4you");
//        if (optioneelCijfer.isPresent()){
//            System.out.println(optioneelCijfer.get() * 10);
//        }
        optioneelCijfer.ifPresent(cijfer -> System.out.println(cijfer * 10));
        
        optioneelCijfer = eersteCijfer("wrong");
//        if (optioneelCijfer.isPresent()) {
//            System.out.println(optioneelCijfer.get() * 10);
//        }
        optioneelCijfer.ifPresent(cijfer -> System.out.println(cijfer * 10));
    }
}

