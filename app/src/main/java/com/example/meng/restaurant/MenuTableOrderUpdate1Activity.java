package com.example.meng.restaurant;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuTableOrderUpdate1Activity extends AppCompatActivity implements View.OnClickListener {
    DataBasefood mydb;
    Button OrderUpdate;
    EditText EditID, editName, editquality, editSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_table_order_update1);
        mydb = new DataBasefood(this);

        OrderUpdate = findViewById(R.id.bTableUpdate1);
        OrderUpdate.setOnClickListener(this);

        EditID=findViewById(R.id.editTextID);
        editName=findViewById(R.id.editTextname1);
        editquality=findViewById(R.id.editTextquality1);
        editSize=findViewById(R.id.editTextSize1);
    }

    @Override
    public void onClick(View v) {
        if (OrderUpdate==v){

        }
    }
}
