package homework09;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        return "DriftRace{" +
                "length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizePool=" + getPrizePool() +
                ", participants=" + getParticipants() +
                '}';
    }
}

