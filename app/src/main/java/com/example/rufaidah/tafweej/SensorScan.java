package com.example.rufaidah.tafweej;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SensorScan extends AppCompatActivity {

    static String grid ;
    EditText gid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_scan);

        gid = (EditText)findViewById(R.id.editText);
    }

    public void scan(View view) {
        grid = gid.getText().toString();
        Intent intent = new Intent(SensorScan.this, qrresult.class);
        startActivity(intent);
    }
}
