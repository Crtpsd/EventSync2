package com.utilpartylist.eventsync;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateEvent extends AppCompatActivity {


    Button button;
    EditText editTextText,editTextText2,editTextText3;
    RadioButton radioButton,radioButton2,radioButton3,radioButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_event);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
    }


    public void init(){
        button = this.findViewById(R.id.button);
        radioButton = this.findViewById(R.id.radioButton);
        radioButton2 = this.findViewById(R.id.radioButton2);
        radioButton3 = this.findViewById(R.id.radioButton3);
        radioButton4 = this.findViewById(R.id.radioButton4);
        editTextText = this.findViewById(R.id.editTextText);
        editTextText2 = this.findViewById(R.id.editTextText2);
        editTextText3 = this.findViewById(R.id.editTextText3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateEvent();
            }
        });
    }
    public void CreateEvent (){

        EventObs obs = new EventObs();




        if (radioButton.isChecked()){
            obs.location = "smx";
        }if (radioButton2.isChecked()){
            obs.location = "sugar";
        }if (radioButton3.isChecked()){
            obs.location = "ayala";
        }if (radioButton4.isChecked()){
            obs.location = "fisher";
        }
        obs.setEventName(editTextText.getText().toString());
        obs.setDescription(editTextText2.getText().toString());
        obs.sched = editTextText2.getText().toString();

        EventManager.addEvent(obs);

        Intent in = new Intent();
        in.setClass(this,DigitalTicket.class);
        in.putExtra("Name", editTextText.getText().toString());
        in.putExtra("l", editTextText.getText().toString());
        in.putExtra("s", editTextText3.getText().toString());
        startActivity(in);
        finish();




    }
}