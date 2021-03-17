package co.com.sofkau.domain.round;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.domain.round.events.RolledDice;
import co.com.sofkau.domain.round.events.RoundStarted;

import java.util.HashSet;

public class RoundChange extends EventChange {
    public RoundChange(Round round) {

        apply((RoundStarted event) -> round.stages = new HashSet<>());

        apply((RolledDice event) -> round.dices.values().forEach(Dice::rollDice));
    }
}
