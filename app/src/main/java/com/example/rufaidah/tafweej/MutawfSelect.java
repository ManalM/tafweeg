package com.example.rufaidah.tafweej;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MutawfSelect extends AppCompatActivity {
    ImageView img;
    CheckBox c1, c2, c3 , c4;
    String text2Qr ;
    private FirebaseAuth firebaseAuth;
    FirebaseUser user;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutawf_select);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        String userid = user.getUid().toString();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        c3 = (CheckBox) findViewById(R.id.c2);
        c4 = (CheckBox) findViewById(R.id.c4);


        text2Qr = MutawefReg.text2Qr;
        img = (ImageView) findViewById(R.id.iog);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            img.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    public void save(View view) {
        if(c1.isSelected()){
        SelectTime selectTime = new SelectTime(1,0,0,0);
        databaseReference.child("SelectTime").child(user.getUid()).setValue(selectTime);
        }
        if(c2.isSelected()){
            SelectTime selectTime = new SelectTime(0,1,0,0);
            databaseReference.child("SelectTime").child(user.getUid()).setValue(selectTime);
        }
        if(c3.isChecked()){
            SelectTime selectTime = new SelectTime(0,0,1,0);
            databaseReference.child("SelectTime").child(user.getUid()).setValue(selectTime);
        }
        if(c4.isChecked()){
            SelectTime selectTime = new SelectTime(0,0,0,1);
            databaseReference.child("SelectTime").child(user.getUid()).setValue(selectTime);
        }
    }
}
