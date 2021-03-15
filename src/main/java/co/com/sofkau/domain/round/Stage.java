package co.com.sofkau.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.round.values.BettingRound;
import co.com.sofkau.domain.round.values.StageId;

import java.util.List;
import java.util.Map;

public class Stage extends Entity<StageId> {

    private final Map<Person, BettingRound> bettingRound;
    private final List<Dice> dice;

    public Stage(StageId entityId, Map<Person, BettingRound> bettingRound, List<Dice> dice) {
        super(entityId);
        this.bettingRound = bettingRound;
        this.dice = dice;
    }

    public Map<Person, BettingRound> bettingRound() {
        return bettingRound;
    }

    public List<Dice> dice() {
        return dice;
    }
}
