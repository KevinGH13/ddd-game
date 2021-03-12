package co.com.sofkau.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.domain.game.Player;

import java.util.Set;

public class CreateRound implements Command {

    private final Set<Player> players;

    public CreateRound(Set<Player> players) {
        this.players = players;
    }

    public Set<Player> getPlayers() {
        return players;
    }
}
