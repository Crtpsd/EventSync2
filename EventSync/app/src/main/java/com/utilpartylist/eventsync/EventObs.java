package com.utilpartylist.eventsync;

import java.util.ArrayList;
import java.util.HashMap;

public class EventObs {
    String name,description,sched,location;
    public EventObs() {


    }

    public void setEventName(String name){
        this.name = name;
    }
    public void setDescription (String description){
        this.description = description;
    }

    public String getName () {
        return name;
    }
    public String getDescription (){
        return description;
    }



}
