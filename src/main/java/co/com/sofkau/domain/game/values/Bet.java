package co.com.sofkau.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Bet implements ValueObject<Double> {

    private final Double value;

    public Bet(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Double value() {
        return value;
    }

}
