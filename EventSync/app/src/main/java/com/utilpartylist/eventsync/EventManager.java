package com.utilpartylist.eventsync;

import android.app.Activity;
import android.content.Context;
import android.media.metrics.Event;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.utilpartylist.eventsync.R;



import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;

public class EventManager {


    static ArrayList<HashMap<String,Object>> data = new ArrayList<>();
    public EventManager(Context context) {
    }

    public static void addEvent(EventObs event){
        {
            HashMap<String , Object> hashdata = new HashMap<>();
            hashdata.put("name",event.getName());
            hashdata.put("description",event.getDescription());
            hashdata.put("location",event.location);
            data.add(hashdata);
        }
    }


    public static void bindListViewTo(LinearLayout layout,String loc, Activity activity){

        layout.removeAllViews();


        for (int i = 0; i < data.size(); i++){

            if (data.get(i).get("location").toString().equals(loc)) {
                LayoutInflater inflater = activity.getLayoutInflater();
                View view = inflater.inflate(R.layout.eventlist_ui, null);

                layout.addView(view);

                final TextView name = view.findViewById(R.id.name);
                final TextView desc = view.findViewById(R.id.decript);
                name.setText(data.get(i).get("name").toString());
                desc.setText(data.get(i).get("description").toString());
            }
        }
    }



    public static int EventCount(String location){
        int size = 0;
        for (int i = 0; i < data.size();i++){
            if (data.get(i).get("location").toString().equals(location)){
                size++;
            }
        }

        return size;
    }



}