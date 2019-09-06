package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.ReceiveMessage;
import com.Tamazj.TamazjApp.R;

import java.util.List;

public class ReceiveMessageAdapter extends RecyclerView.Adapter<ReceiveMessageAdapter.MyHolder> {

    MyHolder holder;

    private final List<ReceiveMessage> receiveMessages;
    final Context context;
    private LayoutInflater inflater;
    public ReceiveMessageAdapter(Context context, List<ReceiveMessage> receiveMessages){
        this.receiveMessages = receiveMessages;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.receive_message_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(receiveMessages.isEmpty())) {
            holder.messageBody.setText(receiveMessages.get(position).getMessageBody());
            holder.time.setText(receiveMessages.get(position).getTime());
//holder.seen.setImageResource(receiveMessages.get(position).getIcon());
        }
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return receiveMessages.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView messageBody, time;
        //ImageView seen;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            messageBody = itemView.findViewById(R.id.tvMessage);
            time = itemView.findViewById(R.id.tvMessageTime);
            //seen = itemView.findViewById(R.id.informationIcon);
            container = itemView.findViewById(R.id.cardViewReceiveMessage);
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
