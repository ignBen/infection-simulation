import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SimulationApp {
    public static void main(String[] args) throws FileNotFoundException {

        int homes = 100;
        int homeCapacity = 5;

        int locations = 1000;
        int locationCapacity = 10;

        int startingInfected = 3;
        double infectionRate = 0.1;

        int movesPerDay = 4;

        int simulationDays = 100;
        int simulations = 10;

        int count = 0;
        while (true){
            File newFile = new File("../data/data"+count+".csv");
            if (newFile.exists()){ count += 1; } else { break; }
        }
        PrintWriter file = new PrintWriter(new File("../data/data"+count+".csv"));
        StringBuilder data = new StringBuilder();

        data.append("people, locations, location capacity, starting infected, infection rate, moves per day\n");
        data.append((homes*homeCapacity)).append(",").append(locations).append(",").append(locationCapacity).append(",").append(startingInfected).append(",").append(infectionRate).append(",").append(movesPerDay).append("\n");
        data.append("day, infected, immune, clean\n");

        for (int j=0; j<simulations; j++){
            Simulation world = new Simulation(homes, homeCapacity, locations, locationCapacity, startingInfected);
            // System.out.println("Day: "+0+" Infected: "+world.getInfectedCount()+" Immume: "+world.getImmuneCount()+ " Clean: "+((homes*homeCapacity)-world.getImmuneCount()-world.getInfectedCount()));
            for (int i=0; i<simulationDays; i++){
                world.runDay(infectionRate, movesPerDay);
                // System.out.println("Day: "+(i+1)+" Infected: "+world.getInfectedCount()+" Immume: "+world.getImmuneCount()+ " Clean: "+((homes*homeCapacity)-world.getImmuneCount()-world.getInfectedCount()));
                data.append(i + 1).append(",").append(world.getInfectedCount()).append(",").append(world.getImmuneCount()).append(",").append((homes*homeCapacity)-world.getImmuneCount()-world.getInfectedCount()).append("\n");

                if (world.getInfectedCount() == 0) {
                    System.out.println("Simulation "+(j+1)+" completed");
                    break;
                }
            }
        }

        file.write(data.toString());
        file.close();
    }
}
