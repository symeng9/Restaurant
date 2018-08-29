package com.example.meng.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableOrderActivity extends AppCompatActivity implements View.OnClickListener {

    Button Table1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_order);

        Table1=findViewById(R.id.bTable1);
        Table1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (Table1==v){
            Intent intent= new Intent(this, MenuBaseActivity.class);
            startActivity(intent);
        }
    }
}
