package com.example.rahul.dbsql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Show_data extends AppCompatActivity {
    DataBaseHelper mydb;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        mydb=new DataBaseHelper(this);
        r=(TextView)findViewById(R.id.idResult);
        Cursor res=mydb.getAllData();
        StringBuffer sb=new StringBuffer();
        if(res!=null && res.getCount()>0) {
            while (res.moveToNext()) {
                sb.append("ID: " + res.getString(0) + "\n");
                sb.append("NAME: " + res.getString(1) + "\n");
                sb.append("SurName: " + res.getString(2) + "\n");
                sb.append("Marks: " + res.getString(3) + "\n");
            }
            r.setText(sb.toString());
            Toast.makeText(this, "Data Retrieved Successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "No Data to Retrieve", Toast.LENGTH_SHORT).show();
        }
    }
}
