import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Windooke extends JFrame { 
    private static final long serialVersionUID = 1L;
    private final int teRadenGetal = new Random().nextInt(10) + 1;
    private final JTextField textField = new JTextField(); 
    private final JButton buttonGok = new JButton("Gok!");     
    private int beurten;
    
    Windooke() {
        super("Gokgek"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        add(textField, BorderLayout.NORTH); 
        add(buttonGok, BorderLayout.SOUTH); 
        
        buttonGok.addActionListener(event -> gok());
        pack();
    }

    private void gok(){
        beurten++;
        try{
        int getal = Integer.parseInt(textField.getText());
        if (getal == teRadenGetal)
            JOptionPane.showMessageDialog(this, "Yep! Gevonden in " + beurten + " beurten");
        else
            JOptionPane.showMessageDialog(this, getal > teRadenGetal ? "Lager" : "Hoger");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Tik een getal");
        }
    }
}    


class HogerLagerMain {
    public static void main(String[] args) {

        new Windooke().setVisible(true); 

    }
}