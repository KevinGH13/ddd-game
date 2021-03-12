package co.com.sofkau.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.Player;
import co.com.sofkau.domain.game.values.Person;

import java.util.Map;

public class GameCreated extends DomainEvent {

    private final Map<Person, Player> players;

    public GameCreated(Map<Person, Player> players) {
        super("ddd-game.game.created");
        this.players = players;
    }

    public Map<Person, Player> getPlayers() {
        return players;
    }
}
