package com.example.mad_tee_practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    Spinner spinner;
    TextView menu;
    TextView welcome;
    ImageView items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner=findViewById(R.id.spinner);
        items=findViewById(R.id.items);


        String message = getIntent().getStringExtra("message_key");
        TextView messageView = findViewById(R.id.message);
        messageView.setText("Welcome " +message+ " !!");


        String [] menus={"Select one","Burger","Coke","Fries"};

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,menus);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 1:
                        items.setImageResource(R.drawable.burger);
                        break;

                    case 2:
                        items.setImageResource(R.drawable.coke);
                        break;

                    case 3:
                        items.setImageResource(R.drawable.fries);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}