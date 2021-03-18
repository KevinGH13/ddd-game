package co.com.sofkau.usecases.round;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.Game;
import co.com.sofkau.domain.game.events.GameCreated;
import co.com.sofkau.domain.game.events.PlayerCreated;
import co.com.sofkau.domain.game.values.Cash;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Name;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.round.commands.StartRound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StartRoundUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void StartRound() {
        //TODO create test start round
    }

    private List<DomainEvent> eventStored(GameId id) {
        return List.of(
                new GameCreated(id),
                new PlayerCreated(Person.of("1018"), new Name("Kev"), new Cash(1000F)),
                new PlayerCreated(Person.of("350"), new Name("Wil"), new Cash(1000F)),
                new PlayerCreated(Person.of("636"), new Name("Ale"), new Cash(1000F))
        );
    }

}