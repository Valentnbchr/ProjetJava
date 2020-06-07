package HyperVue;


import HyperDAO.CoursDAO;
import HyperDAO.EnseignantDAO;
import HyperDAO.EtudiantDAO;
import HyperDAO.SalleDAO;
import HyperDAO.SeanceDAO;
import HyperDAO.TypeDAO;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class EDTV extends JFrame {
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    
    
    private JComboBox combo = new JComboBox();
    
    /* Construction de l'interface graphique */
    public EDTV(String email, String mdp)
    {
        
        this.setTitle("Emploi du Temps");
        this.setSize(600,400);
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        // Construction et injection de la barre de menu
        
        
        this.setJMenuBar(this.createMenuBar());
        //JTable maTable = new JTable();
        this.JTable(email);
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
    
    

    
     private void JTable(String email)
     {
        Connection con = null;
        Statement st, st2, st3, st4;
        String c1 = "", c2 = "",c3 = "", c4 = "",c5 = "", c6 = "",c7 = "", c8 = "",c9 = "", c10 = "",c11 = "", c12 = "",c13 = "", c14 = "",c15 = "", c16 = "",c17 = "", c18 = "",c19 = "", c20 = "",c21 = "", c22 = "",c23 = "", c24 = "",c25 = "", c26 = "",c27 = "", c28 = "",c29 = "", c30 = "",c31 = "", c32 = "",c33 = "", c34 = "",c35 = "";
        int id_eleve = 0;
        int id_groupe = 0;
        int id_seance = 0;
        int id_cours = 0;
        String nomcours = "";
        int id_type = 0;
        String typecours = "";
        int id_prof = 0;
        String nomprof = "";
        int id_salle = 0;
        String nomsalle = "";
        int etat = 0;
        String nometat = "";
        
        EtudiantDAO etu = new EtudiantDAO();
        id_eleve = etu.getID(email);
        id_groupe = etu.getIDgroupe(id_eleve);
        
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Seance_Groupes WHERE ID_Groupe = '"+id_groupe+"'");
            while(r.next())
            {
                id_seance = r.getInt("ID_Seance");  
                st2 = con.createStatement();
                ResultSet r2 = st2.executeQuery("SELECT * FROM Seance WHERE ID = '"+id_seance+"'");
                while(r2.next())
                {
                    
                    id_cours = r2.getInt("ID_Cours");
                    CoursDAO c = new CoursDAO();
                    nomcours = c.getNom(id_cours);
                    
                    id_type = r2.getInt("ID_Type");
                    TypeDAO t = new TypeDAO();
                    typecours = t.getNom(id_type);
                    
                    SeanceDAO se = new SeanceDAO();
                    id_prof = se.getprofID(id_seance);
                    EnseignantDAO ens = new EnseignantDAO();
                    nomprof = ens.getNom(id_prof);
                    
                    id_salle = se.getsalleID(id_seance);
                    SalleDAO sa = new SalleDAO();
                    nomsalle = sa.getNom(id_salle);
                    
                    etat = r2.getInt("Etat");
                    if (etat == 1)
                    {
                        nometat = "En cours de Validation";
                    }
                    if (etat == 2)
                    {
                        nometat = "Validé";
                    }
                    if (etat == 3)
                    {
                        nometat = "Annulé";
                    }
                    

                    String date = r2.getString("Date");
                    String creneau = r2.getString("Creneau");
                    System.out.println(date);
                    System.out.println(creneau);
                    String cours = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    System.out.println(cours);
                    
                    
                    if("Lundi".equals(date) && "8h30/10h".equals(creneau))
                    {
                        c1 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                        System.out.println(c1);
                    }
                    if("Mardi".equals(date) &&  "8h30/10h".equals(creneau))
                    {
                        c2 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                        System.out.println(c2);
                    }
                    if("Mercredi".equals(date) &&  "8h30/10h".equals(creneau))
                    {
                        c3 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Jeudi".equals(date) &&  "8h30/10h".equals(creneau))
                    {
                        c4 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Vendredi".equals(date) &&  "8h30/10h".equals(creneau))
                    {
                        c5 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Lundi".equals(date) &&  "10h00/11h30".equals(creneau))
                    {
                        c6 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mardi".equals(date) &&  "10h00/11h30".equals(creneau))
                    {
                        c7 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mercredi".equals(date) &&  "10h00/11h30".equals(creneau))
                    {
                        c8 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Jeudi".equals(date) &&  "10h00/11h30".equals(creneau))
                    {
                        c9 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Vendredi".equals(date) &&  "10h00/11h30".equals(creneau))
                    {
                        c10 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Lundi".equals(date) &&  "11h30/13h00".equals(creneau))
                    {
                        c11 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mardi".equals(date) &&  "11h30/13h00".equals(creneau))
                    {
                        c12 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mercredi".equals(date) &&  "11h30/13h00".equals(creneau))
                    {
                        c13 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Jeudi".equals(date) &&  "11h30/13h00".equals(creneau))
                    {
                        c14 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Vendredi".equals(date) &&  "11h30/13h00".equals(creneau))
                    {
                        c15 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Lundi".equals(date) &&  "13h/14h30".equals(creneau))
                    {
                        c16 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mardi".equals(date) &&  "13h/14h30".equals(creneau))
                    {
                        c17 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mercredi".equals(date) &&  "13h/14h30".equals(creneau))
                    {
                        c18 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Jeudi".equals(date) &&  "13h/14h30".equals(creneau))
                    {
                        c19 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Vendredi".equals(date) &&  "13h/14h30".equals(creneau))
                    {
                        c20 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Lundi".equals(date) &&  "14h30h/16h".equals(creneau))
                    {
                        c21 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mardi".equals(date) &&  "14h30/16h".equals(creneau))
                    {
                        c22 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                        System.out.println(c22);
                    }
                    if( "Mercredi".equals(date) &&  "14h30h/16h".equals(creneau))
                    {
                        c23 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Jeudi".equals(date) &&  "14h30h/16h".equals(creneau))
                    {
                        c24 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Vendredi".equals(date) &&  "14h30h/16h".equals(creneau))
                    {
                        c25 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Lundi".equals(date) &&  "16h/17h30".equals(creneau))
                    {
                        c26 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mardi".equals(date) &&  "16h/17h30".equals(creneau))
                    {
                        c27 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mercredi".equals(date) &&  "16h/17h30".equals(creneau))
                    {
                        c28 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                        System.out.println(c28);
                    }
                    if( "Jeudi".equals(date) &&  "16h/17h30".equals(creneau))
                    {
                        c29 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Vendredi".equals(date) &&  "16h/17h30".equals(creneau))
                    {
                        c30 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Lundi".equals(date) &&  "17h30/19h".equals(creneau))
                    {
                        c31 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mardi".equals(date) &&  "17h30/19h".equals(creneau))
                    {
                        c32 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Mercredi".equals(date) &&  "17h30/19h".equals(creneau))
                    {
                        c33 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Jeudi".equals(date) &&  "17h30/19h".equals(creneau))
                    {
                        c34 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    if( "Vendredi".equals(date) &&  "17h30/19h".equals(creneau))
                    {
                        c35 = nomcours+","+nomprof+","+typecours+","+nomsalle+","+nometat;
                    }
                    
                    
                    
                }
                
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        
        
        
        

        Object[][] donnees = {
                {"8h30/10h00", "|"+c1, "|"+c2, "|"+c3, "|"+c4, "|"+c5},
                {"10h00/11h30", "|"+c6, "|"+c7, "|"+c8, "|"+c9, "|"+c10},
                {"11h30/13h00", "|"+c11, "|"+c12, "|"+c13, "|"+c14, "|"+c15},
                {"13h/14h30", "|"+c16, "|"+c17, "|"+c18, "|"+c19, "|"+c20},
                {"14h30h/16h", "|"+c21, "|"+c22, "|"+c23, "|"+c24, "|"+c25},
                {"16h/17h30", "|"+c26, "|"+c27, "|"+c28, "|"+c29, "|"+c30},
                {"17h30/19h", "|"+c31, "|"+c32, "|"+c33, "|"+c34, "|"+c35},
        };
 
        String[] entetes = {"Heure", "Lundi","Mardi","Mercredi","Jeudi","Vendredi"};
        
        
        JTable tableau = new JTable(donnees, entetes);
 
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);

      // return JTable();
    }
     

    public void mnuNewListener( ActionEvent event ) {
        JOptionPane.showMessageDialog( this, "Button clicked !" );
    }
   
}