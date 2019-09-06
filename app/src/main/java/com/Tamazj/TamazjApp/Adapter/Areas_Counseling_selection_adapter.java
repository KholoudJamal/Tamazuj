package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Fragments.CategoriesdetailsFragment;
import com.Tamazj.TamazjApp.Fragments.CategorySelectionFragment;
import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Areas_Counseling_selection_adapter extends RecyclerView.Adapter<Areas_Counseling_selection_adapter.MyHolder>{

    private List<Areas_Counseling_Model> areas_counseling_models;
    private Context context;
    private LayoutInflater inflater;
    int pos;

    interface IClickListener{
        void onItemClick(int position, List<Areas_Counseling_Model> areas_counseling_models, View enable);
    }

    IClickListener iClickListener;

    public Areas_Counseling_selection_adapter(Context context, List<Areas_Counseling_Model> areas_counseling_models){
        this.areas_counseling_models = areas_counseling_models;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.category_selection_item,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    boolean isClickable;

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
       Picasso.with(context)
              .load(areas_counseling_models.get(position).getArea_counseling_image())
               .error(R.drawable.asteshartnafsi)

               .into(holder.area_counseling_image);

        holder.area_counseling_catogory.setText(areas_counseling_models.get(position).getArea_counseling_catogory());
        holder.cardViewConsult.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new CategoriesdetailsFragment(), "HomeFragment").commit();



    }
});

    }



    @Override
    public int getItemCount() { return areas_counseling_models.size(); }

    class MyHolder extends RecyclerView.ViewHolder  {

        ImageView area_counseling_image;
        TextView area_counseling_catogory;
        CardView cardViewConsult;

        public MyHolder(View itemView) {
            super(itemView);
            area_counseling_image = itemView.findViewById(R.id.area_counseling_image);
            area_counseling_catogory = itemView.findViewById(R.id.area_counseling);
            cardViewConsult=itemView.findViewById(R.id.cardViewConsult);


        }

    }
}
