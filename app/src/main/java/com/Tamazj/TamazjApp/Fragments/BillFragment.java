package com.Tamazj.TamazjApp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.Tamazj.TamazjApp.Adapter.BillDetailsAdapter;
import com.Tamazj.TamazjApp.Model.BillDetails;
import com.Tamazj.TamazjApp.Model.PayWayBottomDialog;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillFragment extends Fragment {

    View view;
    Button buttonCancel, pay;
    RecyclerView recyclerView;
    List<BillDetails> billDetails;
    BillDetailsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bill, container, false);

        buttonCancel = view.findViewById(R.id.buttonBillCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView = view.findViewById(R.id.rvBill);

        billDetails = new ArrayList<>();
        billDetails.add(new BillDetails(R.drawable.astaefatype,getString(R.string.consultType),getString(R.string.family_consultane)));
        billDetails.add(new BillDetails(R.drawable.time,getString(R.string.timePeriod),getString(R.string.mint30)));
        billDetails.add(new BillDetails(R.drawable.cost,getString(R.string.cost),getString(R.string.RS50)));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BillDetailsAdapter(getContext(), billDetails);
        recyclerView.setAdapter(adapter);

        pay = view.findViewById(R.id.buttonPayBill);
        pay .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayWayBottomDialog payWayBottomDialog = new PayWayBottomDialog();
                payWayBottomDialog.show(getFragmentManager(), payWayBottomDialog.getTag());
            }
        });

        return view;
    }

}
