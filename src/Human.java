public class Human {

    private int status = 0; //0:none | 1: infected
    private final Location home;
    private Location location;

    public Human(Location home){
        this.home = home;
        this.location = home;
    }
    //getter methods
    public int getStatus(){ return this.status; }
    public Location getHome(){ return this.home; }
    public Location getLocation(){ return this.location; }

    //setter methods
    public void setStatus(int status){ this.status = status; }
    public void setLocation(Location location){ this.location = location; }

}
