package homework09;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        return "DragRace{" +
                "length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizePool=" + getPrizePool() +
                ", participants=" + getParticipants() +
                '}';
    }
}
