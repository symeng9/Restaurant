package com.example.meng.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableOrderUpdate1Activity extends AppCompatActivity implements View.OnClickListener {
    Button TableUpdate1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_order_update1);

        TableUpdate1=findViewById(R.id.bTableUpdate1);
        TableUpdate1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v== TableUpdate1){
            Intent intent = new Intent(this, MenuTableOrderUpdate1Activity.class);
            startActivity(intent);
        }
    }
}
