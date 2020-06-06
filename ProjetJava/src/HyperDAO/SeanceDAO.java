/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HyperDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author valentinbchr
 */
public class SeanceDAO {
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public SeanceDAO()
    {}
    
    public int getIDprof(int semaine, String date, String creneau, String prof)
    {
        Connection con = null;
        Statement st, st2, st3;
        String nprof = "_";
        int id_seance = 0;
        
        String rqt1 = "SELECT * FROM Seance WHERE Semaine = '"+semaine+"' AND Date = '"+date+"' AND Creneau = '"+creneau+"' ";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected !");
            
            st = con.createStatement();
            ResultSet r = st.executeQuery(rqt1);
            while(r.next())
            {
                String rqt2 = "SELECT * FROM Seance_Enseignant WHERE ID_Seance = '"+r.getInt("ID")+"' ";
                st2 = con.createStatement();
                ResultSet r2 = st2.executeQuery(rqt2);
                while(r2.next())
                {
                    String rqt3 = "SELECT * FROM Utilisateur WHERE ID = '"+r2.getString("ID_Enseignant")+"' ";
                    st3 = con.createStatement();
                    ResultSet r3 = st3.executeQuery(rqt3);
                    while(r3.next())
                    {
                        nprof = r3.getString("Nom");
                        if (nprof.equals(prof))
                        {
                            id_seance = r.getInt("ID");
                        }
                    }
                }
   
            }

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return id_seance;
    }
    
    public int getIDgroupe(int semaine, String date, String creneau, String groupe)
    {
        Connection con = null;
        Statement st, st2, st3;
        String ngroupe = "_";
        int id_seance = 0;
        
        String rqt1 = "SELECT * FROM Seance WHERE Semaine = '"+semaine+"' AND Date = '"+date+"' AND Creneau = '"+creneau+"' ";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected !");
            
            st = con.createStatement();
            ResultSet r = st.executeQuery(rqt1);
            while(r.next())
            {
                String rqt2 = "SELECT * FROM Seance_Groupes WHERE ID_Seance = '"+r.getInt("ID")+"' ";
                st2 = con.createStatement();
                ResultSet r2 = st2.executeQuery(rqt2);
                while(r2.next())
                {
                    String rqt3 = "SELECT * FROM Groupe WHERE ID = '"+r2.getString("ID_Groupe")+"' ";
                    st3 = con.createStatement();
                    ResultSet r3 = st3.executeQuery(rqt3);
                    while(r3.next())
                    {
                        ngroupe = r3.getString("Nom");
                        if (ngroupe.equals(groupe))
                        {
                            id_seance = r.getInt("ID");
                        }
                    }
                }
   
            }

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return id_seance;
    }
    
    public int getsalleID(int id_seance)
    {
        Connection con = null;
        Statement st;
        int id_salle = 0;
        
        String rqt1 = "SELECT * FROM Seance_Salles WHERE ID_Seance = '"+id_seance+"' ";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected !");
            st = con.createStatement();
            
            ResultSet r = st.executeQuery(rqt1);
            while(r.next())
            {
                id_salle = r.getInt("ID_Salle");
            }

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return id_salle;
    }
    
}
