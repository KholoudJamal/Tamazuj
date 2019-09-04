package com.Tamazj.TamazjApp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.Consult;
import com.Tamazj.TamazjApp.R;

import java.util.List;

public class ConsultAdapter extends RecyclerView.Adapter<ConsultAdapter.MyHolder> {

    MyHolder holder;

    private final List<Consult> consults;
    final Context context;
    private LayoutInflater inflater;
    public ConsultAdapter(Context context, List<Consult> consults){
        this.consults = consults;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.advisor_constluct_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(consults.isEmpty())) {
            //holder.name.setText(consults.get(position).getConsultName());
            //holder.type.setText(consults.get(position).getConsultType());
            //holder.time.setText(consults.get(position).getConsultPeriod());
            //Picasso.with(context).load(consults.get(position).getConsultIcon()).into(holder.img);
            if(consults.get(position).isScheduled()){
                holder.consultStatusFinished.setVisibility(View.GONE);
                holder.consultStatusScheduled.setVisibility(View.VISIBLE);
            } else {
                holder.consultStatusScheduled.setVisibility(View.GONE);
                holder.consultStatusFinished.setVisibility(View.VISIBLE);
            }
        }
    }
public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return consults.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView name, type, time, consultStatusFinished ,consultStatusScheduled;
        ImageView img;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvConsultName);
            type = itemView.findViewById(R.id.tvConsultType);
            time = itemView.findViewById(R.id.tvConsultTime);
            consultStatusFinished = itemView.findViewById(R.id.tvConsultStatus);
           // consultStatusScheduled = itemView.findViewById(R.id.tvConsultStatusScheduled);
            img = itemView.findViewById(R.id.consultImage);
            //container = itemView.findViewById(R.id.cardViewConsult);
            container.setOnClickListener(this);
            this.setIsRecyclable(false);
        }

        @Override
        public void onClick(View v) {
            if(v == container){

            }
        }

    }


}
