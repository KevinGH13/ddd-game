package co.com.sofkau.domain.round.values;

import co.com.sofka.domain.generic.Identity;

public class DiceId extends Identity {

    private DiceId(String uid){
        super(uid);
    }

    public DiceId(){}

    public static DiceId of(String uid) {
        return new DiceId(uid);
    }

}
