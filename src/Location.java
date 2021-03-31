import java.util.ArrayList;

public class Location {

    private int occupancy = 0;
    private final int capacity;
    private ArrayList<Human> humans = new ArrayList<Human>();

    public Location(int capacity){ this.capacity = capacity; }

    //getter methods
    public int getOccupancy(){ return this.occupancy; }
    public int getCapacity(){ return this.capacity; }
    public ArrayList<Human> getHumans() { return humans; }

    //setter methods
    public void addHuman(Human human){
        humans.add(human);
        occupancy += 1;
    }
    public void removeHuman(Human human){
        humans.remove(human);
        occupancy -= 1;
    }
}
