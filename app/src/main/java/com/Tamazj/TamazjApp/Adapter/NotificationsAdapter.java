package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.Notification;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.MyHolder> {

    MyHolder holder;

    private final List<Notification> notifications;
    final Context context;
    private LayoutInflater inflater;
    public NotificationsAdapter(Context context, List<Notification> notifications){
        this.notifications = notifications;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notfication_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(notifications.isEmpty())) {
            holder.text.setText(notifications.get(position).getNotificationText());
            holder.time.setText(notifications.get(position).getTime());
            if(notifications.get(position).isNew()) {
                Picasso.with(context).load(getURLForResource(R.drawable.cireclenotification)).into(holder.img);
            } else {
                Picasso.with(context).load(getURLForResource(R.drawable.oldcireclenotification)).into(holder.img);
            }
        }
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView text, time;
        ImageView img;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tvNotificationBody);
            time = itemView.findViewById(R.id.tvnotificationTime);
            img = itemView.findViewById(R.id.notificationImage);
            container = itemView.findViewById(R.id.cardViewNotification);
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
