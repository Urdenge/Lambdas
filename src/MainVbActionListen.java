import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Vensterr extends JFrame { 
    private static final long serialVersionUID = 1L;
    Vensterr() {
        super("Conversie"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JTextField textField = new JTextField(); 
        JButton buttonHoofdLetters = new JButton("hoofdletters"); 
        JButton buttonKleineLetters = new JButton("kleine letters");
        buttonHoofdLetters.addActionListener(
        e -> textField.setText(textField.getText().toUpperCase())); 
        buttonKleineLetters.addActionListener(
        e -> textField.setText(textField.getText().toLowerCase()));
        add(textField, BorderLayout.NORTH); 
        add(buttonHoofdLetters, BorderLayout.WEST); 
        add(buttonKleineLetters, BorderLayout.EAST); 
        pack();
    }
}

class Hoofd {
public static void main(String[] args) {
new Vensterr().setVisible(true); 
}
}