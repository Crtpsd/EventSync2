package com.utilpartylist.eventsync;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard extends AppCompatActivity {



    ArrayList<HashMap<String,Object>> locations = new ArrayList<>();

    LinearLayout listview,createbutton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        init();
        addallEvents();
        addAllMenu();
        listAllLocation();




    }

    @Override
    public void onResume(){
        super.onResume();
        listAllLocation();

    }

    public void init(){
                listview = this.findViewById(R.id.listview);
                createbutton = this.findViewById(R.id.host);


        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = getIntent();
                it.setClass(getApplicationContext(),CreateEvent.class);
                startActivity(it);

            }
        });
    }

    public void addallEvents(){
        {
            EventObs event = new EventObs();
            event.setEventName("Keane's Birthday");
            event.setDescription("May Ara Kami Libre ng lechon sa balay");
            event.location = "smx";
            EventManager.addEvent(event);
        }
        {
            EventObs event = new EventObs();
            event.setEventName("Julian's Birthday");
            event.setDescription("May Ara Kami Libre ng lechon sa balay");
            event.location = "ayala";
            EventManager.addEvent(event);
        }
    }

    public void addAllMenu(){
        {
            HashMap<String ,Object> hashdata = new HashMap<>();
            hashdata.put("name","SMX SM City Bacolod");
            hashdata.put("desc","The Premier Convention Center of Bacolod City.");
            hashdata.put("key","smx");
            hashdata.put("image","https://www.smxconventioncenter.com/wp-content/uploads/2022/12/SMXCC_Website-Revamp_SMX-Bacolod_Function-Room1_1500-x-1000-scaled.jpg");
            locations.add(hashdata);

        }
        {
            HashMap<String ,Object> hashdata = new HashMap<>();
            hashdata.put("name","Sugarland Hotel");
            hashdata.put("desc","Well-Equipped Event Spaces Perfect for Conference and small Events.");
            hashdata.put("key","sugar");
            hashdata.put("image","https://th.bing.com/th/id/OIP.7kByU-gMXhOX1OmJJbbOTgHaE7?w=1280&h=853&rs=1&pid=ImgDetMain");
            locations.add(hashdata);

        }
        {
            HashMap<String ,Object> hashdata = new HashMap<>();
            hashdata.put("name","L'Fisher Hotel");
            hashdata.put("desc","A Luxurious Hotel with versatile Event Spaces ideal for business meetings, weddings and conferences.");
            hashdata.put("key","fisher");
            hashdata.put("image","https://th.bing.com/th/id/OIP.utdr4YDN0bNYLbEJiMSoCAHaE8?w=720&h=480&rs=1&pid=ImgDetMain\n");
            locations.add(hashdata);

        }
        {
            HashMap<String ,Object> hashdata = new HashMap<>();
            hashdata.put("name","Ayala Malls");
            hashdata.put("desc","A dynamic location for events offering both indoor and outdoor spaces for various activities.");
            hashdata.put("key","ayala");
            hashdata.put("image","https://th.bing.com/th/id/OIP.u7gASP4Q_teOxvjeFDcDLQAAAA?rs=1&pid=ImgDetMain\n");
            locations.add(hashdata);

        }
    }


    public void listAllLocation(){
        listview.removeAllViews();
        for (int position = 0; position<locations.size();position++){
            LayoutInflater inflater = this.getLayoutInflater();
            View view = inflater.inflate(R.layout.menulist_ui,null);

            final TextView menu_name = view.findViewById(R.id.menu_name);
            menu_name.setText(locations.get(position).get("name").toString());
            final TextView ec = view.findViewById(R.id.eventcount);
            ec.setText(String.valueOf(EventManager.EventCount(locations.get(position).get("key").toString()))+" Available Events");


            final int p  = position;
            listview.addView(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),AvailableEvents.class);
                    intent.putExtra("key", locations.get(p).get("key").toString());
                    intent.putExtra("name", locations.get(p).get("name").toString());
                    intent.putExtra("desc",locations.get(p).get("desc").toString());
                    intent.putExtra("image",locations.get(p).get("image").toString());

                    startActivity(intent);
               }
            });



        }
    }
}


