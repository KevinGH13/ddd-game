package co.com.sofkau.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.values.Person;


public class RoundWinnerAssigned extends DomainEvent {
    private final Person winner;

    public RoundWinnerAssigned(Person winner) {
        super("ddd-game.round.roundwinnerassigned");
        this.winner = winner;
    }

    public Person getWinner() {
        return winner;
    }
}
