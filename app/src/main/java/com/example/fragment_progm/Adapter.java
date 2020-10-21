package com.example.fragment_progm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.My_vh>{
 public int[] colours={Color.DKGRAY,Color.LTGRAY,Color.BLUE,};
 //   public String[] colours={"#2C0804","#B4B2B6","#230329","96D8F5"};


    int[]image;
    Context context;
    ArrayList<String> name,cost;

    public Adapter(int[] image, Context context, ArrayList<String> name, ArrayList<String> cost) {
        this.image = image;
        this.context = context;
        this.name = name;
        this.cost = cost;
    }





    @NonNull
    @Override
    public My_vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View   view= LayoutInflater.from(parent.getContext()).inflate(R.layout.spare,parent,false);
        return new My_vh(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull My_vh holder, final int position) {
holder.image_v.setImageResource(image[position]);
holder.txt_name.setText(name.get(position));
holder.txt_cost.setText(cost.get(position));

        GradientDrawable shape=new GradientDrawable();
        shape.setCornerRadius((float) 30.0);
       // shape.setColor(Color.parseColor(String.valueOf(colours[new Random().nextInt(4)])));
        shape.setColor(colours[new Random().nextInt(3)]);
        holder.itemView.setBackground(shape);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String inputimage=String.valueOf(image[position]);
                 String inputname=String.valueOf(name.get(position));
                 String intputcost=String.valueOf(cost.get(position));

                SharedPreferences sharedPreferences=context.getSharedPreferences("pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("pizza",inputimage);
                editor.putString("name",inputname);
                editor.putString("cost",intputcost);
                editor.apply();
                Intent intent = new Intent(context,Details.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return name.size() ;
    }

    class My_vh extends RecyclerView.ViewHolder{
        ImageView image_v;
        TextView txt_name,txt_cost;
       // RelativeLayout relativeLayout;
        LinearLayout linearLayout;

        public My_vh(@NonNull View itemView) {
            super(itemView);
            image_v=itemView.findViewById(R.id.img);
            txt_name=itemView.findViewById(R.id.txt_name);
            txt_cost=itemView.findViewById(R.id.txt_cost);
            linearLayout=itemView.findViewById(R.id.container);
        }
    }
}
