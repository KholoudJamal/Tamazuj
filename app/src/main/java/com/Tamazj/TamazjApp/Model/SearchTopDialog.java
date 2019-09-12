package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.Tamazj.TamazjApp.R;

public class SearchTopDialog extends BottomSheetDialogFragment {



    View viewDialog;
    Button buttonEditPassword;
    ImageButton dialogButtonCancel;
    EditText dialogOldPassword, dialogNewPassword, dialogConfirmPassword;

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        viewDialog = View.inflate(getContext(), R.layout.edit_password_layout, null);
        dialog.setContentView(viewDialog);

        dialogOldPassword = viewDialog.findViewById(R.id.oldPassword);
        dialogNewPassword = viewDialog.findViewById(R.id.newPassword);
        dialogConfirmPassword = viewDialog.findViewById(R.id.confirmPassword);
        dialogButtonCancel =  viewDialog.findViewById(R.id.buttonCancel);
        buttonEditPassword = viewDialog.findViewById(R.id.buttonEditPassword);

        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });

        buttonEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dialogOldPassword.getText().equals(null) || dialogOldPassword.getText().equals("")){
                    Toast.makeText(getContext(), ""+getString(R.string.oldPasswordRequired), Toast.LENGTH_SHORT).show();
                }  else if(dialogNewPassword.getText().equals(null) || dialogNewPassword.getText().equals("")){
                    Toast.makeText(getContext(), ""+getString(R.string.newPasswordRequired), Toast.LENGTH_SHORT).show();
                }  else if(dialogNewPassword.getText().equals(null) || dialogNewPassword.getText().equals("")){
                    Toast.makeText(getContext(), ""+getString(R.string.confirmPasswordRequired), Toast.LENGTH_SHORT).show();
                }  else if(!dialogOldPassword.getText().equals(dialogNewPassword.getText())){
                    Toast.makeText(getContext(), ""+getString(R.string.oldPasswordMatchesnewPassword), Toast.LENGTH_SHORT).show();
                }  else if(!dialogConfirmPassword.getText().equals(dialogNewPassword.getText())){
                    Toast.makeText(getContext(), ""+getString(R.string.confirmPasswordNotMatchesPassword), Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });


    }

}
