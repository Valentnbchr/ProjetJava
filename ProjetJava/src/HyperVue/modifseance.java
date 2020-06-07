
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
 
public class modifseance extends JFrame {
  private JPanel container = new JPanel();
  
  AdministrateurDAO a = new AdministrateurDAO();
  
  ///lister cours prévu
  
   //semaine
  private JTextField semaine = new JTextField(15);
  //date
  private JTextField date = new JTextField(15);
  //prof
  private JTextField professeur = new JTextField(15);
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
  private JTextField semaine1 = new JTextField(15);
  //date
  private JTextField date1 = new JTextField(15);
  //prof
  private JTextField professeur1 = new JTextField(15);

//new seance
  private final JLabel newseance = new JLabel("NOUVELLE SEANCE");
//cours prévu
  private final JLabel coursprevu = new JLabel("COURS PREVU");
  
  //date
  private final JLabel label10 = new JLabel("Semaine :");
  //creneau
  private final JLabel label11 = new JLabel("Creneau :");
  //boutton
  private JButton confirmer1 = new JButton ("Confirmer");
  //semaine
   private final JLabel label12 = new JLabel("Jour de la semaine :");
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
    
    //creneau
    creneau.addItem(" ");
    creneau.addItem("8h30/10h");
    creneau.addItem("10h/11h30");
    creneau.addItem("11h30/13h"); 
    creneau.addItem("13h/14h30");
    creneau.addItem("14h30/16h"); 
    creneau.addItem("16h/17h30"); 
    creneau.addItem("17h30/19h"); 
    
    groupe.setPreferredSize(new Dimension(290, 30));
    groupe.addItem(" ");
    groupe.addItem("TD1");
    groupe.addItem("TD2");
    groupe.addItem("TD3"); 
    groupe.addItem("TD4");
    groupe.addItem("TD4"); 
    groupe.addItem("TD4"); 
 
    
    gc.weightx=0.5;
    gc.weighty=0.5;
    
    gc.anchor=GridBagConstraints.LINE_END;
    gc.gridx = 0;
    gc.gridy= 0;
    top.add(coursprevu, gc);
    //semaine
    gc.gridx = 0;
    gc.gridy= 1;
    top.add(label, gc);
    //date
    gc.gridx = 0;
    gc.gridy= 2;
    top.add(label2, gc); 
    ///creneau
    gc.gridx = 0;
    gc.gridy= 3;
    top.add(label1, gc);
    //professeur
    gc.gridx = 0;
    gc.gridy= 4;
    top.add(label3, gc);
    //groupe
    gc.gridx = 0;
    gc.gridy= 5;
    top.add(label4, gc);
    
    gc.anchor=GridBagConstraints.LINE_START;
    //semaine
    gc.gridx = 1;
    gc.gridy= 1;
    top.add(semaine, gc);
    //date
    gc.gridx = 1;
    gc.gridy= 2;
    top.add(date, gc); 
    ///creneau
    gc.gridx = 1;
    gc.gridy= 3;
    top.add(creneau, gc);
    //professeur
    gc.gridx = 1;
    gc.gridy= 4;
    top.add(professeur, gc);
    //groupe
    gc.gridx = 1;
    gc.gridy= 5;
    top.add(groupe, gc);
 
    
    ///lister nouvelle séance
    
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
    
    gc.anchor=GridBagConstraints.LINE_END;
    gc.gridx = 2;
    gc.gridy= 0;
    top.add(newseance, gc);
    ///creneau
    gc.gridx = 2;
    gc.gridy= 1;
    top.add(label11, gc);
    //professeur
    gc.gridx = 2;
    gc.gridy= 2;
    top.add(label13, gc);
    //groupe
    gc.gridx = 2;
    gc.gridy= 3;
    top.add(label18, gc);
    //etat du cours
    gc.gridx = 2;
    gc.gridy= 4;
    top.add(label14, gc);
    //matière
    gc.gridx = 2;
    gc.gridy= 5;
    top.add(label15, gc);
    //salle
    gc.gridx = 2;
    gc.gridy= 6;
    top.add(label16, gc);
    //type
    gc.gridx = 2;
    gc.gridy= 7;
    top.add(label17, gc);
    
        gc.anchor=GridBagConstraints.LINE_START;

    ///creneau
    gc.gridx = 3;
    gc.gridy= 1;
    top.add(creneau1, gc);
    //professeur
    gc.gridx = 3;
    gc.gridy= 2;
    top.add(professeur1, gc);
    //groupe
    gc.gridx = 3;
    gc.gridy= 3;
    top.add(groupe1, gc);
    //etat du cours
    gc.gridx = 3;
    gc.gridy= 4;
    top.add(etat, gc);
    //matière
    gc.gridx = 3;
    gc.gridy= 5;
    top.add(matiere, gc);
    //salle
    gc.gridx = 3;
    gc.gridy= 6;
    top.add(salle, gc);
    //type
    gc.gridx = 3;
    gc.gridy= 7;
    top.add(type, gc);
    
    //boutton
    gc.weighty=1;
    
    gc.anchor=GridBagConstraints.FIRST_LINE_START;
    gc.gridx = 3;
    gc.gridy=10;
    top.add(confirmer1,gc);
    
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
