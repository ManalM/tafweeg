package com.example.rufaidah.tafweej;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChooseUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);
    }

    public void moror(View view) {
        Intent intent = new Intent(ChooseUser.this, Morurlog.class);
        startActivity(intent);

    }

    public void haj(View view) {
        Intent intent = new Intent(ChooseUser.this, Minslog.class);
        startActivity(intent);
    }

    public void mutf(View view) {
        Intent intent = new Intent(ChooseUser.this, mutawefs.class);
        startActivity(intent);
    }
}
