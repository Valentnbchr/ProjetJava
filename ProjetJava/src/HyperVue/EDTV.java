package HyperVue;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class EDTV extends JFrame {
    
    
    
    private JComboBox combo = new JComboBox();
    
    /* Construction de l'interface graphique */
    public EDTV() throws UnsupportedLookAndFeelException 
    {
        
        this.setTitle("Emploi du Temps");
        this.setSize(600,400);
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        // Construction et injection de la barre de menu
        
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );
        
        this.setJMenuBar( this.createMenuBar() );
        JTable maTable = new JTable();
        this.JTable();
        this.setVisible(true);
        
    }
    
    /* Methode de construction de la barre de menu */
    private JMenuBar createMenuBar() 
    {
        
        JPanel top = new JPanel();   
      
        JMenuBar menuBar = new JMenuBar();
      
        JMenu menuCours = new JMenu( "Cours" );
        

        JMenuItem menuNewCours = new JMenuItem( "Emploi du temps" );
       
        menuNewCours.addActionListener( this::mnuNewListener );
        menuCours.add(menuNewCours);

        menuCours.addSeparator();

        JMenuItem mnuOpenFile = new JMenuItem( "récapitulatif des cours" );
       
        menuCours.add(mnuOpenFile);

        menuBar.add(menuCours);
        
      
        JMenu menuEtudiant = new JMenu( "Etudiant" );
        
        
        JMenuItem menuEDT = new JMenuItem( "Emploi du temps" );
       menuEtudiant.add(menuEDT);
       
        menuEtudiant.addSeparator();
        
        JMenuItem menuRcd = new JMenuItem( "Récapitulatif des cours" );
        menuEtudiant.add(menuRcd);
        
        menuEtudiant.addSeparator();
        
        JMenuItem menuCa = new JMenuItem( "Cours annulés" );
        menuEtudiant.add(menuCa);
       
        menuEtudiant.addSeparator();
        
        JMenuItem menuLdi = new JMenuItem( "Liste des intervenants" );
        menuEtudiant.add(menuLdi);
        
        menuBar.add(menuEtudiant);
       
     
        JMenu menuPromotions = new JMenu ("Promotions");
     
        
        JMenuItem menu2020 = new JMenuItem( "2020" );
       menuPromotions.add(menu2020);
       
        menuPromotions.addSeparator(); 
        
          JMenuItem menu2021 = new JMenuItem( "2021" );
       menuPromotions.add(menu2021);
       
        menuPromotions.addSeparator();
        
         JMenuItem menu2022 = new JMenuItem( "2022" );
       menuPromotions.add(menu2022);
       
        menuPromotions.addSeparator();
        
         JMenuItem menu2023 = new JMenuItem( "2023" );
       menuPromotions.add(menu2023);
       
           menuBar.add(menuPromotions);
        
        //defintion menu salles
        
        JMenu menuSalles = new JMenu ("Salles");
     
        
                JMenuItem s1 = new JMenuItem( "E1-SC217" );
       menuSalles.add(s1);
       
        menuSalles.addSeparator();
        
        JMenuItem s2 = new JMenuItem( "E1-EM409" );
       menuSalles.add(s2);
       
        menuSalles.addSeparator();
        
        JMenuItem s3 = new JMenuItem( "E2-P315" );
       menuSalles.add(s3);
       
        menuSalles.addSeparator();
        
                JMenuItem s4 = new JMenuItem( "E2-P345" );
       menuSalles.add(s4);
       
        menuSalles.addSeparator();
        
         JMenuItem s5 = new JMenuItem( "E4-G004" );
       menuSalles.add(s5);
       
        menuSalles.addSeparator();
        
         JMenuItem s6 = new JMenuItem( "E4-G019" );
       menuSalles.add(s6);
       
        menuSalles.addSeparator();
        
       menuBar.add (menuSalles);


        JMenu mnuHelp = new JMenu( "Help" );
      
        menuBar.add( mnuHelp );

        return menuBar;
        
    }
    
    

    
     private void JTable()
     {
        
 
        Object[][] donnees = {
                {"8h30/10h00", "", "", "", "", "", ""},
                {"10h00/11h30", "", "", "", "", "", ""},
                {"11h30/13h00", "", "", "", "", "", ""},
                {"13h/14h30", "", "", "", "", "", ""},
                {"14h30h/16h", "", "", "", "", "", ""},
                {"16h/17h30", "", "", "", "", "", ""},
                {"17h30/19h", "", "", "", "", "", ""},
        };
 
        String[] entetes = {"Heure", "Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
 System.out.println("coucou");
        JTable tableau = new JTable(donnees, entetes);
 
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);

      // return JTable();
    }
     

    public void mnuNewListener( ActionEvent event ) {
        JOptionPane.showMessageDialog( this, "Button clicked !" );
    }
   
}