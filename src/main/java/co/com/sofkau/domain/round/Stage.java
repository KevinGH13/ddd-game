package co.com.sofkau.domain.round;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.round.values.CompoundBet;
import co.com.sofkau.domain.round.values.StageId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stage extends Entity<StageId> {

    private final Set<Person> players;
    private final Map<Person, CompoundBet> bettingRound;
    private final List<Dice> dices;


    public Stage(StageId entityId, Set<Person> players, List<Dice> dices) {
        super(entityId);
        this.players = players;
        this.bettingRound = new HashMap<>();
        this.dices = dices;
    }

    public Set<Person> players(){
        return players;
    }

    public Map<Person, CompoundBet> bettingRound(){
        return bettingRound;
    }

    public List<Dice> dices(){
        return dices;
    }


}
