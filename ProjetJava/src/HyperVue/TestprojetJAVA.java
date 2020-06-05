import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestprojetJAVA extends JFrame implements ActionListener {
       private Fenetre2 fen;
           private final JPanel pan = new JPanel();
        
           private final JButton bouton1 = new JButton("Start");
           public TestprojetJAVA(){
           pan.setLayout(null);
           this.setTitle("Interface graphique");
           this.setSize(400, 500);
           this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           this.setLocationRelativeTo(null);
        
           bouton1.setBackground(Color.cyan);
           bouton1.setBounds(200,150, 300, 200);
         
           pan.add(bouton1);   
 
                            
           setContentPane(pan);
           bouton1.addActionListener(this);
           this.setVisible(true);                             
        }
       public void actionPerformed(ActionEvent arg0) {
           //Lorsque nous cliquons sur notre bouton, on passe a l'autre fenétre
            this.dispose();
            fen = new Fenetre2();
   }             
       public static void main(String[] args) {
        // TODO Auto-generated method stub
          
    TestprojetJAVA fen= new TestprojetJAVA();
   }
 
}