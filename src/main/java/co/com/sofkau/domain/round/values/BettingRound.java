package co.com.sofkau.domain.round.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofkau.domain.game.values.Bet;
import co.com.sofkau.domain.game.values.Forecast;

import java.util.Objects;

public class BettingRound implements ValueObject<BettingRound.Values> {

    private final Bet bet;
    private final Forecast forecast;

    public BettingRound(Bet bet, Forecast forecast) {
        this.bet = Objects.requireNonNull(bet);
        this.forecast = Objects.requireNonNull(forecast);
    }

    @Override
    public Values value() {

        return new BettingRound.Values() {
            @Override
            public Bet bet() {
                return bet;
            }

            @Override
            public Forecast forecast(){
                return forecast;
            }
        };
    }

    public interface Values{
        Bet bet();

        Forecast forecast();
    }

}
