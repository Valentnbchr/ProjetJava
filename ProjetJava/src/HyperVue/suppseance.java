package HyperVue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import HyperDAO.AdministrateurDAO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
//Les imports habituels
 
 
public class suppseance extends JFrame {
  private JPanel container = new JPanel();
    //eleve
  private JTextField eleve = new JTextField(15);
  //classe
  private JTextField classe = new JTextField(15);
  //prof
  private JTextField professeur = new JTextField(15);
   
  //semaine
  private final JLabel label = new JLabel("date");
  //creneau
  private final JLabel label1 = new JLabel("creneau");
  //boutton
  private JButton annuler = new JButton ("Annuler");
  //date
   private final JLabel label2 = new JLabel("semaine");
   //heure début
   private JLabel label3 = new JLabel("professeur");
   //creneau
   private JComboBox creneau = new JComboBox();

  public suppseance(){
    this.setTitle("Supprimer Séance");
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
    
    
    creneau.setPreferredSize(new Dimension(270, 20));
        
    //etat
    creneau.addItem("8h30/10h00");
    creneau.addItem("10h00/11h30");
    creneau.addItem("11h30/13h00"); 
    creneau.addItem("14h30/16h00");
    creneau.addItem("16h00/17h30"); 
    creneau.addItem("17h30/19h00"); 

    //boutton
    annuler.addActionListener(new BoutonListener());
    
    gc.weightx=0.5;
    gc.weighty=0.5;
    
    gc.anchor=GridBagConstraints.LINE_END;
    //semaine
    gc.gridx = 1;
    gc.gridy= 0;
    top.add(label, gc);
    //date
    gc.gridx = 1;
    gc.gridy= 1;
    top.add(label2,gc); 
    ///creneau
    gc.gridx = 1;
    gc.gridy= 2;
    top.add(label1,gc);
    //professeur
    gc.gridx = 1;
    gc.gridy= 3;
    top.add(label3,gc);
    
    
    gc.anchor=GridBagConstraints.LINE_START;
    //semaine
    gc.gridx = 2;
    gc.gridy= 0;
    top.add(eleve, gc);
    //date
    gc.gridx = 2;
    gc.gridy= 1;
    top.add(classe,gc); 
    ///creneau
    gc.gridx = 2;
    gc.gridy= 2;
    top.add(creneau,gc);
    //professeur
    gc.gridx = 2;
    gc.gridy= 3;
    top.add(professeur,gc);
    
    
    //boutton
    gc.weighty=1;
    
    gc.anchor=GridBagConstraints.FIRST_LINE_START;
    gc.gridx = 2;
    gc.gridy=4;
    top.add(annuler,gc);
    
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
        
      AdministrateurDAO a = new AdministrateurDAO();
      a.etatseance(Integer.parseInt(eleve.getText()), classe.getText(), creneau.getSelectedItem().toString(), professeur.getText(), "Annulé");
      
    }
  }
  
}