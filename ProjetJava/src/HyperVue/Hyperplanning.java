package HyperVue;

import HyperDAO.AdministrateurDAO;
import HyperDAO.ConnexionDAO;
import HyperDAO.GroupeDAO;
import HyperDAO.SalleDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Hyperplanning extends JFrame {
    //Instanciation d'un objet JPanel
    
    JPanel pan = new JPanel();
    
    JLabel name = new JLabel("IDENTIFIANT");
    JTextField id = new JTextField(15);
    
    JLabel name1 = new JLabel("MOT DE PASSE");
    JTextField mdp = new JTextField(15);
    
    JButton btn = new JButton ("Se connecter");
    
  public Hyperplanning(){
      
    this.setTitle("CONNEXION");
    this.setSize(900, 600);
    this.setLocationRelativeTo(null);               
 
    
    
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
    
    btn.addActionListener(new BoutonListener());
    
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);        
    //On prévient notre JFrame que notre JPanel sera son content pane
    
    this.setContentPane(pan);
    this.setVisible(true);
    
    
  }
  
  class BoutonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        
        ConnexionDAO co = new ConnexionDAO();
        String email = id.getText();
        String MDP = mdp.getText();
                
        
        co.connexion(email, MDP);
        if(co.connexion(email, MDP) == true)
        {
            int droit = co.verifUtilisateur(email, MDP);
            
            if(droit == 1 || droit == 2)
            {
                AdministrateurV a = new AdministrateurV();
            }
            if(droit == 3)
            {
                try {
                //Lorsque nous cliquons sur notre bouton, on passe a l'autre fenétre
                EDTV edt = new EDTV();
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Hyperplanning.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(droit == 4)
            {
                try {
                //Lorsque nous cliquons sur notre bouton, on passe a l'autre fenétre
                EDTV edt = new EDTV();
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Hyperplanning.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
      
    }

  }
  
}

  
  public static void main(String[] args) 
  {
      Hyperplanning fen= new Hyperplanning();
      
 

  
   }

}
  
