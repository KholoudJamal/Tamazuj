package com.Tamazj.TamazjApp.Model;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;

public class SpinnerDialog extends Dialog {
        private ArrayList<String> mList;
        private Context mContext;
        private Spinner mSpinner;

        public interface DialogListener {
            public void ready(int n);
            public void cancelled();
        }

        private DialogListener mReadyListener;

        public SpinnerDialog(Context context, ArrayList<String> list, DialogListener readyListener) {
            super(context);
            mReadyListener = readyListener;
            mContext = context;
            mList = list;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.education_spinner_dialog);
            mSpinner =  findViewById (R.id.nice_spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<String> (mContext, android.R.layout.simple_spinner_dropdown_item, mList);
            mSpinner.setAdapter(adapter);



    }


}
