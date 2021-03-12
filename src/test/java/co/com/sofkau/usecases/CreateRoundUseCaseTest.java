package co.com.sofkau.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.domain.game.Player;
import co.com.sofkau.domain.game.commands.CreateGame;
import co.com.sofkau.domain.game.commands.CreateRound;
import co.com.sofkau.domain.game.events.GameCreated;
import co.com.sofkau.domain.game.events.RoundCreated;
import co.com.sofkau.domain.game.values.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateRoundUseCaseTest {

    @Test
    void createRound(){
        var command = new CreateRound(Set.of(new Player(Person.of("1018"), "Kev"),
                new Player(Person.of("350"), "Wil"),
                new Player(Person.of("636"), "Andrew")));
        var createRoundUseCase = new CreateRoundUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(createRoundUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var roundCreated = (RoundCreated) events.get(0);

        Assertions.assertEquals(command.getPlayers(), roundCreated.getPlayers());

    }
}