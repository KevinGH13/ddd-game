package co.com.sofkau.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.domain.game.Player;

import java.util.Set;

public class CreateGame implements Command {
    private final Set<Player> players;

    public CreateGame(Set<Player> players) {
        this.players = players;
    }

    public Set<Player> getPlayers() {
        return players;
    }
}
