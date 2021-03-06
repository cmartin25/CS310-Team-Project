package edu.jsu.mcis.tas_sp20;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TASDatabase {
    
    Connection conn = null;
    PreparedStatement pstSelect = null, pstUpdate = null;
    ResultSet resultset = null;
    ResultSetMetaData metadata = null; 
    
    String server = ("jdbc:mysql://localhost/TAS");
    String username = "Group1";
    String password = "Group1";
    
    String query, key, value;
    boolean hasResults;
    int resultCount, columnCount, updateCount = 0;
    
    public static void main (String[] args){
        TASDatabase db = new TASDatabase();
        db.getBadge("12565C60");
        System.out.println(db.getShift(1).toString());
    }
    
    public TASDatabase() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(server, username, password);

            if (conn.isValid(0))
                System.out.println("Connected Successfully!");   
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
       long originalTimeStamp = 0;
       
       try
       {
                
            query = "SELECT * FROM punch WHERE id = ?";
            
            pstSelect = conn.prepareStatement(query);
            pstSelect.setInt(1, punch);
                
            hasResults = pstSelect.execute();                
            resultset = pstSelect.getResultSet();
            metadata = resultset.getMetaData();
            columnCount = metadata.getColumnCount();
                                
            while ( hasResults || pstSelect.getUpdateCount() != -1 ) 
            {
                if ( hasResults ) 
                {
                        
                    resultset = pstSelect.getResultSet();
                    
                    while(resultset.next()) 
                    {
                        id = resultset.getInt("id");
                        terminalid = resultset.getInt("terminalid");
                        badgeid = resultset.getString("badgeid");
                        originalTimeStamp = resultset.getTimestamp("originaltimestamp").getTime();
                        punchTypeid = resultset.getInt("punchtypeid");
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

                hasResults = pstSelect.getMoreResults();

            }
        }
        catch (Exception e) {
            System.err.println(e.toString());   
        }

        finally {
            
            if (resultset != null) { try { resultset.close(); resultset = null; 
            } catch (Exception e) {} }
            
            if (pstSelect != null) { try { pstSelect.close(); pstSelect = null; 
            } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; 
            } catch (Exception e) {} }
            
        }
       
       Badge badge = this.getBadge(badgeid);
       
       Punch p = new Punch(terminalid, badge, originalTimeStamp, punchTypeid);
       
       return p;
    }
   
    public Badge getBadge(String badge)
    {
        String id = null;
        String description = null;
        
        try
       {        
            query = "SELECT * FROM badge WHERE id = ?";
            
            pstSelect = conn.prepareStatement(query);
            pstSelect.setString(1, badge);
                                
            hasResults = pstSelect.execute();                
            resultset = pstSelect.getResultSet();
            metadata = resultset.getMetaData();
            columnCount = metadata.getColumnCount(); 
                                
            while ( hasResults || pstSelect.getUpdateCount() != -1 ) 
            {
                if ( hasResults ) 
                {       
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
 
                hasResults = pstSelect.getMoreResults();

            }
        }
        catch (Exception e) {
            System.err.println(e.toString());   
        }

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
            query = "SELECT * FROM shift WHERE id = ?";
            
            pstSelect = conn.prepareStatement(query);
            pstSelect.setInt(1, shift);
                        
            hasResults = pstSelect.execute();                
            resultset = pstSelect.getResultSet();
            metadata = resultset.getMetaData();
            columnCount = metadata.getColumnCount(); 
                                
            while ( hasResults || pstSelect.getUpdateCount() != -1 ) 
            {
                if ( hasResults ) 
                {
                    
                    resultset = pstSelect.getResultSet();
                    resultset.first();
                  
                    description = resultset.getString("description");
                    String startTime = resultset.getString("start");
                    String stopTime = resultset.getString("stop");
                    interval = resultset.getInt("interval");
                    gracePeriod = resultset.getInt("graceperiod");
                    dock = resultset.getInt("dock");
                    String lunchstartTime = resultset.getString("lunchstart");
                    String lunchstopTime = resultset.getString("lunchstop");
                    lunchDeduct = resultset.getInt("lunchdeduct");
                    
                    
                    
                    String[] startArray = startTime.split(":");
                    start = LocalTime.of( Integer.parseInt(startArray[0]), 
                            Integer.parseInt(startArray[1]));
             
                    String[] stopArray = stopTime.split(":");
                    stop = LocalTime.of(Integer.parseInt(stopArray[0]), 
                            Integer.parseInt(stopArray[1]));
                    
                    String[] lunchstartArray = lunchstartTime.split(":");
                    lunchStart = LocalTime.of(Integer.parseInt(lunchstartArray[0]), 
                            Integer.parseInt(lunchstartArray[1]));
                    
                    String[] lunchstopArray = lunchstopTime.split(":");
                    lunchStop = LocalTime.of(Integer.parseInt(lunchstopArray[0]), 
                            Integer.parseInt(lunchstopArray[1]));   
                }
                else 
                {
                    resultCount = pstSelect.getUpdateCount();  
                    if ( resultCount == -1 ) 
                    {
                        break;
                    }    
                }
                   
                hasResults = pstSelect.getMoreResults();

            }
        }
        catch (Exception e) {
            System.err.println(e.toString());   
        }
        
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
        String badgeid = badge.getBadgeid();
        
        try{
            
            query = "SELECT shiftid FROM employee WHERE badgeid = ?";
            
            pstSelect = conn.prepareStatement(query);
            pstSelect.setString(1, badgeid);
                                
            hasResults = pstSelect.execute();                
            resultset = pstSelect.getResultSet();
            metadata = resultset.getMetaData();
            columnCount = metadata.getColumnCount(); 
                            
            while ( hasResults || pstSelect.getUpdateCount() != -1 ) 
            {
                if ( hasResults ) 
                {       
                        resultset = pstSelect.getResultSet();
                        resultset.first();
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
                hasResults = pstSelect.getMoreResults();
            }
        }
        
        catch (Exception e) {
            System.err.println(e.toString());
        }
        
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
       
    /* STARTED FEATURE 2 */
    
    public int insertPunch(Punch p) {
        
        String badgeID = p.getBadge().getBadgeid();
        int terminalID = p.getTerminalID();
        int punchTypeID = p.getPunchTypeID();
        int newPunchID = p.getID();
        Long originalTimeStamp = p.getOriginalTimeStamp();
        Timestamp ts = new Timestamp(originalTimeStamp);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(originalTimeStamp);
        
        try {
            
            query = "INSERT INTO punch (terminalid, badgeid, originaltimestamp,"
                    + "punchtypeid) VALUES (?, ?, ?, ?)";
            
            pstSelect = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            pstSelect.setInt(1, p.getTerminalID());
            pstSelect.setInt(4, p.getPunchTypeID());
            pstSelect.setString(2, p.getBadgeid());
            pstSelect.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                    .format(calendar.getTime()));
                                
            pstSelect.execute();                
            resultset = pstSelect.getGeneratedKeys();
                       
            resultset.first();
            
            return resultset.getInt(1);
        }
        
        catch (Exception e) {
            System.err.println(e.toString());
        }
        
        finally {
            if (resultset != null) { try { resultset.close(); resultset = null; 
            } catch (Exception e) {} }
            
            if (pstSelect != null) { try { pstSelect.close(); pstSelect = null; 
            } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; 
            } catch (Exception e) {} }    
        }
        return -1;
    }
        
    public ArrayList<Punch> getDailyPunchList(Badge badge, long ts){
        ArrayList<Punch> dailyPunchList = new ArrayList<>();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(ts);
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
        String date = formattedDate.format(calendar.getTime());
        date += "%";
        String badgeid = badge.getBadgeid();
        
    try {
            
        query = "SELECT * FROM punch WHERE badgeid = ? AND originaltimestamp " 
                + "LIKE ?";
        
        pstSelect = conn.prepareStatement(query);
        
        pstSelect.setString(1, badgeid);
        pstSelect.setString(2, date);
                        
        hasResults = pstSelect.execute();                
        resultset = pstSelect.getResultSet();
        metadata = resultset.getMetaData();
        columnCount = metadata.getColumnCount(); 
                    
        while (resultset.next()){
           
            long time = resultset.getTimestamp("originaltimestamp").getTime();
            int punchtype = resultset.getInt("punchtypeid");
            dailyPunchList.add(new Punch(
            resultset.getInt("id")
            ,resultset.getInt("terminalid")
            ,badge ,time, punchtype));
            }
        }   
        
        catch (Exception e) {
            //System.err.println(e.toString());
            e.printStackTrace();
        }
        
        finally {
            if (resultset != null) { try { resultset.close(); resultset = null; 
            } catch (Exception e) {} }
            
            if (pstSelect != null) { try { pstSelect.close(); pstSelect = null; 
            } catch (Exception e) {} }
            
            if (pstUpdate != null) { try { pstUpdate.close(); pstUpdate = null; 
            } catch (Exception e) {} }    
        }
    
        return dailyPunchList;
    }
    
}