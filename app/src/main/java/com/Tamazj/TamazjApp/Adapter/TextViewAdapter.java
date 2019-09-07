package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.Review;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TextViewAdapter extends RecyclerView.Adapter<TextViewAdapter.MyHolder> {


    public interface IClickListener{
        void onItemClick(int position,String text);
    }

    IClickListener iClickListener;
    public void setiClickListener(IClickListener iClickListener) {
        this.iClickListener = iClickListener;
    }

    MyHolder holder;

    private final List<String> list;
    final Context context;
    private LayoutInflater inflater;
    public TextViewAdapter(Context context, List<String> list){
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.textview_show_advisor_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(list.isEmpty())) {
            holder.text.setText(list.get(position));
        }

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iClickListener !=null){
                    iClickListener.onItemClick(position,list.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
      // implements  View.OnClickListener
        TextView text;
        public MyHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
           // text.setOnClickListener(this);
            this.setIsRecyclable(false);
        }

//        @Override
//        public void onClick(View v) {
//            if(v == text) {
//
//            }
//        }

    }


}

