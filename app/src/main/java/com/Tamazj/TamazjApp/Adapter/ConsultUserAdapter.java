package com.Tamazj.TamazjApp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.Tamazj.TamazjApp.Model.Consult;
import com.Tamazj.TamazjApp.Model.Consults;
import com.Tamazj.TamazjApp.R;

import java.util.List;

public class ConsultUserAdapter extends RecyclerView.Adapter<ConsultUserAdapter.MyHolder> {

    MyHolder holder;

    private final List<Consults.DataBean> consults;
    private final List<Consults.DataBean.ConsultantIdBean> consultant_data;
    private final List<Consults.DataBean.SessionTimeBean> session_data;

    final Context context;
    private LayoutInflater inflater;
    public ConsultUserAdapter(Context context, List<Consults.DataBean> consults,List<Consults.DataBean.ConsultantIdBean> consultant_data,List<Consults.DataBean.SessionTimeBean> session_data){
        this.consults = consults;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.consultant_data=consultant_data;
        this.session_data=session_data;
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
           holder.name.setText(consultant_data.get(position).getName());
            holder.consultStatusScheduled.setText(consults.get(position).getStatus());
            holder.time.setText(session_data.get(position).getTime());
            //holder.type.setText(consults.get(position).getConsultType());
            //holder.time.setText(consults.get(position).getConsultPeriod());
            //Picasso.with(context).load(consults.get(position).getConsultIcon()).into(holder.img);
           /* if(consults.get(position).getStatus()){
                holder.consultStatusFinished.setVisibility(View.GONE);
                holder.consultStatusScheduled.setVisibility(View.VISIBLE);
            } else {
                holder.consultStatusScheduled.setVisibility(View.GONE);
                holder.consultStatusFinished.setVisibility(View.VISIBLE);
            }*/

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
            consultStatusScheduled = itemView.findViewById(R.id.tvConsultStatusScheduled);
            img = itemView.findViewById(R.id.consultImage);
            container = itemView.findViewById(R.id.cardViewConsult);
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
