package HyperVue;

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
 
public class Fenetre2 extends JFrame {
  private JPanel container = new JPanel();
  //semaine
  private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
  //date
  private JTextField jtf2 = new JTextField();
  //creneau
  private JComboBox creneau = new JComboBox();
  //etat
  private JComboBox etat = new JComboBox();
  private JLabel label1 = new JLabel("etat");
  //id cours
   private JFormattedTextField cours = new JFormattedTextField(NumberFormat.getIntegerInstance());

//id type
   private JFormattedTextField type = new JFormattedTextField(NumberFormat.getIntegerInstance());
//id ens
   private JFormattedTextField ens = new JFormattedTextField(NumberFormat.getIntegerInstance());
//id grp
   private JFormattedTextField grp = new JFormattedTextField(NumberFormat.getIntegerInstance());
//id salle
   private JFormattedTextField salle = new JFormattedTextField(NumberFormat.getIntegerInstance());
  
  //semaine
  private final JLabel label = new JLabel("semaine");
  //boutton
  private JButton b = new JButton ("OK");
  //date
   private final JLabel label2 = new JLabel("date");
   //heure début
   private JLabel label3 = new JLabel("Creneau");
   //cours
   private JLabel label5 = new JLabel("id cours");
      //type
   private JLabel label6 = new JLabel("id type");
      //enseignant
   private JLabel label7 = new JLabel("id ens");
      //groupe
   private JLabel label8 = new JLabel("id groupe");
      //salle
   private JLabel label9 = new JLabel("id salle");

  public Fenetre2(){
    this.setTitle("Animation");
    this.setSize(350, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();        
    Font police = new Font("Arial", Font.BOLD, 14);
    jtf.setFont(police);
    jtf.setPreferredSize(new Dimension(290, 30));
    jtf.setForeground(Color.BLUE);
    jtf2.setPreferredSize(new Dimension(290, 30));
    
    //creneau
    creneau.setPreferredSize(new Dimension(290, 30));
    creneau.addItem("8h30/10h");
    creneau.addItem("10h/11h30");
    creneau.addItem("11h30/13h");
    creneau.addItem("13h/14h30");
    creneau.addItem("14h30/16h");
    creneau.addItem("16h/17h30");
    creneau.addItem("17h30/19h");
    
    //etat
    etat.setPreferredSize(new Dimension(270, 20));
    etat.addItem("1");
    etat.addItem("2");
    etat.addItem("3"); 
    
    //cours
    cours.setPreferredSize(new Dimension(290, 30));
    
    //type
    type.setPreferredSize(new Dimension(290, 30));
    
    //enseignant
    ens.setPreferredSize(new Dimension(290, 30));
    
    //groupe
    grp.setPreferredSize(new Dimension(250, 30));
    
    //salle
    salle.setPreferredSize(new Dimension(190, 30));
    
    //boutton
    b.addActionListener(new BoutonListener());
    
    //semaine
    top.add(label);
    top.add(jtf);
    
    //date
    top.add(label2);
    top.add(jtf2); 
    
    //heure debut
    top.add(label3);
    top.add(creneau);
    
    ///etat
    top.add(label1);
    top.add(etat);
    //id cours
    top.add(label5);
    top.add(cours);
    
    //id type
    top.add(label6);
    top.add(type);
    
    //id enseignant
    top.add(label7);
    top.add(ens);
    
    //id groupe
    top.add(label8);
    top.add(grp);
    
    //id salle
    top.add(label9);
    top.add(salle);
    
    //boutton
    top.add(b);
    
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setContentPane(top);
    this.setVisible(true);            
  }       

  class BoutonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      System.out.println("TEXT : jtf " + jtf.getText());
      System.out.println("TEXT : jtf2 " + jtf2.getText());
    }
  }
}