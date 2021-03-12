package co.com.sofkau.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;

import java.util.Map;

public class Game extends AggregateEvent<GameId> {

    protected Map<Person, Player> players;
    protected RoundId roundId;


    public Game(GameId entityId) {
        super(entityId);
    }
}
