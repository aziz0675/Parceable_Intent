package com.example.seryozniy_tema;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seryozniy_tema.Modul.Member;
import com.example.seryozniy_tema.Modul.User;

public class Second_activity extends AppCompatActivity {
    static final String TAG = Second_activity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }

    void initViews(){
        TextView tV_second = findViewById(R.id.tV_second);
        Button button_second = findViewById(R.id.button_second);
        button_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member = new Member(12,"Kilian");
                backToFinish(member);
            }
        });
        User user = getIntent().getParcelableExtra("Object");
        tV_second.setText(user.toString());
        Log.d(TAG,user.toString());
    }

    void backToFinish(Member member){
        Intent intent = new Intent();
        intent.putExtra("Object2",member);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}