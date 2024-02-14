package com.example.listviewsecondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView txtName, txtMsg, txtMobileNo, txtLastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
    }

    private void initView() {

        txtName = findViewById(R.id.txt_name);
        txtMsg = findViewById(R.id.txt_msg);
        txtLastTime = findViewById(R.id.txt_lastTime);
        txtMobileNo = findViewById(R.id.txt_mobileNo);

        if (getIntent().getExtras() != null){
            String UserName = getIntent().getStringExtra("UserName");
            String LastMsg = getIntent().getStringExtra("LastMsg");
            String LastTime = getIntent().getStringExtra("LastTime");
            String UserMobileNo = getIntent().getStringExtra("UserMobileNo");


            txtName.setText(UserName);
            txtMsg.setText(LastMsg);
            txtLastTime.setText(LastTime);
            txtMobileNo.setText(UserMobileNo);

        }

    }
}