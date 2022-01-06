package com.example.seryozniy_tema;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.seryozniy_tema.Modul.Member;
import com.example.seryozniy_tema.Modul.User;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.toString();
    int LAUNCH_MODE = 1001;
    TextView tV_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    ActivityResultLauncher<Intent> optionalNamed = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        Member member = data.getParcelableExtra("Object2");
                        tV_main.setText(member.toString());
                    }
                }
            }
    );

    void initView(){
        tV_main = findViewById(R.id.tV_main);

        Button button_main = findViewById(R.id.button_main);
        button_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(22,"Dwayne Johnson");
                openPage(user);
                Log.d(TAG,user.toString());
            }
        });
    }
    void openPage(User user){
        Intent intent = new Intent(this,Second_activity.class);
        intent.putExtra("Object",user);
        optionalNamed.launch(intent);
    }
}