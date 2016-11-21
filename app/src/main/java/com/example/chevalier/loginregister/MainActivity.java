package com.example.chevalier.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button login, not_reg;
    DataBAseHandler db;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user =(EditText)findViewById(R.id.eduser);
        pass = (EditText)findViewById(R.id.edpass);
        login =(Button)findViewById(R.id.login);
        not_reg =(Button)findViewById(R.id.not_reg);

        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                db=new DataBAseHandler(MainActivity.this, null, null, 2);
                String username=user.getText().toString();
                String password= pass.getText().toString();

                String StoredPassword =db.getregister(username);
                if(password.equals(StoredPassword)){

                    Toast.makeText(getApplicationContext(), StoredPassword+"Login Successfully", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    user.setText("");
                    pass.setText("");
                }


            }
        });

        not_reg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });





    }
}
