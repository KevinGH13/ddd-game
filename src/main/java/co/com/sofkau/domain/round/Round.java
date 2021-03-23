package co.com.sofkau.domain.round;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.events.RoundCreated;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;
import co.com.sofkau.domain.round.events.RoundWinnerAssigned;
import co.com.sofkau.domain.round.events.StageStarted;
import co.com.sofkau.domain.round.events.RolledDice;
import co.com.sofkau.domain.round.events.RoundStarted;
import co.com.sofkau.domain.round.values.*;

import java.util.*;
import java.util.stream.Collectors;

public class Round extends AggregateEvent<RoundId> {

    protected GameId gameId;
    protected RoundId roundId;
    protected Set<Person> players;
    protected StageId stageId;
    protected Integer countStage;
    protected Map<DiceId, Dice> dices;
    protected Pot pot;

    public Round(RoundId entityId) {
        super(entityId);
        subscribe(new RoundChange(this));
    }

    public Round(RoundId entityId, GameId gameId, Set<Person> players) {
        super(entityId);
        appendChange(new RoundCreated(gameId, entityId, players)).apply();
    }

    public static Round from(RoundId roundId, List<DomainEvent> events){
        var round = new Round(roundId);
        events.forEach(round::applyEvent);
        return round;
    }

    public void startRound (GameId gameId, RoundId roundId, Set<Person> players){
        appendChange(new RoundStarted(gameId, roundId, stageId, players));
    }

    public void startFirstStage(StageId stageId, Set<Person> players){
        appendChange(new StageStarted(gameId, stageId, players));
    }

    public void rollDices() {
        var valuesDice = this.dices
                .values()
                .stream()
                .map(dice -> Map.of(dice.identity(), dice.values()))
                .collect(Collectors.toList());
        appendChange(new RolledDice(gameId, roundId, stageId, players, valuesDice)).apply();
    }

    public void assignWinner(List<Person> players) {

        if (players.size() > 1 && countStage < 3) {
            appendChange(new StageStarted(gameId, stageId, new HashSet<>(players))).apply();
        }
        appendChange(new RoundWinnerAssigned(players.get(0))).apply();
    }

    public Set<Person> players() {
        return players;
    }

    public Map<DiceId, Dice> dices() {
        return dices;
    }



}
