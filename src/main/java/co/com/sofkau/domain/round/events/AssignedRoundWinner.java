package co.com.sofkau.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.values.Bet;
import co.com.sofkau.domain.game.values.Cash;
import co.com.sofkau.domain.game.values.Person;

public class AssignedRoundWinner extends DomainEvent {

    private final Person roundWinner;
    private final Bet accumulatedBet;
    private final Cash cashWinner;

    public AssignedRoundWinner(Person roundWinner, Bet accumulatedBet, Cash cashWinner) {
        super("ddd-game.round.roundwinnerassigned");
        this.roundWinner = roundWinner;
        this.accumulatedBet = accumulatedBet;
        this.cashWinner = cashWinner;
    }

    public Person getRoundWinner() {
        return roundWinner;
    }

    public Bet getAccumulatedBet() {
        return accumulatedBet;
    }

    public Cash getCashWinner() {
        return cashWinner;
    }
}
