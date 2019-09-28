package com.Tamazj.TamazjApp.Activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.Tamazj.TamazjApp.Adapter.BillDetailsAdapter;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.BillDetails;
import com.Tamazj.TamazjApp.Model.PayWayBottomDialog;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillActivity extends AppCompatActivity {

    ImageButton buttonCancel;
    Button pay;
    RecyclerView recyclerView;
    List<BillDetails> billDetails;
    BillDetailsAdapter adapter;
    String sessionType = AppConstants.FIRST_SESSION, consultType, timePeriod, cost;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        buttonCancel = findViewById(R.id.buttonBillCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        consultType = getString(R.string.family_consultane);

        recyclerView = findViewById(R.id.rvBill);

        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra(AppConstants.SESSION_TYPE) != null){
           sessionType = intent.getStringExtra(AppConstants.SESSION_TYPE);
        }

        if (intent != null && intent.getStringExtra(AppConstants.CONSULT_TYPE) != null){
            consultType = intent.getStringExtra(AppConstants.CONSULT_TYPE);
        }

        switch (sessionType){
            case AppConstants.FIRST_SESSION:
                timePeriod = getString(R.string.mint30);
                cost = getString(R.string.RS50);
                break;
            case AppConstants.SECOND_SESSION:
                timePeriod = getString(R.string.mint60);
                cost = getString(R.string.RS100);
                break;
            case AppConstants.THIRD_SESSION:
                timePeriod = getString(R.string.mint120);
                cost = getString(R.string.RS200);
                break;
            case AppConstants.SPECIAL_SESSION:
                timePeriod = getString(R.string.specialSession);
                cost = getString(R.string.RS500);
                break;
        }

        billDetails = new ArrayList<>();
        billDetails.add(new BillDetails(R.drawable.astaefatype,getString(R.string.consultType),consultType));
        billDetails.add(new BillDetails(R.drawable.time,getString(R.string.timePeriod),timePeriod));
        billDetails.add(new BillDetails(R.drawable.cost,getString(R.string.cost),cost));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BillDetailsAdapter(this, billDetails);
        recyclerView.setAdapter(adapter);

        pay = findViewById(R.id.buttonPayBill);
        pay .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayWayBottomDialog payWayBottomDialog = new PayWayBottomDialog();
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.SESSION_TYPE, sessionType);
                payWayBottomDialog.setArguments(bundle);
                payWayBottomDialog.show(getSupportFragmentManager(), payWayBottomDialog.getTag());
            }
        });

    }

}
