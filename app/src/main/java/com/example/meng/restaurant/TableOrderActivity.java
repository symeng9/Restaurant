package com.example.meng.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TableOrderActivity extends AppCompatActivity implements View.OnClickListener {

    DataBasefood myDB;

    Button Table1, Table2, Table3, Table4, Table5, Table6;

    EditText EditTable1, EditTable2, EditTable3, EditTable4, EditTable5, EditTable6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_order);

        Table1=findViewById(R.id.bTable1);
        Table2=findViewById(R.id.bTable2);
        Table3=findViewById(R.id.bTable3);
        Table4=findViewById(R.id.bTable4);
        Table5=findViewById(R.id.bTable5);
        Table6=findViewById(R.id.bTable6);

        Table1.setOnClickListener(this);
        Table2.setOnClickListener(this);
        Table3.setOnClickListener(this);
        Table4.setOnClickListener(this);
        Table5.setOnClickListener(this);
        Table6.setOnClickListener(this);

        EditTable1=findViewById(R.id.editText1);
        EditTable2=findViewById(R.id.editText2);
        EditTable3=findViewById(R.id.editText3);
        EditTable4=findViewById(R.id.editText4);
        EditTable5=findViewById(R.id.editText5);
        EditTable6=findViewById(R.id.editText6);

        myDB = new DataBasefood(this);

    }

    @Override
    public void onClick(View v) {
        if (Table1==v){
            Intent intent= new Intent(this, MenuBaseActivity.class);
            startActivity(intent);

            boolean inserted= myDB.InsertData(EditTable1.getText().toString());
            if (inserted=true)
                Toast.makeText(TableOrderActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(TableOrderActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
        }

        if (Table2==v){
            Intent intent= new Intent(this, MenuBaseActivity.class);
            startActivity(intent);

            boolean inserted= myDB.InsertData(EditTable2.getText().toString());
            if (inserted=true)
                Toast.makeText(TableOrderActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(TableOrderActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
        }

        if (Table3==v){
            Intent intent= new Intent(this, MenuBaseActivity.class);
            startActivity(intent);

            boolean inserted= myDB.InsertData(EditTable3.getText().toString());
            if (inserted=true)
                Toast.makeText(TableOrderActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(TableOrderActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
        }

        if (Table4==v){
            Intent intent= new Intent(this, MenuBaseActivity.class);
            startActivity(intent);

            boolean inserted= myDB.InsertData(EditTable4.getText().toString());
            if (inserted=true)
                Toast.makeText(TableOrderActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(TableOrderActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
        }

        if (Table5==v){
            Intent intent= new Intent(this, MenuBaseActivity.class);
            startActivity(intent);

            boolean inserted= myDB.InsertData(EditTable5.getText().toString());
            if (inserted=true)
                Toast.makeText(TableOrderActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(TableOrderActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
        }

        if (Table6==v){
            Intent intent= new Intent(this, MenuBaseActivity.class);
            startActivity(intent);

            boolean inserted= myDB.InsertData(EditTable6.getText().toString());
            if (inserted=true)
                Toast.makeText(TableOrderActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(TableOrderActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
        }
    }
}
