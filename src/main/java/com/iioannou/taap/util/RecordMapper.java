package com.iioannou.taap.util;

import com.iioannou.taap.domain.CallD;
import com.iioannou.taap.domain.CallerD;
import com.iioannou.taap.entity.Call;
import com.iioannou.taap.entity.Caller;

/**
 * @author ioannou
 */
public class RecordMapper {

    private RecordMapper() {
        //intetionally empty
    }
    public static Caller convertToEnt(CallerD caller) {
        Caller ent = new Caller();
        ent.setGender(caller.getGender());
        ent.setEmail(caller.getEmail());
        ent.setFirstName(caller.getFirstName());
        ent.setLastName(caller.getLastName());
        ent.setId(caller.getId());
        ent.setImage(caller.getImage());
        return ent;
    }

    public static Call convertToEnt(CallD callD) {
        Call ent = new Call();
        ent.setDateTime(callD.getDateTime());
        ent.setDuration(callD.getDuration());
        ent.setContactedCallerId(callD.getContactedCallerId());
        return ent;
    }
}
