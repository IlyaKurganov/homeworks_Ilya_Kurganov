package homework09;

public class App {
    public static void main(String[] args) {
        PerformanceCar performanceCar = new PerformanceCar("Ferrari", "488 GTB", 2020, 660, 3, 70, 100);
        ShowCar showCar = new ShowCar("Lamborghini", "Huracan", 2020, 610, 3, 80, 100);

        CasualRace casualRace = new CasualRace(500, "Street Circuit", 1000);
        DragRace dragRace = new DragRace(200, "Drag Strip", 2000);
        DriftRace driftRace = new DriftRace(300, "Mountain Pass", 1500);

        casualRace.addParticipant(performanceCar);
        dragRace.addParticipant(performanceCar);
        driftRace.addParticipant(showCar);

        Garage garage = new Garage();
        garage.parkCar(performanceCar);
        garage.parkCar(showCar);

        garage.modifyCar(performanceCar);

        // Вывод информации
        System.out.println(performanceCar);
        System.out.println(showCar);
        System.out.println(casualRace);
        System.out.println(dragRace);
        System.out.println(driftRace);
        System.out.println(garage);
    }
}
