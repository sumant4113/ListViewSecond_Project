package com.example.listviewsecondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listviewsecondproject.userdetails.UserAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvUser;
    private UserAdapter userAdapter;
    private ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        lvUser = findViewById(R.id.lv_user);

        userArrayList.add(new User("Nilkanth Sutariya", "How are you ?", "8:49 am", "+911234567890", R.drawable.img_profile4));
        userArrayList.add(new User("Meet Sabhadiya", "Good", "7:49 am", "+911234567890", R.drawable.img_profile2));
        userArrayList.add(new User("Jemin Vamja", "Happy BirthDay", "8:33 am", "+911234567890", R.drawable.img_profile5));
        userArrayList.add(new User("Jai bhai", "Duck You!!!", "8:23 am", "+911234567890", R.drawable.img_profile4));
        userArrayList.add(new User("Jainesh Goal", "Byyy", "5:19 am", "+911234567890", R.drawable.img_profile5));
        userArrayList.add(new User("Tripti ", "How are you ?", "9:49 am", "+911234567890", R.drawable.img_profile2));
        userArrayList.add(new User("Miya Bhai", "Hiii", "1:05 am", "+911234567890", R.drawable.img_profile5));
        userArrayList.add(new User("Somya Maam", "Exellent", "10:05 am", "+911234567890", R.drawable.img_profile4));

        userAdapter = new UserAdapter(MainActivity.this,userArrayList);
        lvUser.setAdapter(userAdapter);

        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = userArrayList.get(i);

                Intent intent = new Intent(MainActivity.this , DetailActivity.class);

                intent.putExtra("UserName",user.userName);
                intent.putExtra("LastMsg",user.userMsg);
                intent.putExtra("LastTime",user.lastTime);
                intent.putExtra("UserMobileNo",user.phoneNo);

                startActivity(intent);

            }
        });

    }

}