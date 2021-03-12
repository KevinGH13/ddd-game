package co.com.sofkau.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.domain.game.Player;
import co.com.sofkau.domain.game.commands.CreateGame;
import co.com.sofkau.domain.game.events.GameCreated;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateGameUseCaseTest {

    @Test
    void createGame(){
        var command = new CreateGame(Set.of(
                new Player(Person.of("1018"), "Kev"),
                new Player(Person.of("350"), "Wil"),
                new Player(Person.of("636"), "Andrew")
        ));
        var createGameUseCase = new CreateGameUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(createGameUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var gameCreated = (GameCreated) events.get(0);

        Assertions.assertEquals(3, gameCreated.getPlayers().size());
        Assertions.assertEquals("Kev", gameCreated.getPlayers().get(Person.of("1018")).name());
        Assertions.assertEquals("Wil", gameCreated.getPlayers().get(Person.of("350")).name());
        Assertions.assertEquals("Andrew", gameCreated.getPlayers().get(Person.of("636")).name());




    }

}