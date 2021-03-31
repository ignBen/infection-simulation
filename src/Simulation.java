import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Simulation {

    private ArrayList<Human> humans = new ArrayList<Human>();
    private ArrayList<Location> homes = new ArrayList<Location>();
    private ArrayList<Location> locations = new ArrayList<Location>();

    public Simulation(int homes, int homeCapacity, int locations, int locationCapacity, double starting_infected){
        for (int i=0; i<homes;  i++){
            Location newHome = new Location(homeCapacity);
            this.homes.add(newHome);
        }
        for (int i=0; i<locations; i++){
            Location newLocation = new Location(locationCapacity);
            this.locations.add(newLocation);
        }
        for (Location home : this.homes){
            if (home.getOccupancy() < home.getCapacity()){
                for (int i=0; i<3; i++) {
                    Human newHuman = new Human(home);
                    this.humans.add(newHuman);
                    home.addHuman(newHuman);
                }
            }
        }
        for (int i=0; i<starting_infected; i++){
            while (true){
                Random random = new Random();
                Human randomPerson = humans.get(random.nextInt(this.humans.size()));
                if (randomPerson.getStatus() != 1) {
                    randomPerson.setStatus(1);
                    break;
                }
            }
        }
    }

    public void runDay(double infectionRate, int movesPerDay){
        for (int i=0; i<movesPerDay; i++){
            for (Human human : humans){
                moveHuman(human);
                updateInfections(infectionRate);
            }
        }
        for (Human human : humans){
            moveHumanHome(human);
        }
    }

    public void moveHuman(Human human){
        while (true){
            Random random = new Random();
            Location randomLocation = locations.get(random.nextInt(locations.size()));
            if (randomLocation.getOccupancy() < randomLocation.getCapacity()){
                human.getLocation().removeHuman(human); //remove from old location
                randomLocation.addHuman(human); //add to new location
                human.setLocation(randomLocation); //update human location tracking
                break;
            }
        }
    }
    public void moveHumanHome(Human human){
        human.getLocation().removeHuman(human);
        human.setLocation(human.getHome());
    }
    public void updateInfections(double rate){
        for (Location location : locations){
            ArrayList<Human> humans = location.getHumans();

            ArrayList<Human> notInfectedHumans = new ArrayList<Human>();
            int infected_count = 0;

            for (Human human : humans){
                if (human.getStatus() == 0){
                    notInfectedHumans.add(human);
                } else {
                    infected_count += 1;
                }
            }

            for (int i=0; i<infected_count; i++){
                for (Human human : notInfectedHumans){
                    if (Math.random() < rate){
                        human.setStatus(1);
                    }
                }
            }
        }
    }

    public int getInfectedCount(){
        int count = 0;
        for (Human human : humans){
            if (human.getStatus() == 1){
                count += 1;
            }
        }
        return count;
    }
}
