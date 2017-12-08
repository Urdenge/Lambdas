public class EvenGetallenMain {

    public static void main(String[] args) {

        EvenGetallen evenGetallen =
            getal -> getal % 2 == 0;
        System.out.println(evenGetallen.isEven(7));
        
    }
    
}
