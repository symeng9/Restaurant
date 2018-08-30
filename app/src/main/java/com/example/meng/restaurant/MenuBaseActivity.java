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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.nio.Buffer;

public class MenuBaseActivity extends AppCompatActivity implements View.OnClickListener {
    DataBasefood myDB;

    Button Order1, OrderUpdate, OrderView;

    EditText editName,editID;

    RadioButton RadiobuttonFood1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_base);

        myDB = new DataBasefood(this);

        editID=findViewById(R.id.editTextUpdate);
        editName=findViewById(R.id.editTextname1);


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
            boolean inserted= myDB.InsertData(editName.getText().toString());
            if (inserted=true)
                Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();

        }

        if (view==OrderUpdate){
            boolean isUpdate = myDB.updateData(editID.getText().toString(),
                    editName.getText().toString());
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
                buffer.append("NAME : "+ res.getString(1)+"\n\n");

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

    public void UpdatedataFood(View view) {
        boolean checked=((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radioButton1:
                if (checked){
                    boolean inserted= myDB.InsertData(editName.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton2:
                if (checked){
                    boolean inserted= myDB.InsertData(editName.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton3:
                if (checked){
                    boolean inserted= myDB.InsertData(editName.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton4:
                if (checked){
                    boolean inserted= myDB.InsertData(editName.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton5:
                if (checked){
                    boolean inserted= myDB.InsertData(editName.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton6:
                if (checked){
                    boolean inserted= myDB.InsertData(editName.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
