package co.com.sofkau.domain.round;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.events.RoundCreated;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;
import co.com.sofkau.domain.round.events.RolledDice;
import co.com.sofkau.domain.round.events.RoundStarted;
import co.com.sofkau.domain.round.values.DiceId;
import co.com.sofkau.domain.round.values.Pot;
import co.com.sofkau.domain.round.values.StageId;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Round extends AggregateEvent<RoundId> {

    protected GameId gameId;
    protected Set<Person> players;
    protected Set<StageId> stages;
    protected Map<DiceId, Dice> dices;
    protected Pot pot;

    public Round(RoundId entityId) {
        super(entityId);
        subscribe(new RoundChange(this));
    }

    public Round(RoundId entityId, GameId gameId, Set<Person> players) {
        super(entityId);
        this.gameId = Objects.requireNonNull(gameId);
        this.players = Objects.requireNonNull(players);
        this.pot = new Pot((float) 0);
        appendChange(new RoundCreated(gameId, entityId, players)).apply();
    }

    public static Round from(RoundId roundId, List<DomainEvent> events){
        var round = new Round(roundId);
        events.forEach(round::applyEvent);
        return round;
    }

    public void startRound (GameId gameId, RoundId roundId, Set<Person> players){
        appendChange(new RoundStarted(gameId, roundId, players));
    }

    public void rollDices() {
        var valuesDice = this.dices
                .values()
                .stream()
                .map(dice -> Map.of(dice.identity(), dice.values()))
                .collect(Collectors.toList());
        appendChange(new RolledDice(gameId, valuesDice)).apply();
    }



}
