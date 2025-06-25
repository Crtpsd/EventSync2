package com.utilpartylist.eventsync;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;
import java.net.URL;

public class AvailableEvents extends AppCompatActivity {



    LinearLayout listview ;
    TextView name,dec;
    ImageView bj;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_available_events);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }


    public void init(){
        key = this.getIntent().getStringExtra("key");
        listview = this.findViewById(R.id.listview_2);
        EventManager.bindListViewTo(listview,key,this);
        name = this.findViewById(R.id.name);
        dec = this.findViewById(R.id.description1);
        name.setText(this.getIntent().getStringExtra("name"));
        dec.setText(this.getIntent().getStringExtra("desc"));
        bj = this.findViewById(R.id.bg);
        LoadImageFromWebOperations(this.getIntent().getStringExtra("image"));

    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

}