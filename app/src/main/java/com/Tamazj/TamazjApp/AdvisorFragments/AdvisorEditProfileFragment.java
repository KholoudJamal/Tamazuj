package com.Tamazj.TamazjApp.AdvisorFragments;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvisorEditProfileFragment extends BottomSheetDialogFragment {

    View view, viewDialog;
    ImageButton blueBack, editProfileImage, profileImage, dialogButtonCancel;
    TextView name, emailOriginal;
    Button approvalButton, buttonEditPassword;
    EditText fullName, email, phone, dialogOldPassword, dialogNewPassword, dialogConfirmPassword;
    TextView password, gender, nationality, birthDate, educationLevel, work, socialState;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_advisor_edit_profile, container, false);
        blueBack = view.findViewById(R.id.blueBack);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new AdvisorProfileFragment(), "HomeFragment").commit();
            }
        });

        profileImage = view.findViewById(R.id.profileImage);
        Picasso.with(getContext()).load(getURLForResource(R.drawable.imageprofile)).transform(new CropCircleTransformation()).into(profileImage);

        name = view.findViewById(R.id.tvFullNameProfile);
        emailOriginal = view.findViewById(R.id.tvEmailProfile);

        editProfileImage = view.findViewById(R.id.editProfileImage);
        editProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        fullName = view.findViewById(R.id.tvFullNameAdvisorEditProfile);
        email = view.findViewById(R.id.tvEmailAdvisorEditProfile);
        phone = view.findViewById(R.id.tvPhoneAdvisorEditProfile);

        password = view.findViewById(R.id.tvPasswordAdvisorEditProfile);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gender = view.findViewById(R.id.tvGenderAdvisorEditProfile);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(getFragmentManager(), getTag());
            }
        });
        nationality = view.findViewById(R.id.tvNationalityAdvisorEditProfile);
        nationality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        birthDate = view.findViewById(R.id.tvBirthDateAdvisorEditProfile);
        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        educationLevel = view.findViewById(R.id.tvLearningAdvisorEditProfile);
        educationLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        work = view.findViewById(R.id.tvJobAdvisorEditProfile);
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        socialState = view.findViewById(R.id.tvSocialStateAdvisorEditProfile);
        socialState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        approvalButton = view.findViewById(R.id.approvalButton);
        approvalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

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
