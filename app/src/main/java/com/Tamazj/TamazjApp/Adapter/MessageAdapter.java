package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.Message;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter {

    RecyclerView.ViewHolder holder;
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private final List<Message> messages;
    final Context context;
    private LayoutInflater inflater;
    public MessageAdapter(Context context, List<Message> messages){
        this.messages = messages;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.send_message_layout, parent, false);
            holder = new MyHolder(view);;
            return new MyHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.receive_message_layout, parent, false);
            holder = new ReceiveMessageHolder(view);;
            return new ReceiveMessageHolder(view);
        }

  //      return null;
//        View view = inflater.inflate(R.layout.send_message_layout,parent,false);
//        MyHolder holder = new MyHolder(view);
       return holder;
    }

    @Override
    public int getItemViewType(int position) {
        if(!(messages.isEmpty())) {
            if (messages.get(position).isReceive()) {
                // If some other user sent the message
                return VIEW_TYPE_MESSAGE_RECEIVED;
            } else {
                // If the current user is the sender of the message
                return VIEW_TYPE_MESSAGE_SENT;
            }
        }
        return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((MyHolder) holder).bind(position, messages, context);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceiveMessageHolder) holder).bind(position, messages, context);
                break;
        }
    }

//    @Override
//    public void onBindViewHolder(final MyHolder holder, final int position) {
//        this.holder = holder;
//        if (!(messages.isEmpty())) {
//            holder.messageBody.setText(messages.get(position).getMessageBody());
//            holder.time.setText(messages.get(position).getTime());
//            if(messages.get(position).isSeen()){
//                Picasso.with(context).load(getURLForResource(R.drawable.cireclenotification)).into(holder.seen);
//            } else {
//                Picasso.with(context).load(getURLForResource(R.drawable.oldcireclenotification)).into(holder.seen);
//            }
//        }
//    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView messageBody, time;
        ImageView seen;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            messageBody = itemView.findViewById(R.id.tvMessage);
            time = itemView.findViewById(R.id.tvMessageTime);
            seen = itemView.findViewById(R.id.ivMessageState);
            container = itemView.findViewById(R.id.cardViewSendMessage);
            container.setOnClickListener(this);
            this.setIsRecyclable(false);
        }

        public void bind(int position, List<Message> messages, Context context) {
        if (!(messages.isEmpty())) {
            messageBody.setText(messages.get(position).getMessageBody());
            time.setText(messages.get(position).getTime());
            if(messages.get(position).isSeen()){
                Picasso.with(context).load(getURLForResource(R.drawable.cireclenotification)).into(seen);
            } else {
                Picasso.with(context).load(getURLForResource(R.drawable.oldcireclenotification)).into(seen);
            }
        }
    }

        public String getURLForResource (int resourceId) {
            return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
        }


        @Override
        public void onClick(View v) {
            if(v == container) {

            }
        }

    }

    static class ReceiveMessageHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView messageBody, time;
        //ImageView seen;
        ViewGroup container;

        public ReceiveMessageHolder(View itemView) {
            super(itemView);
            messageBody = itemView.findViewById(R.id.tvMessage);
            time = itemView.findViewById(R.id.tvMessageTime);
            //seen = itemView.findViewById(R.id.informationIcon);
            container = itemView.findViewById(R.id.cardViewReceiveMessage);
            container.setOnClickListener(this);
            this.setIsRecyclable(false);
        }

        public void bind(int position, List<Message> messages, Context context) {
            if (!(messages.isEmpty())) {
                messageBody.setText(messages.get(position).getMessageBody());
                time.setText(messages.get(position).getTime());
            }
        }

        @Override
        public void onClick(View v) {
            if(v == container) {

            }
        }

    }
}
