package com.example.rahul.dbsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtName, txtSurName, txtMarks;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
        txtName = (EditText) findViewById(R.id.name);
        txtSurName = (EditText) findViewById(R.id.sname);
        txtMarks = (EditText) findViewById(R.id.marks);
        btnClick = (Button) findViewById(R.id.submit);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMe();
            }
        });
    }
    private void ClickMe() {
        String name = txtName.getText().toString();
        String surname = txtSurName.getText().toString();
        String marks = txtMarks.getText().toString();
        Boolean result = myDb.insertData(name, surname, marks);
        if (result == true) {
            txtName.setText("");
            txtSurName.setText("");
            txtMarks.setText("");
            Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,FirstScreen.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Data Insertion Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
