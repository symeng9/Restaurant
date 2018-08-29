package com.example.meng.restaurant;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.nio.Buffer;

public class MenuBaseActivity extends AppCompatActivity implements View.OnClickListener {
    DataBasefood myDB;

    Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6,
            spinner7, spinner8, spinner9, spinner10, spinner11, spinner12;
    ArrayAdapter<CharSequence> adapter, adapter1, adapter3, adapter4, adapte5, adapter6,
            adapter7, adapter8, adapter9, adapter10, adapte11, adapter12;
    Button reciept, Order1, OrderUpdate, OrderView;

    EditText editName, editquality, editSize, editID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_base);

        myDB = new DataBasefood(this);

        editName=findViewById(R.id.editTextname1);
        editquality=findViewById(R.id.editTextquality1);
        editSize=findViewById(R.id.editTextSize1);
        editID=findViewById(R.id.editTextUpdate);

        Order1=findViewById(R.id.bOrder);
        Order1.setOnClickListener(this);

        OrderUpdate=findViewById(R.id.bOrderUpdate);
        OrderUpdate.setOnClickListener(this);

        OrderView=findViewById(R.id.bOrderView1);
        OrderView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view==Order1){
            boolean inserted= myDB.InsertData(editName.getText().toString(),
                    editquality.getText().toString(),
                    editSize.getText().toString());
            if (inserted=true)
                Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();

        }

        if (view==OrderUpdate){
            boolean isUpdate = myDB.updateData(editID.getText().toString(),
                    editName.getText().toString(),
                    editquality.getText().toString(), editSize.getText().toString());
            if (isUpdate==true)
                Toast.makeText(MenuBaseActivity.this, "Data updated",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MenuBaseActivity.this, "Data not updated",Toast.LENGTH_LONG).show();

        }

        if (view==OrderView){
            Cursor res = myDB.getAllData();
            if (res.getCount()==0){
                //show some message
                showMessage("Error", "Nothing found");
            }

            StringBuffer buffer=new StringBuffer();
            while (res.moveToNext()){
                buffer.append("ID : "+ res.getString(0)+"\n");
                buffer.append("NAME : "+ res.getString(1)+"\n");
                buffer.append("QUALITY : "+ res.getString(2)+"\n");
                buffer.append("SIZE : "+ res.getString(3)+"\n\n");

            }

            showMessage("Data", buffer.toString());
        }
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
