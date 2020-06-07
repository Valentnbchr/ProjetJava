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
public class EtudiantDAO {
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public EtudiantDAO()
    {}
    
    public String getMDP(String nom)
    {
        Connection con = null;
        Statement st;
        String mdp = "";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Utilisateur WHERE Nom = '"+nom+"'");
            while(r.next())
            {
                mdp = r.getString("Mdp");  
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return mdp;
    }
    
    public String getemail(String nom)
    {
        Connection con = null;
        Statement st;
        String email = "";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Utilisateur WHERE Nom = '"+nom+"'");
            while(r.next())
            {
                email = r.getString("Email");  
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return email;
    }
    
    public int getID(String email)
    {
        Connection con = null;
        Statement st;
        int id = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Utilisateur WHERE Email = '"+email+"'");
            while(r.next())
            {
                id = r.getInt("ID");  
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return id;
    }
    
    public int getIDgroupe(int id_eleve)
    {
        Connection con = null;
        Statement st;
        int id = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Etudiant WHERE ID_Utilisateur = '"+id_eleve+"'");
            while(r.next())
            {
                id = r.getInt("ID_groupe");  
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return id;
    }
}

