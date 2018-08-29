package com.example.meng.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Order, OrderUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Order=findViewById(R.id.bOrderfirst);
        Order.setOnClickListener(this);

        OrderUpdate=findViewById(R.id.bOrderUpdate);
        OrderUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view==Order){
            Intent i = new Intent(this, TableOrderActivity.class);
            startActivity(i);
        }

        if (view==OrderUpdate){
            Intent i = new Intent(this, TableOrderUpdate1Activity.class);
            startActivity(i);
        }
    }
}
