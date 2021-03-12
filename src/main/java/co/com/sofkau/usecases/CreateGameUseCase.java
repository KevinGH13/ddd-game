package co.com.sofkau.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.domain.game.Game;
import co.com.sofkau.domain.game.commands.CreateGame;
import co.com.sofkau.domain.game.values.GameId;

public class CreateGameUseCase extends UseCase<RequestCommand<CreateGame>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateGame> input) {
        var command = input.getCommand();
        var gameId = new GameId();

        if (command.getPlayers().size() < 2) {
            throw new BusinessException(gameId.value(), "Game allow 2 or more players");
        }

        var game = new Game(new GameId(), command.getPlayers());
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));

    }
}
