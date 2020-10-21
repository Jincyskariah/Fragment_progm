package com.example.fragment_progm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   TextView pizza,rolls,sweet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizza=findViewById(R.id.txt_pizza);
        rolls=findViewById(R.id.txt_rolls);
        sweet=findViewById(R.id.txt_sweet);

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_id,new BlankFragment());
        transaction.addToBackStack(null);
        transaction.commit();
        pizza.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pizza.setTextColor(Color.BLACK);
                rolls.setTextColor(Color.GRAY);
                sweet.setTextColor(Color.GRAY);

                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_id,new BlankFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        rolls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rolls.setTextColor(Color.BLACK);
                pizza.setTextColor(Color.GRAY);
                sweet.setTextColor(Color.GRAY);

                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_id,new rolls_frag());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        sweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rolls.setTextColor(Color.GRAY);
                pizza.setTextColor(Color.GRAY);
                sweet.setTextColor(Color.BLACK);

                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_id,new sweet_frag());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });



    }
}
