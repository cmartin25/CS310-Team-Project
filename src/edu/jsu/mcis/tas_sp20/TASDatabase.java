package edu.jsu.mcis.tas_sp20;

import java.sql.*;
import java.util.ArrayList;

public class TASDatabase {
    
    Connection conn = null;
    PreparedStatement pstSelect = null, pstUpdate = null;
    ResultSet resultset = null;
    ResultSetMetaData metadata = null; 
    
    String server = ("jdbc:mysql://localhost/tas");
    String username = "Group1";
    String password = "Group1";
    
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
    
   public void closeConn()
   {
       try
        {
           conn.close();
           System.out.println("Connection Closed!");
        }
       catch (Exception e) {
           System.err.println(e.toString());
       }
   }

   public void getPunch(int punch)
   {
       int id = 0;
       int terminalid = 0;
       int punchTypeid = 0;
       String badgeid = null;
       Timestamp originalTimeStamp = null;
       
       try
       {
           /* Prepare Select Query */
                
            query = "SELECT * FROM punch WHERE punch = " + punch;
            
            pstSelect = conn.prepareStatement(query);
                
            /* Execute Select Query */
                
            System.out.println("Submitting Query ...");
                
            hasResults = pstSelect.execute();                
            resultset = pstSelect.getResultSet();
            metadata = resultset.getMetaData();
            columnCount = metadata.getColumnCount(); 
            
            /* Get Results */
                
            System.out.println("Getting Results ...");
                
            while ( hasResults || pstSelect.getUpdateCount() != -1 ) 
            {
                if ( hasResults ) 
                {
                        
                    /* Get ResultSet */
                        
                    resultset = pstSelect.getResultSet();
                    
                    while(resultset.next()) 
                    {
                        id = resultset.getInt(1);
                        terminalid = resultset.getInt(2);
                        badgeid = resultset.getString(3);
                        originalTimeStamp = resultset.getTimestamp(4);
                        punchTypeid = resultset.getInt(5);
                    }
                }
                else 
                {
                    resultCount = pstSelect.getUpdateCount();  
                    if ( resultCount == -1 ) 
                    {
                        break;
                    }    
                }
                   
                /* Check for More Data */
                hasResults = pstSelect.getMoreResults();

            }
        }
        catch (Exception e) {
            System.err.println(e.toString());   
        }
        
        /* Close Other Database Objects */
        
        finally {
            
            if (resultset != null) { try { resultset.close(); resultset = null; 
            } catch (Exception e) {} }
            
            if (pstSelect != null) { try { pstSelect.close(); pstSelect = null; 
            } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; 
            } catch (Exception e) {} }
            
        }
    }
   
    public void getBadge(String badge)
    {
        String id = null;
        String description = null;
        
        try
       {
           /* Prepare Select Query */
                
            query = "SELECT * FROM badge WHERE id = '" + badge +  "'";
            
            pstSelect = conn.prepareStatement(query);
                
            /* Execute Select Query */
                
            System.out.println("Submitting Query ...");
                
            hasResults = pstSelect.execute();                
            resultset = pstSelect.getResultSet();
            metadata = resultset.getMetaData();
            columnCount = metadata.getColumnCount(); 
            
            /* Get Results */
                
            System.out.println("Getting Results ...");
                
            while ( hasResults || pstSelect.getUpdateCount() != -1 ) 
            {
                if ( hasResults ) 
                {
                        
                    /* Get ResultSet */
                        
                    resultset = pstSelect.getResultSet();
                    
                    while(resultset.next()) 
                    {
                        id = resultset.getString(1);
                        description = resultset.getString(2);
                    }
                }
                else 
                {
                    resultCount = pstSelect.getUpdateCount();  
                    if ( resultCount == -1 ) 
                    {
                        break;
                    }    
                }
                   
                /* Check for More Data */
                hasResults = pstSelect.getMoreResults();

            }
        }
        catch (Exception e) {
            System.err.println(e.toString());   
        }
        
        /* Close Other Database Objects */
        
        finally {
            
            if (resultset != null) { try { resultset.close(); resultset = null; 
            } catch (Exception e) {} }
            
            if (pstSelect != null) { try { pstSelect.close(); pstSelect = null; 
            } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; 
            } catch (Exception e) {} }
            
        }
    }
    
    public void getShift(int shift)
    {
        String description = null;
        String[] start = null;
        String[] stop = null;
        int interval = 0;
        int gracePeriod = 0;
        int dock = 0;
        String[] lunchStart = null;
        String[] lunchStop = null;
        int lunchDeduct = 0;
        
        
        try
       {
           /* Prepare Select Query */
                
            query = "SELECT * FROM shift WHERE id =" + shift;
            
            pstSelect = conn.prepareStatement(query);
                
            /* Execute Select Query */
                
            System.out.println("Submitting Query ...");
                
            hasResults = pstSelect.execute();                
            resultset = pstSelect.getResultSet();
            metadata = resultset.getMetaData();
            columnCount = metadata.getColumnCount(); 
            
            /* Get Results */
                
            System.out.println("Getting Results ...");
                
            while ( hasResults || pstSelect.getUpdateCount() != -1 ) 
            {
                if ( hasResults ) 
                {
                        
                    /* Get ResultSet */
                        
                    resultset = pstSelect.getResultSet();
                    
                    while(resultset.next()) 
                    {
                        //Here
                    }
                }
                else 
                {
                    resultCount = pstSelect.getUpdateCount();  
                    if ( resultCount == -1 ) 
                    {
                        break;
                    }    
                }
                   
                /* Check for More Data */
                hasResults = pstSelect.getMoreResults();

            }
        }
        catch (Exception e) {
            System.err.println(e.toString());   
        }
        
        /* Close Other Database Objects */
        
        finally {
            
            if (resultset != null) { try { resultset.close(); resultset = null; 
            } catch (Exception e) {} }
            
            if (pstSelect != null) { try { pstSelect.close(); pstSelect = null; 
            } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; 
            } catch (Exception e) {} }
            
        }
    }
}


