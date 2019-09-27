package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.Session;
import com.Tamazj.TamazjApp.R;

import java.util.List;

public class SessionAdapterwithoutImage extends RecyclerView.Adapter<SessionAdapterwithoutImage.MyHolder>{

    private List<Session.DataBean> sessionlist;
    private Context context;
    private LayoutInflater inflater;
    int pos;

    interface IClickListener{
        void onItemClick(int position, List<Session> sessionlist, View enable);
    }

    Areas_Counseling_adapter.IClickListener iClickListener;

    public SessionAdapterwithoutImage(Context context, List<Session.DataBean> sessionlist){
        this.sessionlist = sessionlist;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public SessionAdapterwithoutImage.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.session_item_without_imge,parent,false);

        SessionAdapterwithoutImage.MyHolder holder = new SessionAdapterwithoutImage.MyHolder(view);
        return holder;
    }

    boolean isClickable;

    @Override
    public void onBindViewHolder(@NonNull final SessionAdapterwithoutImage.MyHolder holder, final int position) {
        holder.session_image.setVisibility(View.GONE);

        holder.session_time_price.setText(sessionlist.get(position).getPrice()+"  "+context.getString(R.string.currancy)+"     "+"-"+"     "+sessionlist.get(position).getTime());


    }



    @Override
    public int getItemCount() { return sessionlist.size(); }

    class MyHolder extends RecyclerView.ViewHolder  {

        ImageView session_image;
        TextView session_time_price;

        public MyHolder(View itemView) {
            super(itemView);
            session_image = itemView.findViewById(R.id.session_image);
            session_time_price = itemView.findViewById(R.id.session_time_price);


        }

    }
}
