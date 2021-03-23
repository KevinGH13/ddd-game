package co.com.sofkau.usecases.round;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.domain.game.events.RoundCreated;
import co.com.sofkau.domain.game.values.GameId;
import co.com.sofkau.domain.game.values.Person;
import co.com.sofkau.domain.game.values.RoundId;
import co.com.sofkau.domain.round.events.RolledDice;
import co.com.sofkau.domain.round.events.StageStarted;
import co.com.sofkau.domain.round.events.RoundStarted;
import co.com.sofkau.domain.round.values.DiceFace;
import co.com.sofkau.domain.round.values.DiceId;
import co.com.sofkau.domain.round.values.StageId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StartStageUseCaseTest {

    private final Set<Person> players = Set.of(
            Person.of("1018"), Person.of("636"),
            Person.of("1010")
    );

    private final GameId gameId = GameId.of("0001");

    private final RoundId roundId = RoundId.of("01");

    private final StageId stageId = StageId.of(1);

    private final List<Map<DiceId, List<DiceFace>>> valuesDice = List.of(
            Map.of(
                    DiceId.of(1),
                    List.of(
                            new DiceFace(1),
                            new DiceFace(3),
                            new DiceFace(3),
                            new DiceFace(2),
                            new DiceFace(5),
                            new DiceFace(1))
                    ));


    @Mock
    private DomainEventRepository repository;

    @Test
    void StartFirstStage(){

        var event = createTriggeredEventWith();

        var useCase = new StartStageUseCase();

        when(repository.getEventsBy(roundId.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = executor(roundId, event, useCase);
        var firstStageStarted = (StageStarted) events.get(0);

        Assertions.assertEquals("1", firstStageStarted.getStageId().toString());
    }

    private List<DomainEvent> executor (RoundId roundId, RolledDice event, StartStageUseCase useCase){
        return UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(roundId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
    }

    private RolledDice createTriggeredEventWith() {
        var event = new RolledDice(gameId, roundId, stageId, players, valuesDice);
        event.setAggregateRootId(roundId.value());
        return event;
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new RoundCreated(gameId, roundId, players),
                new RoundStarted(gameId, roundId, stageId, players)
        );
    }

}