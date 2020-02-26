package edu.jsu.mcis.tas_sp20;

import java.sql.*;

public class TASDatabase {
    
    Connection conn = null;
    PreparedStatement pstSelect = null, pstUpdate = null;
    ResultSet resultset = null;
    ResultSetMetaData metadata = null; 
    
    String server = ("jdbc:mysql://localhost/tas");
    String username = "root";
    String password = "001176853";
    
    String query, key, value;
    boolean hasResults;
    int resultCount, columnCount, updateCount = 0;
    
    public TASDatabase()
            {
            try
                {
                    System.out.println("Connecting to " + server + "...");

                    /* Load the MySQL JDBC Driver */
                    Class.forName("com.mysql.jdbc.Driver").newInstance();

                    /* Open Connection */
                    conn = DriverManager.getConnection(server, username, password);

                    /* Test Connection */
                    if (conn.isValid(0)) {

                    /* Connection Open! */
                    System.out.println("Connected Successfully!");
        
            }
                
                
         }
             catch (Exception e) {
            
            System.err.println(e.toString());
            
        }
    }
}
