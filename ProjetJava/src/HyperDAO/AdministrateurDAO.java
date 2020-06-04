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
    
    
    
    public AdministrateurDAO()
    {
    }
    
    public void ajoutseance(int semaine, String date, String heure_debut, String heure_fin, int etat, int id_cours, int id_type, int id_enseignant, int id_groupe, int id_salle)
    {
        String USERNAME="root";
        String PASSWORD="root";
        String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection con = null;
        Statement st, st2, st3, st4;
        
        String rqt = "INSERT INTO Seance (Semaine, Date, Heure_debut, Heure_Fin, Etat, ID_Cours, ID_Type)VALUES ('"+semaine+"','"+date+"','"+heure_debut+"','"+heure_fin+"', '"+etat+"', '"+id_cours+"','"+id_type+"') ";
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            int id_seance = 0;
            System.out.println("Connected !");
            st = con.createStatement();
            st.executeUpdate(rqt);
            
            
            st2 = con.createStatement();
            ResultSet r = st2.executeQuery("SELECT * FROM Seance WHERE Semaine = '"+semaine+"' AND Date = '"+date+"' AND Heure_debut = '"+heure_debut+"' AND Heure_Fin = '"+heure_fin+"' AND Etat = '"+etat+"' AND ID_Cours = '"+id_cours+"' AND ID_Type = '"+id_type+"' ");
            while(r.next())
            {
                id_seance = r.getInt("ID");  
            }
            
            String rqt2 = "INSERT INTO Seance_Enseignant (ID_Seance, ID_Enseignant)VALUES ('"+id_seance+"','"+id_enseignant+"') ";
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
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        
    }
    

    
}
