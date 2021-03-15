package co.com.sofkau.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.events.GameCreated;
import co.com.sofkau.domain.game.events.GameStarted;
import co.com.sofkau.domain.game.events.PlayerCreated;
import co.com.sofkau.domain.game.events.RoundCreated;
import co.com.sofkau.domain.game.factory.PlayerFactory;
import co.com.sofkau.domain.game.values.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game extends AggregateEvent<GameId> {

    protected Map<Person, Player> players;
    protected RoundId roundId;
    protected Boolean gameStarted;

    public Game(GameId entityId, PlayerFactory playerFactory) {
        super(entityId);
        appendChange(new GameCreated(entityId)).apply();
        playerFactory.players().forEach(player -> createPlayer(player.identity(), player.name(), player.cash()));
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


    //TODO review this method
    public void startGame() {
        appendChange(new GameStarted());
    }

    public void createRound() {
        var newRound = new RoundId();
        appendChange(new RoundCreated(newRound, players())).apply();
    }

    public void createPlayer(Person personId, Name name, Cash cash) {
        appendChange(new PlayerCreated(personId, name, cash));
    }

    public Map<Person, Player> players(){
        return players;
    }

    public RoundId roundId() {
        return roundId;
    }

    public Boolean gameStarted() {
        return gameStarted;
    }

}
