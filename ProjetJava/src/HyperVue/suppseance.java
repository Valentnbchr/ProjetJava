package HyperVue;

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
  private JTextField semaine = new JTextField();
  //classe
  private JTextField date = new JTextField();
  
  //prof
  private JTextField professeur = new JTextField();
  

  
  //semaine
  private final JLabel label = new JLabel("Semaine :");
  //creneau
  private final JLabel label1 = new JLabel("Date :");
  //boutton
  private JButton annuler = new JButton ("Annuler");
  //date
   private final JLabel label2 = new JLabel("Creneau :");
   //heure début
   private JLabel label3 = new JLabel("Nom Professeur :");
   //creneau
   private JComboBox creneau = new JComboBox();

  public suppseance(){
    this.setTitle("Animation");
    this.setSize(350, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();        
    Font police = new Font("Arial", Font.BOLD, 14);
    semaine.setFont(police);
    semaine.setPreferredSize(new Dimension(250, 30));
    semaine.setForeground(Color.BLUE);
    date.setPreferredSize(new Dimension(290, 30));
        creneau.setPreferredSize(new Dimension(270, 20));
    //etat
    creneau.addItem("8h30/10h");
    creneau.addItem("10h/11h30");
    creneau.addItem("11h30/13h"); 
    creneau.addItem("13h/14h30");
    creneau.addItem("14h30/16h"); 
    creneau.addItem("16h/17h30"); 
    creneau.addItem("17h30/19h");
    
    professeur.setPreferredSize(new Dimension(290, 30));

    //boutton
    annuler.addActionListener(new BoutonListener());
    
    //semaine
    top.add(label);
    top.add(semaine);
    //date
    top.add(label1);
    top.add(date); 
    ///creneau
    top.add(label2);
    top.add(creneau);
    //professeur
    top.add(label3);
    top.add(professeur);
    //boutton
    top.add(annuler);
    
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setContentPane(top);
    this.setVisible(true);            
  }       

  class BoutonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        
      AdministrateurDAO a = new AdministrateurDAO();
      a.etatseance(Integer.parseInt(semaine.getText()), date.getText(), creneau.getSelectedItem().toString(), professeur.getText(), "Annulé");
      
    }
  }
  
}