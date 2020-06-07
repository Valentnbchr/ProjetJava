/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HyperDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author valentinbchr
 */
public class AdministrateurDAO {
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public AdministrateurDAO()
    {
    }
    
    public void ajoutseance(int semaine, String date, String creneau, String etat, String cours, String type, String prof, String groupe, String salle)
    {
        Connection con = null;
        Statement st, st2, st3, st4;
        int id_etat = 0;
        int id_cours = 0;
        int id_type = 0;
        int id_prof = 0;
        int id_groupe = 0;
        int id_salle = 0;
        
        if("En cours de validation".equals(etat))
        {
            id_etat = 1;
        }
        if("Validé".equals(etat))
        {
            id_etat = 2;
        }
        if("Annulé".equals(etat))
        {
            id_etat = 3;
        }
        
        CoursDAO c = new CoursDAO();
        id_cours = c.getID(cours);
        
        TypeDAO t = new TypeDAO();
        id_type = t.getID(type);
        
        EnseignantDAO ens = new EnseignantDAO();
        id_prof = ens.getID(prof);
        
        GroupeDAO g = new GroupeDAO();
        id_groupe = g.getID(groupe);
        
        SalleDAO s = new SalleDAO();
        id_salle = s.getID(salle);
        
        
        String rqt = "INSERT INTO Seance (Semaine, Date, Creneau, Etat, ID_Cours, ID_Type)VALUES ('"+semaine+"','"+date+"','"+creneau+"', '"+id_etat+"', '"+id_cours+"','"+id_type+"') ";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected !");
            
            int id_seance = 0;
            int x = g.tailleGroupe(id_groupe);
            int y = s.getCapacité(id_salle);
            
           
            if (x>y)
            {
                System.out.println("Cette salle est trop petite pour acceuillir ce groupe !");
            }
            else
            {
                st = con.createStatement();
                st.executeUpdate(rqt);
                
                st2 = con.createStatement();
                ResultSet r = st2.executeQuery("SELECT * FROM Seance WHERE Semaine = '"+semaine+"' AND Date = '"+date+"' AND Creneau = '"+creneau+"' AND Etat = '"+id_etat+"' AND ID_Cours = '"+id_cours+"' AND ID_Type = '"+id_type+"' ");
                while(r.next())
                {
                    id_seance = r.getInt("ID");  
                }
                
                String rqt2 = "INSERT INTO Seance_Enseignant (ID_Seance, ID_Enseignant)VALUES ('"+id_seance+"','"+id_prof+"') ";
                String rqt3 = "INSERT INTO Seance_Groupes (ID_Seance, ID_Groupe)VALUES ('"+id_seance+"','"+id_groupe+"') ";
                String rqt4 = "INSERT INTO Seance_Salles (ID_Seance, ID_Salle)VALUES ('"+id_seance+"','"+id_salle+"') ";

                st2 = con.createStatement();
                st3 = con.createStatement();
                st4 = con.createStatement();
                st2.executeUpdate(rqt2);
                st3.executeUpdate(rqt3);
                st4.executeUpdate(rqt4);

                System.out.println("Les requètes ont été executées !");
            }
            
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        
    }
    
    public void modifcours(int semaine, String date, String creneau, String prof, String cours, String type)
    {
        Connection con = null;
        Statement st;
        int id_seance = 0;
        int id_cours = 0;
        int id_type = 0;
        
        SeanceDAO seance = new SeanceDAO();
        id_seance = seance.getIDprof(semaine, date, creneau, prof);
        
        CoursDAO c = new CoursDAO();
        id_cours = c.getID(cours);
        
        TypeDAO t = new TypeDAO();
        id_type = t.getID(type);
        
        String rqt = "UPDATE Seance Set ID_Cours = '"+id_cours+"', ID_Type = '"+id_type+"' WHERE ID = "+id_seance+" ";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected !");
            
            st = con.createStatement();
            st.executeUpdate(rqt);
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
    }
    
