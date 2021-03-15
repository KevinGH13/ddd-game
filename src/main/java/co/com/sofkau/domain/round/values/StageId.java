package co.com.sofkau.domain.round.values;

import co.com.sofka.domain.generic.Identity;

public class StageId extends Identity {
    private StageId(String uid){
        super(uid);
    }

    public StageId(){}

    public StageId of(String uid){
        return new StageId(uid);
    }
}
