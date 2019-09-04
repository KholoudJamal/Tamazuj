package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Tamazj.TamazjApp.Model.PayWayImage;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PayWayAdapter  extends RecyclerView.Adapter<PayWayAdapter.MyHolder> {

    MyHolder holder;

    private final List<PayWayImage> imageViews;
    final Context context;
    private LayoutInflater inflater;
    public PayWayAdapter(Context context, List<PayWayImage> imageViews){
        this.imageViews = imageViews;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.pay_way_image_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(imageViews.isEmpty())) {
            Picasso.with(context).load(getURLForResource(imageViews.get(position).getImgResource())).into(holder.img);
        }
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return imageViews.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        ImageView img;

        public MyHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.payWayImage);
            img.setOnClickListener(this);
            this.setIsRecyclable(false);
        }

        @Override
        public void onClick(View v) {
            if(v == img){
                //getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new MenuFragment(), "HomeFragment").commit();

            }
        }

    }


}
