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
public class ConnexionDAO {
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public ConnexionDAO()
    {}
    
    public boolean connexion(String email, String mdp)
    {
        
        Connection con = null;
        Statement st;
        String rqt = "Select * FROM Utilisateur WHERE Email = '"+email+"'";
        String verifmdp = "";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected !");
            st = con.createStatement();
            ResultSet r = st.executeQuery(rqt);
            boolean n = r.next();
            
            if(!n)
            {
                System.out.println("L'email est incorrecte.");
                return false;
            }  
            while (n)
            {
                verifmdp = r.getString("Mdp");
                n = r.next();
                
            }   
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        if(verifmdp.equals(mdp))
        {
            System.out.println("Vous etes connecté !");
            return true;
        }
        else
        {
            System.out.println("Le mot de passe est incorrecte.");
            return false;
        }
         
    }
    
    public int verifUtilisateur(String email, String mdp)
    {
        Connection con = null;
        Statement st;
        String rqt = "Select * FROM Utilisateur WHERE Email = '"+email+"' AND Mdp = '"+mdp+"'";
        int droit = 0;

        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            st = con.createStatement();
            ResultSet r = st.executeQuery(rqt);
            boolean n = r.next();
            
            
            while(n)
            {
                droit = r.getInt("Droit");
                n = r.next();
            }
            
            if(droit == 1)
            {
                System.out.println("Vous etes un(e) Administrateur");
            }
            if(droit == 2)
            {
                System.out.println("Vous etes un(e) Référent Pedagogique");
            }
            if(droit == 3)
            {
                System.out.println("Vous etes un(e) Professeur");
            }
            if(droit == 4)
            {
                System.out.println("Vous etes un(e) Elève");
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return droit;
        
    }
        
}
    

