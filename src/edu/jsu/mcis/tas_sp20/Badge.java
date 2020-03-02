package edu.jsu.mcis.tas_sp20;

public class Badge {
    
    private String badgeDescription;
    private String badgeID;
    
    public Badge(String ID, String badgeD) {
        
        this.badgeID = ID;
        this.badgeDescription = badgeD;
        
    }
    
    public String getBadgeID(){
        return badgeID;
    }
    
    public String getBadgeDescription() {
        return badgeDescription;
    }

    String getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}