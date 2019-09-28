package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.ConsultApplication;
import com.Tamazj.TamazjApp.R;

import java.util.List;

public class ConsultApplicationsAdapter extends RecyclerView.Adapter<ConsultApplicationsAdapter.MyHolder> {

    MyHolder holder;

    private final List<ConsultApplication> consultApplications;
    final Context context;
    private LayoutInflater inflater;
    public ConsultApplicationsAdapter(Context context, List<ConsultApplication> consultApplications){
        this.consultApplications = consultApplications;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.consult_application_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(consultApplications.isEmpty())) {
            //holder.type.setText(consultApplications.get(position).getConsultType());
            //holder.time.setText(consultApplications.get(position).getConsultApplicationPeriod());
            //Picasso.with(context).load(consultApplications.get(position).getConsultIcon()).into(holder.img);
        }
    }
public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return consultApplications.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView type, time;
        ImageView img;
        ImageButton approveButton;
        ImageButton cancelButton;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.tvConsultApplicationType);
            time = itemView.findViewById(R.id.tvConsultApplicationTime);
            img = itemView.findViewById(R.id.consultApplicationImage);
            approveButton = itemView.findViewById(R.id.approveButton);
            cancelButton = itemView.findViewById(R.id.cancelButton);
            container = itemView.findViewById(R.id.cardView);
            container.setOnClickListener(this);
            this.setIsRecyclable(false);
        }

        @Override
        public void onClick(View v) {
            if(v == approveButton){

            } else if(v == cancelButton){

            }
        }

    }


}
