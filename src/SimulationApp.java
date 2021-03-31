public class SimulationApp {
    public static void main(String[] args) {

        int homes = 10;
        int homeCapacity = 3;

        int locations = 100;
        int locationCapacity = 5;

        int startingInfected = 1;
        double infectionRate = 0.01;

        int movesPerDay = 3;

        int simulationDays = 100;

        Simulation world = new Simulation(homes, homeCapacity, locations, locationCapacity, startingInfected);
        System.out.println("Starting infected count: "+ world.getInfectedCount());
        for (int i=0; i<simulationDays; i++){
            world.runDay(infectionRate, movesPerDay);
            System.out.println("Infected count after "+(i+1)+" days: "+world.getInfectedCount()+"/"+(homes*homeCapacity));
        }
    }
}
