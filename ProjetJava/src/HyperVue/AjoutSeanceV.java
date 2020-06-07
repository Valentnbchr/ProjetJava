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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import javax.swing.*;
//Les imports habituels
 
public class AjoutSeanceV extends JFrame {
   AdministrateurDAO a = new AdministrateurDAO();
    
    
    private JPanel container = new JPanel();

    //semaine
    private JTextField jtf = new JTextField(15);

    //date
    private JTextField jtf2 = new JTextField(15);

    //creneau
    private JComboBox creneau = new JComboBox();

    //etat
    private JComboBox etat = new JComboBox();
    private JLabel label1 = new JLabel("etat");
  
    //id cours
    private JComboBox cours = new JComboBox();

     //id type
    private JComboBox type = new JComboBox();

     //id ens
    private JTextField ens = new JTextField(15);

     //id grp
    private JComboBox grp = new JComboBox();

     //id salle
    private JComboBox salle = new JComboBox();
  
    //semaine
    private final JLabel label = new JLabel("semaine");
    
    //boutton
    private JButton b = new JButton ("OK");
    
    //date
    private final JLabel label2 = new JLabel("Jour de la semaine");
    
    //heure début
    private JLabel label3 = new JLabel("Creneau");
    
    //cours
    private JLabel label5 = new JLabel("choix cours");
    
    //type
    private JLabel label6 = new JLabel("choix type");
    
    //enseignant
    private JLabel label7 = new JLabel("choix ens");
    
    //groupe
    private JLabel label8 = new JLabel("choix groupe");
    
    //salle
    private JLabel label9 = new JLabel("choix salle");

  public AjoutSeanceV()
  {
    this.setTitle("Ajout Seance");
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
    
    //creneau
    creneau.setPreferredSize(new Dimension(290, 30));
    creneau.addItem(" ");
    creneau.addItem("8h30/10h");
    creneau.addItem("10h/11h30");
    creneau.addItem("11h30/13h");
    creneau.addItem("13h/14h30");
    creneau.addItem("14h30/16h");
    creneau.addItem("16h/17h30");
    creneau.addItem("17h30/19h");
    
    //etat
    etat.setPreferredSize(new Dimension(270, 20));
    etat.addItem(" ");
    etat.addItem("En cours de validation");
    etat.addItem("Validé");
    etat.addItem("Annulé"); 
    
    cours.setPreferredSize(new Dimension(290, 30));
    cours.addItem(" ");
    cours.addItem("Mathématiques");
    cours.addItem("Thermodynamique");
    cours.addItem("Anglais");

    
    type.setPreferredSize(new Dimension(290, 30));
    type.addItem(" ");
    type.addItem("TP");
    type.addItem("Amphi");
    type.addItem("TD");

    
    grp.setPreferredSize(new Dimension(290, 30));
    grp.addItem(" ");
    grp.addItem("TD1");
    grp.addItem("TD2");
    grp.addItem("TD3");
    grp.addItem("TD4");
    grp.addItem("TD5");
    grp.addItem("TD6");

    salle.setPreferredSize(new Dimension(290, 30));
    salle.addItem(" ");
    salle.addItem("P315");
    salle.addItem("P445");
    salle.addItem("SC217");
    salle.addItem("EM409");
    salle.addItem("G004");
    salle.addItem("G019");
    
    //boutton
    b.addActionListener(new BoutonListener());
    
    gc.weightx=0.5;
    gc.weighty=0.5;
    
    gc.anchor=GridBagConstraints.LINE_END;
    //semaine
    gc.gridx = 1;
    gc.gridy= 0;
    top.add(label,gc);
    
    //date
    gc.gridx = 1;
    gc.gridy= 1;
    top.add(label2,gc);
    
    //heure debut
    gc.gridx = 1;
    gc.gridy= 2;
    top.add(label3,gc);
    
    ///etat
    gc.gridx = 1;
    gc.gridy= 3;
    top.add(label1,gc);
    //id cours
    gc.gridx = 1;
    gc.gridy= 4;
    top.add(label5,gc);
    
    //id type
    gc.gridx = 1;
    gc.gridy= 5;
    top.add(label6,gc);
    
    //id enseignant
    gc.gridx = 1;
    gc.gridy= 6;
    top.add(label7,gc);
    
    //id groupe
    gc.gridx = 1;
    gc.gridy= 7;
    top.add(label8,gc);
    
    //id salle
    gc.gridx = 1;
    gc.gridy= 8;
    top.add(label9,gc);
    
    gc.anchor=GridBagConstraints.LINE_START;
    //semaine
    gc.gridx = 2;
    gc.gridy= 0;
    top.add(jtf,gc);
    
    //date
    gc.gridx = 2;
    gc.gridy= 1;
    top.add(jtf2,gc);
    
    //heure debut
    gc.gridx = 2;
    gc.gridy= 2;
    top.add(creneau,gc);
    
    ///etat
    gc.gridx = 2;
    gc.gridy= 3;
    top.add(etat,gc);
    //id cours
    gc.gridx = 2;
    gc.gridy= 4;
    top.add(cours,gc);
    
    //id type
    gc.gridx = 2;
    gc.gridy= 5;
    top.add(type,gc);
    
    //id enseignant
    gc.gridx = 2;
    gc.gridy= 6;
    top.add(ens,gc);
    
    //id groupe
    gc.gridx = 2;
    gc.gridy= 7;
    top.add(grp,gc);
    
    //id salle
    gc.gridx = 2;
    gc.gridy= 8;
    top.add(salle,gc);
    
    //boutton
    gc.weighty=1;
    
    gc.anchor=GridBagConstraints.FIRST_LINE_START;
    gc.gridx = 2;
    gc.gridy=9;
    top.add(b,gc);
    
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
      a.ajoutseance(Integer.parseInt(jtf.getText()), jtf2.getText(),creneau.getSelectedItem().toString(), etat.getSelectedItem().toString() , cours.getSelectedItem().toString(), type.getSelectedItem().toString(), ens.getText(), grp.getSelectedItem().toString(), salle.getSelectedItem().toString());
    }
  }
}