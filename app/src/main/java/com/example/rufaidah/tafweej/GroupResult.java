package com.example.rufaidah.tafweej;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class GroupResult extends AppCompatActivity {

    private DatabaseReference databaseReference;
    double eval;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_result);
        res= (TextView)findViewById(R.id.textView5);
    }

    @Override
    protected void onStart() {
        //String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        databaseReference = FirebaseDatabase.getInstance().getReference("Evaluate").child(SearchGroup.grid);
        super.onStart();
        // writing the query
        Query myTopPostsQuery = databaseReference;
        //attaching value event listener
        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //clearing the previous advertisemnet list


                //iterating through all the nodes
                for (DataSnapshot evaluateSnapshot : dataSnapshot.getChildren()) {
                    //getting adv


                    EvaluateResult evaluateResult = evaluateSnapshot.getValue(EvaluateResult.class);
                    eval = (evaluateResult.st1+evaluateResult.nd2+evaluateResult.rd3)/3;
                    res.setText(String.valueOf(eval));

                }

                // to reverse the order of the list , to make the last adv added the first item
                //Collections.reverse(advertisementsList);
                //creating adapter
                //AdvertisementViewList advAdapter = new AdvertisementViewList(MainActivity.this, advertisementsList);
                //attaching adapter to the listview
              //  if(null != lvAdv)
                    //lvAdv.setAdapter(advAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

}}
