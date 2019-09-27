package com.Tamazj.TamazjApp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.Tamazj.TamazjApp.Model.Message;
import com.Tamazj.TamazjApp.Adapter.MessageAdapter;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

public class SessionActivity extends AppCompatActivity {

    List<Message> messages;
    MessageAdapter adapter;
    RecyclerView recyclerView;
    TextView tvSessionTime, tvSessionExtension;
    EditText editTextSessionMessage;
    ImageButton imageButtonSessionCamera, imageButtonSessionMicrophone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        tvSessionTime = findViewById(R.id.tvSessionTime);
        tvSessionExtension = findViewById(R.id.tvSessionExtension);
        recyclerView = findViewById(R.id.rvSession);
        editTextSessionMessage =  findViewById(R.id.editTextSessionMessage);
        imageButtonSessionCamera = findViewById(R.id.imageButtonSessionCamera);
        imageButtonSessionMicrophone = findViewById(R.id.imageButtonSessionMicrophone);

        messages = new ArrayList<>();
        messages.add(new Message(true));
        messages.add(new Message(false, true));
        adapter = new MessageAdapter(this, messages);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
