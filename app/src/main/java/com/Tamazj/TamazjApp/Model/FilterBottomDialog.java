package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.R;

public class FilterBottomDialog extends BottomSheetDialogFragment {

    View viewDialog;
    ImageButton dialogButtonCancel;
    TextView dialogstatus, dialogpercent_satfication, dialogcost,tvSave;

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        viewDialog = View.inflate(getContext(), R.layout.filter_item, null);
        dialog.setContentView(viewDialog);

        dialogstatus = viewDialog.findViewById(R.id.status);
        dialogpercent_satfication = viewDialog.findViewById(R.id.percent_satfication);
        dialogcost= viewDialog.findViewById(R.id.cost);
        dialogButtonCancel =  viewDialog.findViewById(R.id.buttonCancel);
        tvSave=viewDialog.findViewById(R.id.tvSave);
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });



    }

}
