package com.example.sqlitedemo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddActivity extends Activity {
    EditText etName, etCourse;
    Button btn_add, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etName = (EditText) findViewById(R.id.etName);
        etCourse = (EditText) findViewById(R.id.etCourse);

        btn_add = findViewById(R.id.btn_add);
        btn_back = findViewById(R.id.btn_back);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAdd(v);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doBack(v);
            }
        });

    }

    public void doAdd(View v){
        String name = etName.getText().toString();
        String course = etCourse.getText().toString();
        DBase db = new DBase(this);
        db.open();
        db.add(name, course);
        db.close();

        Dialog d = new Dialog(this);
        d.setTitle("Message");
        TextView tv = new TextView(this);
        tv.setText(name+" has been added");
        d.setContentView(tv);
        d.show();
    }

    public void doBack(View v){
        finish();
    }


}
