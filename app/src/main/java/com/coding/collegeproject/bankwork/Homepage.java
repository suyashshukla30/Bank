package com.coding.collegeproject.bankwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    CardView cryptocard;
   Button cryptocurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        cryptocard=findViewById(R.id.tocryptodt);
        cryptocurrency=findViewById(R.id.cryptobtn);
        cryptocard.setOnClickListener(v->{
            Intent intent=new Intent(this,cryptofunds.class);
            startActivity(intent);
        });
        cryptocurrency.setOnClickListener(v->{
            Intent intent=new Intent(this,cryptofunds.class);
            startActivity(intent);
        });
    }
}