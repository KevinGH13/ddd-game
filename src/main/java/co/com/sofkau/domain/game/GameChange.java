package co.com.sofkau.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.domain.game.events.GameCreated;
import co.com.sofkau.domain.game.events.PlayerCreated;
import co.com.sofkau.domain.game.events.RoundCreated;
import co.com.sofkau.domain.game.values.Person;

import java.util.Map;

public class GameChange extends EventChange {
    public GameChange(Game game) {
        apply((GameCreated event) -> game.players = event.getPlayers());

        apply((RoundCreated event) -> game.roundId = event.getRoundId());

        //TODO revise command player
        //apply((PlayerCreated event) -> game.players = (Map<Person, Player>) event.player());

        //TODO apply others events here
    }

}
