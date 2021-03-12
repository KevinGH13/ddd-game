package co.com.sofkau.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cash implements ValueObject<Double> {

    private final Double value;

    public Cash(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Double value() {
        return value;
    }
}
