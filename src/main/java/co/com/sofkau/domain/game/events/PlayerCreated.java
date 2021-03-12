package co.com.sofkau.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.Player;

public class PlayerCreated extends DomainEvent {

    private final Player player;

    public PlayerCreated(Player player) {
        super("ddd-game.player.created");
        this.player = player;
    }

    public Player player(){
        return player;
    }

}
