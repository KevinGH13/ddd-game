package co.com.sofkau.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.domain.game.commands.CreateRound;
import co.com.sofkau.domain.game.values.RoundId;

public class CreateRoundUseCase extends UseCase<RequestCommand<CreateRound>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateRound> input) {

        var command = input.getCommand();
        var roundId = new RoundId();

        if (command.getPlayers().size() < 2) {
            throw new BusinessException(roundId.value(), "Round can't start. Winner can be assigned");
        }

        //TODO implement var Round to create round and transport map of players.
        // implement here

        /*
        var game = new Game(new GameId(), command.getPlayers());
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));*/
    }
}
