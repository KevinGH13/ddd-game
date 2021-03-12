package co.com.sofkau.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.domain.game.events.GameCreated;

public class GameChange extends EventChange {
    public GameChange(Game game) {
        apply((GameCreated event) -> game.players = event.getPlayers());
    }

}
