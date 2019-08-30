package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Areas_Counseling_adapter  extends RecyclerView.Adapter<Areas_Counseling_adapter.MyHolder>{

    private List<Areas_Counseling_Model> areas_counseling_models;
    private Context context;
    private LayoutInflater inflater;
    int pos;

    interface IClickListener{
        void onItemClick(int position,List<Areas_Counseling_Model> areas_counseling_models, View enable);
    }

    IClickListener iClickListener;

    public Areas_Counseling_adapter(Context context, List<Areas_Counseling_Model> areas_counseling_models){
        this.areas_counseling_models = areas_counseling_models;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.areas_counseling_item,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    boolean isClickable;

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
       Picasso.with(context)
              .load(areas_counseling_models.get(position).getArea_counseling_image())
               .error(R.drawable.asteshartnafsi)

               .into(holder.area_counseling_image);

        holder.area_counseling_catogory.setText(areas_counseling_models.get(position).getArea_counseling_catogory());


    }



    @Override
    public int getItemCount() { return areas_counseling_models.size(); }

    class MyHolder extends RecyclerView.ViewHolder  {

        ImageView area_counseling_image;
        TextView area_counseling_catogory;

        public MyHolder(View itemView) {
            super(itemView);
            area_counseling_image = itemView.findViewById(R.id.area_counseling_image);
            area_counseling_catogory = itemView.findViewById(R.id.area_counseling);


        }

    }
}
