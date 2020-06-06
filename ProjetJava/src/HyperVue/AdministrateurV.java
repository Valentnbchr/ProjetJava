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
 
public class AdministrateurV extends JFrame {
  private JPanel container = new JPanel();
    //eleve
  private JTextField eleve = new JTextField();
  //classe
  private JTextField classe = new JTextField();
    //prof
  private JTextField professeur = new JTextField();

  
  //semaine
  private final JLabel label = new JLabel("eleve");
  //boutton
  private JButton b = new JButton ("Voir EDT");
  private JButton b1 = new JButton ("Ajouter séance");
  private JButton b2 = new JButton ("Modifier séance");
  private JButton b3 = new JButton ("Supprimer séance");
  //date
   private final JLabel label2 = new JLabel("classe");
   //heure début
   private JLabel label3 = new JLabel("professeur");

  public AdministrateurV(){
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
    professeur.setPreferredSize(new Dimension(290, 30));

    //boutton
    b.addActionListener(new BoutonListener());
    b1.addActionListener(new BoutonListener());
    b2.addActionListener(new BoutonListener());
    b3.addActionListener(new BoutonListener());
    
    
    
    //boutton
    top.add(b);
    //semaine
    top.add(label);
    top.add(eleve);
    //date
    top.add(label2);
    top.add(classe); 
    //heure debut
    top.add(label3);
    top.add(professeur);
        //boutton
    top.add(b1);
        //boutton
    top.add(b2);
        //boutton
    top.add(b3);

    
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setContentPane(top);
    this.setVisible(true);            
  }       

  class BoutonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      System.out.println("TEXT : jtf " + eleve.getText());
      System.out.println("TEXT : jtf2 " + classe.getText());
      System.out.println("TEXT : jtf " + professeur.getText());
    }
  }
  
}