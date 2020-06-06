/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HyperVue;

/**
 *
 * @author valentinbchr
 */
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
 
public class modifseance extends JFrame {
  private JPanel container = new JPanel();
  
  AdministrateurDAO a = new AdministrateurDAO();
  
  ///lister cours prévu
  
   //semaine
  private JTextField semaine = new JTextField();
  //date
  private JTextField date = new JTextField();
  //prof
  private JTextField professeur = new JTextField();
  //groupe
  private JComboBox groupe = new JComboBox();
  //creneau
  private JComboBox creneau = new JComboBox();
  
  //date
  private final JLabel label = new JLabel("Semaine :");
  //creneau
  private final JLabel label1 = new JLabel("Creneau :");
  //semaine
   private final JLabel label2 = new JLabel("Date :");
   //prof
   private JLabel label3 = new JLabel("Professeur :");
   //groupe
   private JLabel label4 = new JLabel("Groupe :");
   
   
   
   
   /// lister nouvelle séance
   
       //semaine
  private JTextField semaine1 = new JTextField();
  //date
  private JTextField date1 = new JTextField();
  //prof
  private JTextField professeur1 = new JTextField();  
  
  //date
  private final JLabel label10 = new JLabel("Semaine :");
  //creneau
  private final JLabel label11 = new JLabel("Creneau :");
  //boutton
  private JButton confirmer1 = new JButton ("Confirmer");
  //semaine
   private final JLabel label12 = new JLabel("Date :");
   //prof
   private JLabel label13 = new JLabel("Professeur :");
   //creneau
   private JComboBox creneau1 = new JComboBox();
      //etat du cours
   private JComboBox etat = new JComboBox();
    private JLabel label14 = new JLabel("Etat cours :");
    //matière
   private JComboBox matiere = new JComboBox();
      private JLabel label15 = new JLabel("Matière :");
      //salle
   private JComboBox salle = new JComboBox();
      private JLabel label16 = new JLabel("Salle de cours :");
      //type de cours
   private JComboBox type = new JComboBox();
      private JLabel label17 = new JLabel("Type de cours :");
   //groupe   
   private JComboBox groupe1 = new JComboBox();
   private JLabel label18 = new JLabel("Groupe :");

