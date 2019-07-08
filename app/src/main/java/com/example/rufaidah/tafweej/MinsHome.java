package com.example.rufaidah.tafweej;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MinsHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mins_home);
    }

    public void search(View view) {
        Intent intent = new Intent(MinsHome.this, SearchGroup.class);
        startActivity(intent);

    }

    public void statics(View view) {
        Intent intent = new Intent(MinsHome.this, staticActivity.class);
        startActivity(intent);

    }
}
