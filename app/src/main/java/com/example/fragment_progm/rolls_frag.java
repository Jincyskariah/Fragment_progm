package com.example.fragment_progm;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class rolls_frag extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String> name,cost;

    public rolls_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_rolls_frag, container, false);
        recyclerView=root.findViewById(R.id.r_view_rolls);
        int[]image={R.drawable.roll1,R.drawable.roll2,R.drawable.roll3,R.drawable.roll4};
        name=new ArrayList<>();
        name.add("Rolls");
        name.add("Mexican");
        name.add("Italian");
        name.add("Spicy");
        cost=new ArrayList<>();
        cost.add("290");
        cost.add("390");
        cost.add("210");
        cost.add("400");
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new Adapter(image,getContext(),name,cost));


        return root;
    }

}