  public modifseance(){
    this.setTitle("Modification de Séance");
    this.setSize(350, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();        
    Font police = new Font("Arial", Font.BOLD, 14);
    
    ///lister cours prévu
    
    semaine.setFont(police);
    semaine.setPreferredSize(new Dimension(250, 30));
    semaine.setForeground(Color.BLUE);
    date.setPreferredSize(new Dimension(290, 30));
    creneau.setPreferredSize(new Dimension(270, 20));
    
    //creneau
    creneau.addItem(" ");
    creneau.addItem("8h30/10h");
    creneau.addItem("10h/11h30");
    creneau.addItem("11h30/13h"); 
    creneau.addItem("13h/14h30");
    creneau.addItem("14h30/16h"); 
    creneau.addItem("16h/17h30"); 
    creneau.addItem("17h30/19h"); 
    
    professeur.setPreferredSize(new Dimension(290, 30));
    groupe.setPreferredSize(new Dimension(290, 30));
    groupe.addItem(" ");
    groupe.addItem("TD1");
    groupe.addItem("TD2");
    groupe.addItem("TD3"); 
    groupe.addItem("TD4");
    groupe.addItem("TD4"); 
    groupe.addItem("TD4"); 
 
    
    //semaine
    top.add(label);
    top.add(semaine);
    //date
    top.add(label2);
    top.add(date); 
    ///creneau
    top.add(label1);
    top.add(creneau);
    //professeur
    top.add(label3);
    top.add(professeur);
    //groupe
    top.add(label4);
    top.add(groupe);
 
    
    ///lister nouvelle séance
    
    semaine1.setFont(police);
    semaine1.setPreferredSize(new Dimension(250, 30));
    semaine1.setForeground(Color.BLUE);
    date1.setPreferredSize(new Dimension(290, 30));
    creneau1.setPreferredSize(new Dimension(270, 20));
    etat.setPreferredSize(new Dimension(270, 20));
    matiere.setPreferredSize(new Dimension(270, 20));
    salle.setPreferredSize(new Dimension(270, 20));
    type.setPreferredSize(new Dimension(270, 20));
    
    //creneau
    creneau1.addItem(" ");
    creneau1.addItem("8h30/10h");
    creneau1.addItem("10h/11h30");
    creneau1.addItem("11h30/13h"); 
    creneau1.addItem("13h/14h30");
    creneau1.addItem("14h30/16h"); 
    creneau1.addItem("16h/17h30"); 
    creneau1.addItem("17h30/19h"); 
    
    professeur1.setPreferredSize(new Dimension(290, 30));
    groupe1.setPreferredSize(new Dimension(290, 30));
    groupe1.addItem(" ");
    groupe1.addItem("TD1");
    groupe1.addItem("TD2");
    groupe1.addItem("TD3"); 
    groupe1.addItem("TD4");
    groupe1.addItem("TD4"); 
    groupe1.addItem("TD4");

    //boutton
    confirmer1.addActionListener(new BoutonListener());
    
        //creneau
    etat.addItem(" ");
    etat.addItem("En cours de validation");
    etat.addItem("Validé");
    etat.addItem("Annulé"); 
    
        //creneau
    matiere.addItem(" ");
    matiere.addItem("Anglais");
    matiere.addItem("Thermodynamique");
    matiere.addItem("Mathématiques"); 
    
        //creneau
    salle.addItem(" ");
    salle.addItem("SC217");
    salle.addItem("EM409");
    salle.addItem("P315"); 
    salle.addItem("P445");
    salle.addItem("G004"); 
    salle.addItem("G019"); 
    
        //type de cours
    type.addItem(" ");
    type.addItem("Amphi");
    type.addItem("TP");
    type.addItem("TD"); 
    
    //semaine
    top.add(label10);
    top.add(semaine1);
    //date
    top.add(label12);
    top.add(date1); 
    ///creneau
    top.add(label11);
    top.add(creneau1);
    //professeur
    top.add(label13);
    top.add(professeur1);
    //groupe
    top.add(label18);
    top.add(groupe1);
    //etat du cours
    top.add(label14);
    top.add(etat);
    //matière
    top.add(label15);
    top.add(matiere);
    //salle
    top.add(label16);
    top.add(salle);
    //type
    top.add(label17);
    top.add(type);
    //boutton
    top.add(confirmer1);
    
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setContentPane(top);
    this.setVisible(true);            
  }       

  class BoutonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      
        if(!matiere.getSelectedItem().toString().equals(" ") || !type.getSelectedItem().toString().equals(" "))
        {
            a.modifcours(Integer.parseInt(semaine.getText()), date.getText(), creneau.getSelectedItem().toString(), professeur.getText(), matiere.getSelectedItem().toString(), type.getSelectedItem().toString());
        }
        
        if(!salle.getSelectedItem().toString().equals(" "))
        {
            a.affectersalle(Integer.parseInt(semaine.getText()), date.getText(), creneau.getSelectedItem().toString(), professeur.getText(), salle.getSelectedItem().toString());
        }
        
        if(!etat.getSelectedItem().toString().equals(" "))
        {
            a.etatseance(Integer.parseInt(semaine.getText()), date.getText(), creneau.getSelectedItem().toString(), professeur.getText(), etat.getSelectedItem().toString());
        }
        
        if(!professeur1.getText().isEmpty())
        {
            a.affecterenseignant(Integer.parseInt(semaine.getText()), date.getText(), creneau.getSelectedItem().toString(), groupe.getSelectedItem().toString(), professeur1.getText());
        }
        
        if(!groupe1.getSelectedItem().toString().equals(" "))
        {
            a.affectergroupe(Integer.parseInt(semaine.getText()), date.getText(), creneau.getSelectedItem().toString(), professeur.getText(), groupe1.getSelectedItem().toString());
        }
        
        if(!creneau1.getSelectedItem().toString().equals(" "))
        {
            a.deplacercours(Integer.parseInt(semaine.getText()), date.getText(), creneau.getSelectedItem().toString(), professeur.getText(), creneau1.getSelectedItem().toString());
        }
        
        
    }
  }
  
}
