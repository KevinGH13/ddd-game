package co.com.sofkau.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;

import java.util.List;


public class ForecastCompared extends DomainEvent {

    private final GameId gameId;
    private final RoundId roundId;
    private final List<Person> players;

    public ForecastCompared(GameId gameId, RoundId roundId, List<Person> players) {
        super("ddd-game.round.forecastvalidated");
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

    public List<Person> getPlayers() {
        return players;
    }
}
