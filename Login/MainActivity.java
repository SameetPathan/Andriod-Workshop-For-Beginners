package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login=(Button) findViewById(R.id.login);
        EditText username=(EditText) findViewById(R.id.username);
        EditText password=(EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String USERNAME=username.getText().toString();
                String PASSWORD=password.getText().toString();
                if(USERNAME.equals("ABC1") && PASSWORD.equals("ABC1") ){
                    Toast.makeText(MainActivity.this,USERNAME+" -"+PASSWORD+"Login",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Please Check Your UserName And Password ",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}