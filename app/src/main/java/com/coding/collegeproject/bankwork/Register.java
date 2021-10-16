package com.coding.collegeproject.bankwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
EditText id,password;
Button rgs;
String uid,passd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rgs=findViewById(R.id.registerbtn);
        id=findViewById(R.id.registerid);
        password=findViewById(R.id.registerpassword);
        rgs.setOnClickListener(v->{
            uid=id.getText().toString();
            passd=password.getText().toString();
            if(uid.isEmpty()||passd.length()!=6)
            {
                id.setError("CANNOT BE EMPTY");
                password.setError("LENGTH SHOULD BE 6");

                rgs.setEnabled(true);
            }
            else {
                DatabaseReference dataReference=FirebaseDatabase.getInstance().getReference("Users");
                dataReference.child(uid).setValue(passd+"");
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}