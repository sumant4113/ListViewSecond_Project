package com.example.listviewsecondproject;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listviewsecondproject.modules.Food;
import com.example.listviewsecondproject.modules.FoodAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFood;
    private ArrayList<Food> foodArrayList = new ArrayList<>();

    private static final String TAG = "MainActivity";
    private FoodAdapter foodAdapter;
    private Toolbar toolbar;

    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        btnClick = findViewById(R.id.btn_click);
        setSupportActionBar(toolbar);

        rvFood = findViewById(R.id.rv_food);

        foodArrayList.add(new Food(R.drawable.img_pizza1, "Peppy Paneer", "$10.99", "Chunky paneer with crisp capsicum and spicy red pepper"));
        foodArrayList.add(new Food(R.drawable.img_pizza2, "Mexican Green Wave", "$39.99", "A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes"));
        foodArrayList.add(new Food(R.drawable.img_pizza3, "Fresh Farm House", "$13.99", "crisp capsicum, succulent mushrooms and fresh tomatoes"));
        foodArrayList.add(new Food(R.drawable.img_pizza4, "Paneer Fresh ", "$5.99", "A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes"));
        foodArrayList.add(new Food(R.drawable.img_pizza5, "Veggie Pizza", "$5.99", "Chunky paneer with crisp capsicum and spicy red pepper"));

        foodAdapter = new FoodAdapter(MainActivity.this, foodArrayList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        rvFood.setLayoutManager(layoutManager);
        rvFood.setAdapter(foodAdapter);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("https://www.youtube.com/watch?v=LKxMypKIclc&ab_channel=VyankateshBhandare");
                    mediaPlayer.setLooping(false);
                    mediaPlayer.prepare();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "onClick: ///***"+mediaPlayer);
                mediaPlayer.start();

                Toast.makeText(MainActivity.this, "sdlkhfg", Toast.LENGTH_SHORT).show();
            }
        });

    }

}