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
public class EnseignantDAO {
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public EnseignantDAO()
    {}
    
    public int getID(String nom)
    {
        Connection con = null;
        Statement st;
        int id_ens = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Utilisateur WHERE Nom = '"+nom+"'");
            while(r.next())
            {
                id_ens = r.getInt("ID");  
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return id_ens;
    }
    
    public String getNom(int id)
    {
        Connection con = null;
        Statement st;
        String nom = "";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Utilisateur WHERE ID = '"+id+"'");
            while(r.next())
            {
                nom = r.getString("Nom");  
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return nom;
    }
    
    public int getprofID(String email)
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
    
    
}
