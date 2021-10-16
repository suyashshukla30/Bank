package com.coding.collegeproject.bankwork;

import static android.widget.Toast.LENGTH_LONG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
Button lgn;
TextView newuser;
EditText id,password;
String uid,passd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newuser=findViewById(R.id.newregister);
        lgn=findViewById(R.id.login);
        id=findViewById(R.id.uniqueidlgn);
        password=findViewById(R.id.lgnpassword);
        newuser.setOnClickListener(v->{
            Intent intent=new Intent(this,Register.class);
            startActivity(intent);
        });
        lgn.setOnClickListener(v->{
            uid=id.getText().toString();
            passd=password.getText().toString();
            if(uid.isEmpty()){
                id.setError("SHOULD NOT BE EMPTY");
                lgn.setEnabled(true);
            }
            else if(passd.length()!=6){
                password.setError("LENGTH SHOULD BE 6");
            }
            else{
                DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference("Users");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot datasnapshot:snapshot.getChildren()){
                            String Key=datasnapshot.getKey();
                            if(Key.equals(uid)){
                                String psd=datasnapshot.getValue().toString();
                                if(psd.equals(passd)){
                                    Intent intent=new Intent(MainActivity.this,Homepage.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Wrong password/Username",LENGTH_LONG).show();
                                }
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}