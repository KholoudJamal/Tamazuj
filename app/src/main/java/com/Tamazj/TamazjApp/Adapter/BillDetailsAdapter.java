package com.Tamazj.TamazjApp.Adapter;

import android.content.Context;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.BillDetails;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BillDetailsAdapter extends RecyclerView.Adapter<BillDetailsAdapter.MyHolder> {

    MyHolder holder;

    private final List<BillDetails> billDetails;
    final Context context;
    private LayoutInflater inflater;
    public BillDetailsAdapter(Context context, List<BillDetails> billDetails){
        this.billDetails = billDetails;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bill_details_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        this.holder = holder;
        if (!(billDetails.isEmpty())) {
            holder.details.setText(billDetails.get(position).getBillDetail());
            holder.supDetails.setText(billDetails.get(position).getSupBillDetail());
            Picasso.with(context).load(getURLForResource(billDetails.get(position).getIcon())).into(holder.img);
        }
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    public int getItemCount() {
        return billDetails.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView details, supDetails;
        ImageView img;
        ViewGroup container;

        public MyHolder(View itemView) {
            super(itemView);
            details = itemView.findViewById(R.id.tvBillDetails);
            supDetails = itemView.findViewById(R.id.tvBillSupDetails);
            img = itemView.findViewById(R.id.billDetailsIcon);
            container = itemView.findViewById(R.id.cardViewBillDetails);
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
