package com.example.rahul.dbsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_data extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtid;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        myDb = new DataBaseHelper(this);
        txtid=(EditText)findViewById(R.id.d_id);
        btnClick=(Button)findViewById(R.id.d_submit);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMe();
            }
        });
    }
    private void ClickMe()
    {
        String id=txtid.getText().toString();
        int result=myDb.deleteData(id);
        txtid.setText("");
        Toast.makeText(this, result+" :Row Affected", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Delete_data.this,FirstScreen.class);
        startActivity(i);
    }
}
