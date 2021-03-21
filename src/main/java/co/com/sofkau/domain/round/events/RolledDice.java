package co.com.sofkau.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;
import co.com.sofkau.domain.round.values.DiceFace;
import co.com.sofkau.domain.round.values.DiceId;
import co.com.sofkau.domain.round.values.StageId;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RolledDice extends DomainEvent {

    private final GameId gameId;
    private final RoundId roundId;
    private final StageId stageId;
    private final Set<Person> players;
    private final List<Map<DiceId, List<DiceFace>>> diceValues;

    public RolledDice(GameId gameId, RoundId roundId, StageId stageId, Set<Person> players,List<Map<DiceId, List<DiceFace>>>  diceValues) {
        super("ddd-game.round.rolleddice");
        this.gameId = gameId;
        this.roundId = roundId;
        this.stageId = stageId;
        this.players = players;
        this.diceValues = diceValues;
    }

    public GameId getGameId() {
        return gameId;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public StageId getStageId() {
        return stageId;
    }

    public Set<Person> getPlayers() {
        return players;
    }

    public List<Map<DiceId, List<DiceFace>>> getDiceValues() {
        return diceValues;
    }
}
