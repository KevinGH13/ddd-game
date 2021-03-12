package co.com.sofkau.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.events.GameCreated;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game extends AggregateEvent<GameId> {

    protected Map<Person, Player> players;
    protected RoundId roundId;

    public Game(GameId entityId, Set<Player> players) {
        super(entityId);
        Map<Person, Player> newPlayers = new HashMap<>();
        players.forEach(player -> newPlayers.put(player.identity(), player));
        appendChange(new GameCreated(newPlayers)).apply();
    }

    public Game(GameId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }

    public static Game from(GameId gameId, List<DomainEvent> events) {
        var game = new Game(gameId);
        events.forEach(game::applyEvent);
        return game;
    }

    //TODO apply aggregate behaviors here


    public Map<Person, Player> players(){
        return players;
    }

    public RoundId roundId() {
        return roundId;
    }

}
