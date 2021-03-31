public class Human {

    private int status = 0; //0:none | 1: infected | 2: immune
    private int daysInfected = 0;
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
    public void updateDaysInfected(){
        if (status == 1){
            if (daysInfected == 7){ status = 2; }
            daysInfected += 1;
        }
    }

}
