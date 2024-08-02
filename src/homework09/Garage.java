package homework09;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void parkCar(Car car) {
        this.parkedCars.add(car);
    }

    public void modifyCar(Car car) {
        car.setHorsepower(car.getHorsepower() + 50);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }
}
