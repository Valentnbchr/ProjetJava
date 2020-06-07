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
  private JTextField Eleve = new JTextField();
  //classe
  private JTextField Classe = new JTextField();


  
  //semaine
  private final JLabel label = new JLabel("Nom Elève :");
  //boutton
  private JButton b = new JButton ("Voir EDT");
  private JButton b1 = new JButton ("Ajouter séance");
  private JButton b2 = new JButton ("Modifier séance");
  private JButton b3 = new JButton ("Supprimer séance");
  //date
   private final JLabel label2 = new JLabel("Classe :");
   //heure début

  public AdministrateurV(){
    this.setTitle("Animation");
    this.setSize(350, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();        
    Font police = new Font("Arial", Font.BOLD, 14);
    Eleve.setFont(police);
    Eleve.setPreferredSize(new Dimension(250, 30));
    Eleve.setForeground(Color.BLUE);
    Classe.setPreferredSize(new Dimension(290, 30));

    //boutton
    b.addActionListener(new BoutonListener());
    b1.addActionListener(new BoutonListener1());
    b2.addActionListener(new BoutonListener2());
    b3.addActionListener(new BoutonListener3());
    
    
    
    //boutton
    top.add(b);
    //semaine
    top.add(label);
    top.add(Eleve);
    //date
    top.add(label2);
    top.add(Classe); 
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