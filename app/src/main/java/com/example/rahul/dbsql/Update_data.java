package com.example.rahul.dbsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_data extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtid,txtName, txtSurName, txtMarks;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        myDb = new DataBaseHelper(this);
        txtid = (EditText) findViewById(R.id.u_id);
        txtName = (EditText) findViewById(R.id.u_name);
        txtSurName = (EditText) findViewById(R.id.u_sname);
        txtMarks = (EditText) findViewById(R.id.u_marks);
        btnClick = (Button) findViewById(R.id.u_submit);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMe();
            }
        });
    }
    private void ClickMe() {
        String id=txtid.getText().toString();
        String name = txtName.getText().toString();
        String surname = txtSurName.getText().toString();
        String marks = txtMarks.getText().toString();
        Boolean result = myDb.updateData(id,name, surname, marks);
        if (result == true) {
            txtName.setText("");
            txtSurName.setText("");
            txtMarks.setText("");
            Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Update_data.this,FirstScreen.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "No Rows Affected", Toast.LENGTH_SHORT).show();
        }
    }
}
