package co.com.sofkau.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.domain.game.values.Bet;
import co.com.sofkau.domain.game.values.Cash;
import co.com.sofkau.domain.game.values.Forecast;
import co.com.sofkau.domain.game.values.Person;

import java.util.Objects;

public class Player extends Entity<Person> {

    private final String name;
    private Cash cash;
    private Bet bet;
    private Forecast forecast;


    public Player(Person person, String name, Cash cash, Bet bet, Forecast forecast) {
        super(person);
        this.name = name;
        this.cash = cash;
        this.bet = bet;
        this.forecast = forecast;
    }

    public Player(Person person, String name) {
        super(person);
        this.name = name;
        this.cash = new Cash((double) 0);
    }

    public String name() {
        return name;
    }

    public Cash cash() {
        return cash;
    }

    public Bet bet() {
        return bet;
    }

    public Forecast forecast() {
        return forecast;
    }

    public void makeBet(Bet bet){
        this.bet = Objects.requireNonNull(bet);
    }

    public void matchBet (Bet equalBet) {
        this.bet = Objects.requireNonNull(equalBet);
    }

    public void increaseBet (Double newBet) {
        if(newBet < bet.value()) {
            throw new IllegalArgumentException("New bet cannot be lower than actual bet");
        }
        makeBet(new Bet(newBet));
    }

    public void makeForecast(Forecast forecast) {
        this.forecast = Objects.requireNonNull(forecast);
    }

    public void changeForecast(Forecast actualForecast) {
        //TODO implement validation to forecast
        makeForecast(actualForecast);
    }


}
