package homework09;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race() {
        this.participants = new ArrayList<>();
    }

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizePool=" + prizePool +
                ", participants=" + participants +
                '}';
    }
}

