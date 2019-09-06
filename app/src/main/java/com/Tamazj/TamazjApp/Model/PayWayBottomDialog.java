package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;
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
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

public class PayWayBottomDialog extends BottomSheetDialogFragment {

    View viewDialog;
    ImageButton dialogButtonCancel;
    RecyclerView recyclerView;
    PayWayAdapter adapter;
    List<PayWayImage> list;

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

        recyclerView = viewDialog.findViewById(R.id.rvPayWay);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add(new PayWayImage(R.drawable.sadaapayment));
        list.add(new PayWayImage(R.drawable.mada));
        list.add(new PayWayImage(R.drawable.bank));
        list.add(new PayWayImage(R.drawable.astesharttrbwwi));

        adapter = new PayWayAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);

    }

}
