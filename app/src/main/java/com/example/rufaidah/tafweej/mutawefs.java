package com.example.rufaidah.tafweej;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class mutawefs extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutawefs);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        // initializing the necessary widgets from the layout
        email = (EditText) findViewById(R.id.gid);
        password = (EditText) findViewById(R.id.gen);
        progressDialog = new ProgressDialog(this);
    }

    public void login(View view) {
            //initializing progress dialog
            progressDialog.setMessage("Loging in Please Wait...");
            progressDialog.show();
            // method uesd to signin, pass over it the email and password
            firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                // attach complete listener
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        // to shaw welcome photo

                        Intent intent = new Intent(mutawefs.this, MutawefHome.class);
                        startActivity(intent);

                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(mutawefs.this, "Wrong Email or Password ", Toast.LENGTH_LONG).show();
                    }
                }

            });

        }



    public void reg(View view) {
        Intent intent = new Intent(mutawefs.this, MutawefReg.class);
        startActivity(intent);
    }
}
