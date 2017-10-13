package com.example.rahul.dbsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends AppCompatActivity {
    Button a,s,u,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        a=(Button)findViewById(R.id.add);
        s=(Button)findViewById(R.id.show);
        u=(Button)findViewById(R.id.update);
        d=(Button)findViewById(R.id.delete);
        a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstScreen.this,MainActivity.class);
                startActivity(i);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstScreen.this,Show_data.class);
                startActivity(i);
            }
        });
        u.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstScreen.this,Update_data.class);
                startActivity(i);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstScreen.this,Delete_data.class);
                startActivity(i);
            }
        });
    }
}
