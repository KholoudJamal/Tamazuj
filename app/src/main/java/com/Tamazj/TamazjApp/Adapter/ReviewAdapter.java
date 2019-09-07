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

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyHolder> {

    MyHolder holder;

    private final List<Review> reviews;
    final Context context;
    private LayoutInflater inflater;
    public ReviewAdapter(Context context, List<Review> reviews){
        this.reviews = reviews;
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
        if (!(reviews.isEmpty())) {
            holder.time.setText(reviews.get(position).getTime());
            holder.name.setText(reviews.get(position).getName());
            holder.rate.setText(reviews.get(position).getRate());
            holder.body.setText(reviews.get(position).getReviewBody());
            Picasso.with(context).load(getURLForResource(R.drawable.image)).into(holder.img);

            switch (reviews.get(position).getRate()){
                case AppConstants.HAPPY :
                    holder.feedbackIcon.setImageResource(R.drawable.love);
                    break;

                case AppConstants.SATISFIED :
                    holder.feedbackIcon.setImageResource(R.drawable.radi);
                    break;

                case AppConstants.NOT_SATISFIED :
                    holder.feedbackIcon.setImageResource(R.drawable.notradi);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + reviews.get(position).getRate());
            }
        }
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView time, name, rate, body;
        ImageView img, feedbackIcon;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.beneficiarieFeedbackTime);
            name = itemView.findViewById(R.id.beneficiarieName);
            rate = itemView.findViewById(R.id.feedbackRate);
            body = itemView.findViewById(R.id.feedbackBody);
            img = itemView.findViewById(R.id.beneficiarieFeedbackImage);
            feedbackIcon = itemView.findViewById(R.id.feedbackIcon);
            container = itemView.findViewById(R.id.reviewContainer);
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

