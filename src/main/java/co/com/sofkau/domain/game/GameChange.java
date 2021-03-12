package co.com.sofkau.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.domain.game.events.GameCreated;
import co.com.sofkau.domain.game.events.GameStarted;
import co.com.sofkau.domain.game.events.RoundCreated;

import java.util.Map;

public class GameChange extends EventChange {
    public GameChange(Game game) {
        apply((GameCreated event) -> game.players = event.getPlayers());

        apply((RoundCreated event) -> game.roundId = event.getRoundId());

        apply((GameStarted event) -> {
            if (Boolean.TRUE.equals(game.gameStarted)){
                throw new IllegalArgumentException("Game is already created");
            }
            game.gameStarted = Boolean.TRUE;
        });

        //TODO revise command player
        //apply((PlayerCreated event) -> game.players = (Map<Person, Player>) event.player());

        //TODO apply others events here
    }

}
