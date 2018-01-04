package ufc.cjp;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MeuJFrame extends JFrame {

    public MeuJFrame() {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btn = new JButton("Mostrar JOptionPane");
        getContentPane().add(btn);

        // Quando clicado
        btn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                mostrarJOptionPane();
            }
        });

        // Quando uma tecla for pressionada (Nesse exemplo escolhi a tecla 'B').
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher(new KeyEventDispatcher() {
               
                public boolean dispatchKeyEvent(KeyEvent event) {
                    if(event.getID() == KeyEvent.KEY_RELEASED 
                       && event.getKeyCode() == KeyEvent.VK_ENTER){
                           mostrarJOptionPane();
                           return true;
                     }
                     return false;
                }
        }); 
    }

    private void mostrarJOptionPane(){
        JOptionPane.showMessageDialog(null, "Hello World.");
    }

    public static void main(String[] args) {
        new MeuJFrame().setVisible(true);
    }  
}