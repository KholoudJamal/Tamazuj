package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Activity.BillActivity;
import com.Tamazj.TamazjApp.Adapter.TextViewAdapter;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

public class AdvisoeDeailsBottomDialog extends BottomSheetDialogFragment {

    View viewDialog;
    TextView tvRatePercent, tvAdvisorName, tvAdvisorDescription, firstSession, secondSession, thirdSession, specialSession;
    ImageButton dialogButtonCancel, profileImage, firstSessionButton, secondSessionButton, thirdSessionButton, specialSessionButton;
    RecyclerView rvConsults;
    List<String> list;
    TextViewAdapter textViewAdapter;
    String consultType;

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        viewDialog = View.inflate(getContext(), R.layout.advisor_details_layout, null);
        dialog.setContentView(viewDialog);

        dialogButtonCancel =  viewDialog.findViewById(R.id.buttonCancel);
        tvRatePercent =  viewDialog.findViewById(R.id.tvRatePercent);
        tvAdvisorName =  viewDialog.findViewById(R.id.tvAdvisorName);
        tvAdvisorDescription =  viewDialog.findViewById(R.id.tvAdvisorDescription);
        profileImage =  viewDialog.findViewById(R.id.profileImage);
        rvConsults =  viewDialog.findViewById(R.id.rvConsults);
        firstSession = viewDialog.findViewById(R.id.firstSession);
        secondSession = viewDialog.findViewById(R.id.secondSession);
        thirdSession = viewDialog.findViewById(R.id.thirdSession);
        specialSession = viewDialog.findViewById(R.id.specialSession);
        firstSessionButton = viewDialog.findViewById(R.id.firstSessionButton);
        secondSessionButton = viewDialog.findViewById(R.id.secondSessionButton);
        thirdSessionButton = viewDialog.findViewById(R.id.thirdSessionButton);
        specialSessionButton = viewDialog.findViewById(R.id.specialSessionButton);
        list = new ArrayList<String>();
        list.add(getString(R.string.family_consultane));
        list.add(getString(R.string.family_consultane));
        list.add(getString(R.string.family_consultane));
        textViewAdapter = new TextViewAdapter(getContext(), list);
        textViewAdapter.setiClickListener(new TextViewAdapter.IClickListener() {
            @Override
            public void onItemClick(int position, String text) {
                consultType = text;
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvConsults.setLayoutManager(layoutManager);
        rvConsults.setAdapter(textViewAdapter);




        final Intent intent = new Intent(getActivity(), BillActivity.class);

        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        firstSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(AppConstants.SESSION_TYPE, AppConstants.FIRST_SESSION);
                intent.putExtra(AppConstants.CONSULT_TYPE, consultType);
                startActivity(intent);
            }
        });

        secondSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(AppConstants.SESSION_TYPE, AppConstants.SECOND_SESSION);
                intent.putExtra(AppConstants.CONSULT_TYPE, consultType);
                startActivity(intent);
            }
        });

        thirdSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(AppConstants.SESSION_TYPE, AppConstants.THIRD_SESSION);
                intent.putExtra(AppConstants.CONSULT_TYPE, consultType);
                startActivity(intent);
            }
        });

        specialSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(AppConstants.SESSION_TYPE, AppConstants.SPECIAL_SESSION);
                intent.putExtra(AppConstants.CONSULT_TYPE, consultType);
                startActivity(intent);
            }
        });


    }

}
