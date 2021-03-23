package co.com.sofkau.usecases.round;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;
import co.com.sofkau.domain.round.events.ForecastCompared;
import co.com.sofkau.domain.round.events.RoundWinnerAssigned;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AssignRoundWinnerUseCaseTest {

    private final List<Person> stagePlayers = List.of(Person.of("1018"));

    private final GameId gameId = GameId.of("0001");

    private final RoundId roundId = RoundId.of("01");

    @Mock
    private DomainEventRepository repository;

    @Test
    void assignRoundWinner() {
        var event = new ForecastCompared(gameId, roundId, stagePlayers);
        event.setAggregateRootId(roundId.value());

        var useCase = new AssignRoundWinnerUseCase();

        when(repository.getEventsBy(roundId.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(roundId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var roundWinnerAssigned = (RoundWinnerAssigned) events.get(0);

        Assertions.assertEquals("1018", roundWinnerAssigned.getWinner().value());
    }


    private List<DomainEvent> eventStored() {
        return List.of(
               new ForecastCompared(gameId, roundId, stagePlayers)
        );
    }

}