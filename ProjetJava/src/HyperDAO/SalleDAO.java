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
public class SalleDAO {
    
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Hyperplanning?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public SalleDAO()
    {}
    
    public int getCapacité(int ID)
    {
        Connection con = null;
        Statement st;
        String rqt = "Select * FROM Salle WHERE ID = '"+ID+"'";
        int cap = 0;
        
        try
        {
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            st = con.createStatement();
            ResultSet r = st.executeQuery(rqt);
            
            while(r.next())
            {
                cap = r.getInt("Capacite");
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        return cap;
    }
}
