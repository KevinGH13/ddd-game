package co.com.sofkau.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.Player;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;

import java.util.Map;

public class GameStarted extends DomainEvent {

    public GameStarted() {
        super("ddd-game.started");
    }


}
