package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Adapter.PayWayAdapter;
import com.Tamazj.TamazjApp.Fragments.SuccessPayFragment;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

public class PayWayBottomDialog extends BottomSheetDialogFragment {

    View viewDialog;
    ImageButton dialogButtonCancel;
    RecyclerView recyclerView;
    PayWayAdapter adapter;
    List<PayWayImage> list;
    String sessionType, cost;

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        viewDialog = View.inflate(getContext(), R.layout.edit_password_layout, null);
        dialog.setContentView(viewDialog);

        dialogButtonCancel =  viewDialog.findViewById(R.id.buttonCancel);
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Bundle bundle = getArguments();
        if(bundle!= null && bundle.getString(AppConstants.SESSION_TYPE) != null){
            sessionType = bundle.getString(AppConstants.SESSION_TYPE);
        }

        switch (sessionType){
            case AppConstants.FIRST_SESSION:
                cost = getString(R.string.RS50);
                break;
            case AppConstants.SECOND_SESSION:
                cost = getString(R.string.RS100);
                break;
            case AppConstants.THIRD_SESSION:
                cost = getString(R.string.RS200);
                break;
            case AppConstants.SPECIAL_SESSION:
                cost = getString(R.string.RS500);
                break;
        }

        recyclerView = viewDialog.findViewById(R.id.rvPayWay);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add(new PayWayImage(R.drawable.sadaapayment));
        list.add(new PayWayImage(R.drawable.mada));
        list.add(new PayWayImage(R.drawable.bank));
        list.add(new PayWayImage(R.drawable.astesharttrbwwi));

        adapter = new PayWayAdapter(getContext(), list);
        adapter.setiClickListener(new PayWayAdapter.IClickListener() {
            @Override
            public void onItemClick(int position, PayWayImage payWayImage) {
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.SESSION_TYPE, sessionType);
                getFragmentManager().beginTransaction().replace(R.id.billContainer, new SuccessPayFragment(), "SuccessPayFragment").commit();
                dismiss();
            }
        });
        recyclerView.setAdapter(adapter);

    }

}
