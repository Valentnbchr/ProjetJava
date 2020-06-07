package HyperVue;

import HyperDAO.EtudiantDAO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
//Les imports habituels

public class AdministrateurV extends JFrame {  
    
  private JPanel container = new JPanel();
    //eleve
  private JTextField Eleve = new JTextField(15);
  //classe
  private JTextField Classe = new JTextField(15);
    //prof
  private JTextField professeur = new JTextField(15);

  
  //semaine
  private final JLabel label = new JLabel("eleve");
  //boutton
  private JButton b = new JButton ("Voir votre EDT");
  private JButton b1 = new JButton ("Ajouter séance");
  private JButton b2 = new JButton ("Modifier séance");
  private JButton b3 = new JButton ("Supprimer séance");
  //date
   private final JLabel label2 = new JLabel("classe");
   //heure début
   private JLabel label3 = new JLabel("professeur");

  public AdministrateurV(){
    this.setTitle("Animation");
    this.setSize(900, 600);
    this.setLocationRelativeTo(null);   
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    
    JPanel top = new JPanel();  
        //ajout d'un gridbagLayout
    top.setLayout(new GridBagLayout());
    
    //ajout d'un gridBagConstraints
    GridBagConstraints gc = new GridBagConstraints();

    //boutton
    b.addActionListener(new BoutonListener());
    b1.addActionListener(new BoutonListener1());
    b2.addActionListener(new BoutonListener2());
    b3.addActionListener(new BoutonListener3()); 
    
    gc.weightx=0.5;
    gc.weighty=0.5;
    gc.anchor=GridBagConstraints.LINE_START;
    gc.gridx = 2;
    gc.gridy= 0;
    top.add(b,gc);
    
    //boutton
    gc.anchor=GridBagConstraints.LINE_END;
    //semaine
    gc.gridx = 1;
    gc.gridy= 1;
    top.add(label, gc);
    //date
    gc.gridx = 1;
    gc.gridy= 2;
    top.add(label2, gc);
    //professeur
    gc.gridx = 1;
    gc.gridy= 3;
    top.add(label3, gc);
    //semaine
    gc.anchor=GridBagConstraints.LINE_START;
    gc.gridx = 2;
    gc.gridy= 1;
    top.add(Eleve, gc);
    //date
    gc.gridx = 2;
    gc.gridy= 2;
    top.add(Classe, gc);
    //professeur
    gc.gridx = 2;
    gc.gridy= 3;
    top.add(professeur, gc);
    
        ///espace
    gc.weighty=1;
    
    gc.anchor=GridBagConstraints.FIRST_LINE_START;
    gc.gridx = 2;
    gc.gridy=4;
    top.add(b1,gc);
    gc.gridx = 2;
    gc.gridy=5;
    top.add(b2,gc);
    gc.gridx = 2;
    gc.gridy=6;
    top.add(b3,gc);

    
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
     //Définition de sa couleur de fond
    top.setBackground(Color.ORANGE);        
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(top);
    this.setVisible(true);        
  }       

  class BoutonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        String nom = Eleve.getText();
        EtudiantDAO etu = new EtudiantDAO();
        String email = etu.getemail(nom);
        String mdp = etu.getMDP(nom);

        EDTV edt = new EDTV(email, mdp);


    }
  }
  class BoutonListener1 implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      AjoutSeanceV as = new AjoutSeanceV();
    }
  }
  class BoutonListener2 implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      modifseance m = new modifseance();
    }
  }
  class BoutonListener3 implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      suppseance ss = new suppseance();
    }
  }
  
}