package homework09;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        return "CasualRace{" +
                "length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizePool=" + getPrizePool() +
                ", participants=" + getParticipants() +
                '}';
    }
}
