package co.com.sofkau.usecases.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.domain.game.values.RoundId;
import co.com.sofkau.domain.round.Round;
import co.com.sofkau.domain.round.events.ForecastCompared;

public class AssignRoundWinnerUseCase extends UseCase<TriggeredEvent<ForecastCompared>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ForecastCompared> forecastValidatedTriggeredEvent) {
        var event = forecastValidatedTriggeredEvent.getDomainEvent();
        var roundId = RoundId.of(event.aggregateRootId());
        var round = Round.from(roundId, retrieveEvents());

        round.assignWinner(event.getPlayers());

        emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));

    }
}
