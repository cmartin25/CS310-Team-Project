package edu.jsu.mcis.tas_sp20;

import java.sql.*;
import java.time.LocalTime;

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

   public Punch getPunch(int punch)
   {
      
       int id = 0;
       int terminalid = 0;
       int punchTypeid = 0;
       String badgeid = null;
       Timestamp originalTimeStamp = null;
       
       try
       {
           /* Prepare Select Query */
                
            query = "SELECT * FROM punch = ?";
            
            pstSelect = conn.prepareStatement(query);
            pstSelect.setInt(1, punch);
                
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
       Badge badge = getBadge(badgeid);
       
       Punch p = new Punch(terminalid, badge, originalTimeStamp.getTime(), punchTypeid);
       
       return p;
    }
   
    public Badge getBadge(String badge)
    {
        String id = null;
        String description = null;
        
        try
       {
           /* Prepare Select Query */
                
            query = "SELECT * FROM badge = ?";
            
            pstSelect = conn.prepareStatement(query);
            pstSelect.setString(1, badge);
                
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
        Badge b = new Badge(id, description);
        
        return b;
    }
    
    public Shift getShift(int shift)
    {
        String description = null;
        LocalTime start = null;
        LocalTime stop = null;
        int interval = 0;
        int gracePeriod = 0;
        int dock = 0;
        LocalTime lunchStart = null;
        LocalTime lunchStop = null;
        int lunchDeduct = 0;
        
        Shift s = null;
        
        try
       {
           /* Prepare Select Query */
                
            query = "SELECT * FROM shift WHERE id = " + shift;
            
            pstSelect = conn.prepareStatement(query);
            //pstSelect.setInt(1, shift);
                
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
                  
                    description = resultset.getString("description");
                    String startTime = resultset.getString("start");
                    String[] startArray = startTime.split(":");
                    start = LocalTime.of( Integer.parseInt(startArray[0]), 
                            Integer.getInteger(startArray[1]));
                    String stopTime = resultset.getString("stop");
                    String[] stopArray = stopTime.split(":");
                    stop = LocalTime.of(Integer.parseInt(stopArray[0]), 
                            Integer.getInteger(stopArray[1]));
                    interval = resultset.getInt("interval");
                    gracePeriod = resultset.getInt("graceperiod");
                    dock = resultset.getInt("dock");
                    String lunchstartTime = resultset.getString("lunchstart");
                    String[] lunchstartArray = lunchstartTime.split(":");
                    lunchStart = LocalTime.of(Integer.parseInt(lunchstartArray[0]), 
                            Integer.getInteger(lunchstartArray[1]));
                    String lunchstopTime = resultset.getString("lunchstop");
                    String[] lunchstopArray = lunchstopTime.split(":");
                    lunchStop = LocalTime.of(Integer.parseInt(lunchstopArray[0]), 
                            Integer.getInteger(lunchstopArray[1]));
                    lunchDeduct = resultset.getInt("lunchdeduct");
                    
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
        
        s = new Shift(shift, description, start, stop, interval,
            gracePeriod, dock, lunchStart, lunchStop, lunchDeduct);
        
        return s;
        
        
    }
    
    public Shift getShift(Badge badge){
        
        Shift shift = null;
        String badgeid = badge.getBadgeID();
        
        try{
        
            /* Prepare Select Query */
                
            query = "SELECT * FROM employee WHERE badgeid = ?";
            
            pstSelect = conn.prepareStatement(query);
            pstSelect.setString(1, badgeid);
            
                
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
                    
                        shift = getShift(resultset.getInt("shiftid"));
                             
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
        
        return shift;
        
    }
}