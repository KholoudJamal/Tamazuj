package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.Model.Categories;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyHolder>{

    private List<Categories> categories;
    private Context context;
    private LayoutInflater inflater;
    int pos;

    interface IClickListener{
        void onItemClick(int position,List<Areas_Counseling_Model> areas_counseling_models, View enable);
    }

    Areas_Counseling_adapter.IClickListener iClickListener;

    public CategoriesAdapter(Context context, List<Categories> categories){
        this.categories = categories;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CategoriesAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.categoriesdetailsitem,parent,false);
        CategoriesAdapter.MyHolder holder = new CategoriesAdapter.MyHolder(view);
        return holder;
    }

    boolean isClickable;

    @Override
    public void onBindViewHolder(@NonNull final CategoriesAdapter.MyHolder holder, final int position) {
        Picasso.with(context)
                .load(categories.get(position).getProfileimage())
                .error(R.drawable.image)

                .into(holder.profileimage);

        holder.percent.setText(categories.get(position).getPercent());
        holder.profile_dsc.setText(categories.get(position).getProfile_dsc());
        holder.profile_name.setText(categories.get(position).getProfile_name());
        holder.catoroytype.setText(categories.get(position).getCatoroytype());


    }



    @Override
    public int getItemCount() { return
            categories.size(); }

    class MyHolder extends RecyclerView.ViewHolder  {

        ImageView profileimage;
        TextView percent;
        TextView profile_name;
        TextView profile_dsc;
        TextView catoroytype;


        public MyHolder(View itemView) {
            super(itemView);
            percent = itemView.findViewById(R.id.percent);
            profileimage = itemView.findViewById(R.id.profileimage);
            profile_name = itemView.findViewById(R.id.profile_name);
            profile_dsc = itemView.findViewById(R.id.profile_dsc);
            catoroytype = itemView.findViewById(R.id.catoroytype);



        }

    }
}

