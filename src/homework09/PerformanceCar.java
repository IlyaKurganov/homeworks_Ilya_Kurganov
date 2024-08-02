package homework09;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar() {
        super("defaultBrand", "defaultModel", 0, 0, 0, 0, 0);
        this.addOns = new ArrayList<>();
    }

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, (int)(horsepower * 1.5), acceleration, (int)(suspension * 0.75), durability);
        this.addOns = new ArrayList<>();
    }

    public List<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "addOns=" + addOns +
                ", brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", horsepower=" + getHorsepower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                '}';
    }
}
