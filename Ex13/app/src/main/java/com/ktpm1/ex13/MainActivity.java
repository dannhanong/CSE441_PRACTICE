package com.ktpm1.ex13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String namephone[] = {"Điện thoại Iphone 12", "Điện thoại SamSung S20", "Điện thoại Nokia 6",
            "Điện thoại Bphone 2020", "Điện thoại Oppo 5", "Điện thoại VSmart joy2"};
    int imagephone[] = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

    ArrayList<phone> mylist;
    MyArrayAdapter myadapter; //Khai báo Adapter ListView lv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        for (int i = 0; i < namephone.length; i++) {
            mylist.add(new phone(namephone[i], imagephone[i]));
        }
        myadapter = new MyArrayAdapter(this, R.layout.layout_listview, mylist);
        lv.setAdapter(myadapter);
        lv.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(MainActivity.this,SubActivity.class);
                myintent.putExtra("name",namephone[position]); startActivity(myintent);
            }
        });
    }
}