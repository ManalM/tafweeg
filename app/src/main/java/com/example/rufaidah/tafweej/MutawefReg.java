package com.example.rufaidah.tafweej;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MutawefReg extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private EditText grname, onname, grid, gemail, gpass, gmobile;
    private ImageButton reg;
    private ProgressDialog progressDialog;


    static String text2Qr;

    public MutawefReg() {
    }

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutawef_reg);
        grname = (EditText) findViewById(R.id.gname);
        gmobile = (EditText) findViewById(R.id.mobile);
        onname = (EditText) findViewById(R.id.onname);
        grid = (EditText) findViewById(R.id.gid);
        gemail = (EditText) findViewById(R.id.gemail);
        gpass = (EditText) findViewById(R.id.gpass);
        reg = (ImageButton) findViewById(R.id.reg);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();




    }

    // function to register user
    private void registerUser() {
        String email = gemail.getText().toString().trim();
        String password = gpass.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        final Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            //display some message here
                            Toast.makeText(MutawefReg.this, " ", Toast.LENGTH_LONG).show();
                            // to view welcome image
                            LayoutInflater inflater = getLayoutInflater();
                            Toast toast = new Toast(MutawefReg.this);
                            // call the method to save information
                            registerUserInfo();
                            // move to homePage

                        } else {
                            //display some message here
                            Toast.makeText(MutawefReg.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });


    }

    private void registerUserInfo() {
        String email = gemail.getText().toString().trim();
        String password = gpass.getText().toString().trim();
        String gname = grname.getText().toString().trim();
        String gid = grid.getText().toString().trim();
        String goname = onname.getText().toString().trim();
        String mobile = gmobile.getText().toString().trim();
        text2Qr = gid;

        FirebaseUser user = firebaseAuth.getCurrentUser();
       String userid = user.getUid().toString();

        //create object of UserInformation.java class to store the information
        UserInformation userInformation = new UserInformation(userid, gid, email, goname, gname, password, mobile);

        //pass values to database
        databaseReference.child("Groups").child(user.getUid()).setValue(userInformation);

        Toast.makeText(this, "Information saved ...", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MutawefReg.this, MutawfSelect.class);
        startActivity(intent);

    }



    @Override
    public void onClick(View view) {
        if (view == reg) {
             registerUser();
    }

    }

    public void reg(View view) {
        registerUser();
    }
}
