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
  private JTextField eleve = new JTextField();
  //classe
  private JTextField classe = new JTextField();
  
  //prof
  private JTextField professeur = new JTextField();
  

  
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
    this.setTitle("Animation");
    this.setSize(350, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();        
    Font police = new Font("Arial", Font.BOLD, 14);
    eleve.setFont(police);
    eleve.setPreferredSize(new Dimension(250, 30));
    eleve.setForeground(Color.BLUE);
    classe.setPreferredSize(new Dimension(290, 30));
        creneau.setPreferredSize(new Dimension(270, 20));
    //etat
    creneau.addItem("8h30/10h00");
    creneau.addItem("10h00/11h30");
    creneau.addItem("11h30/13h00"); 
    creneau.addItem("14h30/16h00");
    creneau.addItem("16h00/17h30"); 
    creneau.addItem("17h30/19h00"); 
    
    professeur.setPreferredSize(new Dimension(290, 30));

    //boutton
    annuler.addActionListener(new BoutonListener());
    
    //semaine
    top.add(label);
    top.add(eleve);
    //date
    top.add(label2);
    top.add(classe); 
    ///creneau
    top.add(label1);
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
      System.out.println("TEXT : jtf " + eleve.getText());
      System.out.println("TEXT : jtf2 " + classe.getText());
    }
  }
  
}