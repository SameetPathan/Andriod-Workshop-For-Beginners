package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText Name;
    Button Add,Delete,Display;
    String NameHolder,Query;
    TextView Data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.name);
        Add=findViewById(R.id.add);
        Delete=findViewById(R.id.delete);
        Display=findViewById(R.id.display);
        Data=findViewById(R.id.data);

        database=openOrCreateDatabase("StudentName.db", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING,null);
        database.setLocale(Locale.getDefault());
        database.setVersion(1);
        database.execSQL("CREATE TABLE IF NOT EXISTS USERR(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR);");

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NameHolder = Name.getText().toString();
                Query = "INSERT INTO USERR (name) VALUES ('" + NameHolder + "')";
                database.execSQL(Query);
                Toast.makeText(MainActivity.this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.delete("USERR","name=?",new String[]{Name.getText().toString()});
                Toast.makeText(MainActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur=database.query("USERR",null,null,null,
                        null,null,null);
                cur.moveToFirst();
                while (cur.isAfterLast()==false)
                {
                    Data.append("Name == "+cur.getString(1)+"\n");
                    cur.moveToNext();
                }
                cur.close();
            }
        });





    }
}