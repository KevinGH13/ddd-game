package co.com.sofkau.domain.round;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.domain.game.values.GameId;

public class Round extends AggregateEvent<GameId> {



    public Round(GameId entityId) {
        super(entityId);
    }
}
