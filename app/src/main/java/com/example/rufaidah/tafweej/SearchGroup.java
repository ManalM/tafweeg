package com.example.rufaidah.tafweej;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SearchGroup extends AppCompatActivity  {

    EditText griid;
    static String grid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_group);
        griid = (EditText)findViewById(R.id.editText2);

    }

    public void search(View view) {
        grid = griid.getText().toString();
        Intent intent = new Intent(SearchGroup.this, GroupResult.class);
        startActivity(intent);
    }
}
