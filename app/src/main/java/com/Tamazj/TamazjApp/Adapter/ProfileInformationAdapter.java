package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.ConsultApplication;
import com.Tamazj.TamazjApp.Model.ProfileInformation;
import com.Tamazj.TamazjApp.R;

import java.util.List;

public class ProfileInformationAdapter extends RecyclerView.Adapter<ProfileInformationAdapter.MyHolder> {

    MyHolder holder;

    private final List<ProfileInformation> profileInformations;
    final Context context;
    private LayoutInflater inflater;
    public ProfileInformationAdapter(Context context, List<ProfileInformation> profileInformations){
        this.profileInformations = profileInformations;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.profile_information_recycler_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(profileInformations.isEmpty())) {
            holder.text.setText(profileInformations.get(position).getText());
            holder.img.setImageResource(profileInformations.get(position).getIcon());
        }
    }
public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return profileInformations.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView text;
        ImageView img;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tvInformation);
            img = itemView.findViewById(R.id.informationIcon);
            container = itemView.findViewById(R.id.informationContainer);
            container.setOnClickListener(this);
            this.setIsRecyclable(false);
        }

        @Override
        public void onClick(View v) {
            if(v == container) {

            }
        }

    }


}
