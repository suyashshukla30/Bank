package com.coding.collegeproject.bankwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class cryptofunds extends AppCompatActivity {
Dialog add;
Button dataadding,submit;
EditText cname;
EditText bprice;
EditText sprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptofunds);
        dataadding=findViewById(R.id.addfunddata);


       dataadding.setOnClickListener(v->{
            add.show();
        });
        adddatadialog();
    }

    private void adddatadialog() {
        add=new Dialog(this);
        add.setContentView(R.layout.cryptocard);
        add.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        add.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT,Toolbar.LayoutParams.MATCH_PARENT);
        add.getWindow().getAttributes().gravity= Gravity.TOP;

    }

}