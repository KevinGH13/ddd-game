package co.com.sofkau.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.Player;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;

import java.util.Map;

public class RoundCreated extends DomainEvent {
    private final RoundId roundId;
    private final Map<Person, Player> players;

    public RoundCreated(RoundId roundId, Map<Person, Player> players) {
        super("ddd-game.round.created");
        this.roundId = roundId;
        this.players = players;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public Map<Person, Player> getPlayers() {
        return players;
    }

}
