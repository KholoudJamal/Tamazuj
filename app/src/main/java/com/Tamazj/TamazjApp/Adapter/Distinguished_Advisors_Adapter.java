package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.Model.Distinguished_Advisors_Model;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Distinguished_Advisors_Adapter  extends RecyclerView.Adapter<Distinguished_Advisors_Adapter.MyHolder>{

    private List<Distinguished_Advisors_Model> distinguished_advisors_models;
    private Context context;
    private LayoutInflater inflater;
    int pos;

    interface IClickListener{
        void onItemClick(int position,List<Areas_Counseling_Model> areas_counseling_models, View enable);
    }

    Areas_Counseling_adapter.IClickListener iClickListener;

    public Distinguished_Advisors_Adapter(Context context, List<Distinguished_Advisors_Model> distinguished_advisors_adapters){
        this.distinguished_advisors_models = distinguished_advisors_adapters;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public Distinguished_Advisors_Adapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.distinguished_advisors_item,parent,false);
        Distinguished_Advisors_Adapter.MyHolder holder = new Distinguished_Advisors_Adapter.MyHolder(view);
        return holder;
    }

    boolean isClickable;

    @Override
    public void onBindViewHolder(@NonNull final Distinguished_Advisors_Adapter.MyHolder holder, final int position) {
        Picasso.with(context)
                .load(distinguished_advisors_models.get(position).getArea_counseling_image())
                .error(R.drawable.image)
                .into(holder.area_counseling_image);
        holder.area_counseling_catogory.setText(distinguished_advisors_models.get(position).getArea_counseling_catogory());
        holder.area_counseling_name.setText(distinguished_advisors_models.get(position).getArea_counseling_name());


    }



    @Override
    public int getItemCount() { return distinguished_advisors_models.size(); }

    class MyHolder extends RecyclerView.ViewHolder  {

        ImageView area_counseling_image;
        TextView area_counseling_name;
        TextView area_counseling_catogory;


        public MyHolder(View itemView) {
            super(itemView);
            area_counseling_image = itemView.findViewById(R.id.area_counseling_image);
            area_counseling_catogory = itemView.findViewById(R.id.area_counseling_catogory);
            area_counseling_name = itemView.findViewById(R.id.area_counseling_name);


        }

    }
}

