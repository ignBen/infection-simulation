public class SimulationApp {
    public static void main(String[] args) {

        int homes = 100;
        int homeCapacity = 5;

        int locations = 1000;
        int locationCapacity = 2;

        int startingInfected = 1;
        double infectionRate = 0.1;

        int movesPerDay = 3;

        int simulationDays = 100;

        Simulation world = new Simulation(homes, homeCapacity, locations, locationCapacity, startingInfected);
        System.out.println("Day: "+0+" Infected: "+world.getInfectedCount()+" Immume: "+world.getImmuneCount()+ " Clean: "+((homes*homeCapacity)-world.getImmuneCount()-world.getInfectedCount()));
        for (int i=0; i<simulationDays; i++){
            world.runDay(infectionRate, movesPerDay);
            System.out.println("Day: "+(i+1)+" Infected: "+world.getInfectedCount()+" Immume: "+world.getImmuneCount()+ " Clean: "+((homes*homeCapacity)-world.getImmuneCount()-world.getInfectedCount()));
            if (world.getInfectedCount() == 0) { break; }
        }
    }
}
