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

    EditText editName, editSize1, editQuality1,
            editName2, editSize2, editQuality2,
            editName3, editSize3, editQuality3,
            editName4, editSize4, editQuality4,
            editName5, editSize5, editQuality5,
            editName6, editSize6, editQuality6,
            editID;

    RadioButton RadiobuttonFood1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_base);

        myDB = new DataBasefood(this);

        editID=findViewById(R.id.editTextUpdate);

        editName=findViewById(R.id.editTextname1);
        editSize1=findViewById(R.id.editTextquality1);
        editQuality1=findViewById(R.id.editTextSize1);

        editName2=findViewById(R.id.editTextname2);
        editSize2=findViewById(R.id.editTextquality2);
        editQuality2=findViewById(R.id.editTextSize2);

        editName3=findViewById(R.id.editTextname3);
        editSize3=findViewById(R.id.editTextquality3);
        editQuality3=findViewById(R.id.editTextSize3);

        editName4=findViewById(R.id.editTextname4);
        editSize4=findViewById(R.id.editTextquality4);
        editQuality4=findViewById(R.id.editTextSize4);

        editName5=findViewById(R.id.editTextname5);
        editSize5=findViewById(R.id.editTextquality5);
        editQuality5=findViewById(R.id.editTextSize5);

        editName6=findViewById(R.id.editTextname6);
        editSize6=findViewById(R.id.editTextquality6);
        editQuality6=findViewById(R.id.editTextSize6);

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
            boolean isUpdate = myDB.updateDataFood(editID.getText().toString(),
                    editName.getText().toString(),
                    editSize1.getText().toString(),
                    editQuality1.getText().toString());
            if (isUpdate==true)
                Toast.makeText(MenuBaseActivity.this, "Data updated",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MenuBaseActivity.this, "Data not updated",Toast.LENGTH_LONG).show();

        }

        if (view==OrderView){
            Cursor res = myDB.getAllDataFood();
            if (res.getCount()==0){
                //show some message
                showMessage("Error", "Nothing found");
            }

            StringBuffer buffer=new StringBuffer();
            while (res.moveToNext()){
                buffer.append("ID : "+ res.getString(0)+"\n");
                buffer.append("NAME : "+ res.getString(1)+"\n");
                buffer.append("SIZE : "+ res.getString(2)+"\n");
                buffer.append("QUALITY : "+ res.getString(3)+"\n\n");

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
                    boolean inserted= myDB.InsertDataFood(editName.getText().toString(), editSize1.getText().toString(), editQuality1.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton2:
                if (checked){
                    boolean inserted= myDB.InsertDataFood(editName2.getText().toString(), editSize2.getText().toString(), editQuality2.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton3:
                if (checked){
                    boolean inserted= myDB.InsertDataFood(editName3.getText().toString(), editSize3.getText().toString(), editQuality3.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton4:
                if (checked){
                    boolean inserted= myDB.InsertDataFood(editName4.getText().toString(), editSize4.getText().toString(), editQuality4.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton5:
                if (checked){
                    boolean inserted= myDB.InsertDataFood(editName5.getText().toString(), editSize5.getText().toString(), editQuality5.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.radioButton6:
                if (checked){
                    boolean inserted= myDB.InsertDataFood(editName6.getText().toString(), editSize6.getText().toString(), editQuality6.getText().toString());
                    if (inserted=true)
                        Toast.makeText(MenuBaseActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MenuBaseActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