    public void affectersalle(int semaine, String date, String creneau, String prof, String salle)
    {
        Connection con = null;
        Statement st;
        int id_salle = 0;
        int id_seance = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            SeanceDAO seance = new SeanceDAO();
            id_seance = seance.getIDprof(semaine, date, creneau, prof);
            
            SalleDAO s = new SalleDAO();
            id_salle = s.getID(salle);
            
            String rqt = "UPDATE Seance_Salles SET ID_Salle = '"+id_salle+"' WHERE ID_Seance = '"+id_seance+"' ";
            st = con.createStatement();
            st.executeUpdate(rqt);

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
    
    public void etatseance(int semaine, String date, String creneau, String prof, String E)
    {
        Connection con = null;
        Statement st;
        int id_seance = 0;
        int etat = 0;
        
        if(E == "En cours de validation")
        {
            etat = 1;
        }
        if(E == "Validé")
        {
            etat = 2;
        }
        if(E == "Annulé")
        {
            etat = 3;
        }
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            SeanceDAO seance = new SeanceDAO();
            id_seance = seance.getIDprof(semaine, date, creneau, prof);
            
            String rqt = "UPDATE Seance SET Etat = '"+etat+"' WHERE ID = '"+id_seance+"' ";
            st = con.createStatement();
            st.executeUpdate(rqt);

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
    }
    
    public void affecterenseignant(int semaine, String date, String creneau, String groupe, String prof)
    {
        Connection con = null;
        Statement st;
        int id_seance = 0;
        int id_enseignant = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            SeanceDAO s = new SeanceDAO();
            id_seance = s.getIDgroupe(semaine, date, creneau, groupe);
            
            EnseignantDAO e = new EnseignantDAO();
            id_enseignant = e.getID(prof);
            
            String rqt = "UPDATE Seance_Enseignant SET ID_Enseignant = '"+id_enseignant+"' WHERE ID_Seance = '"+id_seance+"' ";
            st = con.createStatement();
            st.executeUpdate(rqt);

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
    
    public void affectergroupe(int semaine, String date, String creneau, String prof, String groupe)
    {
        Connection con = null;
        Statement st;
        int id_seance = 0;
        int id_groupe = 0;
        int id_salle = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            SeanceDAO s = new SeanceDAO();
            id_seance = s.getIDprof(semaine, date, creneau, prof);
            id_salle = s.getsalleID(id_seance);
            
            GroupeDAO g = new GroupeDAO();
            id_groupe = g.getID(groupe);
            int x = g.tailleGroupe(id_groupe);
            
            SalleDAO salle = new SalleDAO();
            int y = salle.getCapacité(id_salle);
            
            if (x>y)
            {
                System.out.println("Cette salle est trop petite pour acceuillir ce groupe !");
            }
            else
            {
                String rqt = "UPDATE Seance_Groupes SET ID_Groupe = '"+id_groupe+"' WHERE ID_Seance = '"+id_seance+"' ";
                st = con.createStatement();
                st.executeUpdate(rqt);
            }

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
    
    public void deplacercours(int semaine, String date, String creneau, String prof, String nvcreneau)
    {
        Connection con = null;
        Statement st;
        int id_seance;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            SeanceDAO s = new SeanceDAO();
            id_seance = s.getIDprof(semaine, date, creneau, prof);
            
            String rqt = "UPDATE Seance SET Creneau = '"+nvcreneau+"' WHERE ID = '"+id_seance+"' ";
            st = con.createStatement();
            st.executeUpdate(rqt);


        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
    
    /*public void enleverEns(int semaine, String date, String creneau, String prof)
    {
        Connection con = null;
        Statement st;
        int id_seance;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            SeanceDAO s = new SeanceDAO();
            id_seance = s.getIDprof(semaine, date, creneau, prof);
            
            String rqt = "UPDATE Seance_Enseignant SET ID_Enseignant = 0 WHERE ID_Seance = '"+id_seance+"' ";
            st = con.createStatement();
            st.executeUpdate(rqt);


        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
    
    public void enleverGroupe(int semaine, String date, String creneau, String groupe)
    {
        Connection con = null;
        Statement st;
        int id_seance;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
            SeanceDAO s = new SeanceDAO();
            id_seance = s.getIDgroupe(semaine, date, creneau, groupe);
            
            String rqt = "UPDATE Seance_Groupes SET ID_Groupe = 0 WHERE ID_Seance = '"+id_seance+"' ";
            st = con.createStatement();
            st.executeUpdate(rqt);


        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }*/
    

    
}
