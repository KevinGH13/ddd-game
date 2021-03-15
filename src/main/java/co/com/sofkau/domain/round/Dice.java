package co.com.sofkau.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.domain.round.values.DiceFace;
import co.com.sofkau.domain.round.values.DiceId;

import java.util.Map;

public class Dice extends Entity<DiceId> {

    private Map<DiceFace, Boolean> values;

    public Dice(DiceId entityId) {
        super(entityId);
    }

    public void rollDice() {
        for (int i = 0; i < 7; i++){
            var diceFace = (int) ((Math.random()*6) + 1);
            values.put(new DiceFace(diceFace), Boolean.FALSE);
        }
    }

    public Map<DiceFace, Boolean> values() {
        return values;
    }

}
