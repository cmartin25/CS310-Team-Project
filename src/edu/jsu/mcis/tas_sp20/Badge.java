package edu.jsu.mcis.tas_sp20;

public class Badge {
    
    private String badgeDescription;
    private String badgeID;
    
    public Badge(String ID, String badgeD) {
        
        this.badgeID = ID;
        this.badgeDescription = badgeD;
        
    }
    
    public String getBadgeid(){
        return badgeID;
    }
    
    public String getBadgeDescription() {
        return badgeDescription;
    }
    
    @Override
    public String toString(){
        String FullBadge = "#" + badgeID + " (" + badgeDescription + ")";
        return FullBadge;
    }
}
