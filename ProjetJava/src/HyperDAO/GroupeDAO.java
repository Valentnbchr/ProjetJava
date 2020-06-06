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
public class GroupeDAO {
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public GroupeDAO()
    {}
    
    public int tailleGroupe(int ID)
    {
        Connection con = null;
        Statement st;
        String rqt = "Select * FROM Etudiant WHERE ID_groupe = '"+ID+"'";
        int t = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            st = con.createStatement();
            ResultSet r = st.executeQuery(rqt);
            
            while(r.next())
            {
                t++;
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return t;
    }
    
    public int getID(String nom)
    {
        Connection con = null;
        Statement st;
        int id_groupe = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            
                
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM Groupe WHERE Nom = '"+nom+"'");
            while(r.next())
            {
                id_groupe = r.getInt("ID");  
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return id_groupe;
    }
    
}
