package com.example.fragment_progm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class Details extends AppCompatActivity {
    TextView name,cost;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name=findViewById(R.id.name_detail);
        cost=findViewById(R.id.cost_detail);
        image=findViewById(R.id.img_pizza);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        String dataimage=sharedPreferences.getString("pizza",null);
        String dataname=sharedPreferences.getString("name",null);
        String datacost=sharedPreferences.getString("cost",null);
        name.setText(dataname);
        cost.setText(datacost);
        image.setImageResource(Integer.parseInt(dataimage));



    }
}
