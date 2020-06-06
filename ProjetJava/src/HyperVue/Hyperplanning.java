import java.awt.Color; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Hyperplanning extends JFrame {
  public Hyperplanning(){             
    this.setTitle("CONNEXION");
    this.setSize(900, 600);
    this.setLocationRelativeTo(null);               
 
    //Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    
    JLabel name = new JLabel("IDENTIFIANT");
    JTextField id = new JTextField(15);
    
    JLabel name1 = new JLabel("MOT DE PASSE");
    JTextField mdp = new JTextField(15);
    
    JButton btn = new JButton ("Se connecter");
    
    //ajout d'un gridbagLayout
    pan.setLayout(new GridBagLayout());
    
    //ajout d'un gridBagConstraints
    GridBagConstraints gc = new GridBagConstraints();

    gc.anchor=GridBagConstraints.LINE_END;
    gc.weightx=0.5;
    gc.weighty=0.5;
    
    gc.gridx=1;
    gc.gridy=1;
    pan.add(name,gc);
    
    gc.gridx=1;
    gc.gridy=2;
    pan.add(name1,gc);
    
    gc.anchor=GridBagConstraints.LINE_START;
    gc.gridx=2;
    gc.gridy=2;
    pan.add(mdp,gc);
    
    gc.gridx=2;
    gc.gridy=1;
    pan.add(id,gc);
    
    ///espace
    gc.weighty=3;
    
    gc.anchor=GridBagConstraints.FIRST_LINE_START;
    gc.gridx = 2;
    gc.gridy=3;
    pan.add(btn,gc);
    
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);        
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(pan);
    this.setVisible(true);
  }
  
  public static void main(String[] args) 
  {
      
    Hyperplanning fen= new Hyperplanning();
  
  }
  
}
