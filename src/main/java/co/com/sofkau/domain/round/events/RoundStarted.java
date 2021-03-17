package co.com.sofkau.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;

import java.util.Set;

public class RoundStarted extends DomainEvent {
    private final GameId gameId;
    private final RoundId roundId;
    private final Set<Person> players;

    public RoundStarted(GameId gameId, RoundId roundId, Set<Person> players) {
        super("ddd-game.roundstarted");
        this.gameId = gameId;
        this.roundId = roundId;
        this.players = players;
    }

    public GameId getGameId() {
        return gameId;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public Set<Person> getPlayers() {
        return players;
    }
}
