package com.example.saket.foodchamp;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity
{
    TextView txtUser,txtPassword;
    EditText user,password;
    Button login,register;
    SQLiteDatabase db;
    Context context;
    // SharedPreferences preferences;
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getBaseContext();
        final DBHelper adapter=new DBHelper(getBaseContext());
        txtUser=(TextView)findViewById(R.id.lblUser);
        txtPassword=(TextView)findViewById(R.id.lblPassword);
        user=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.btn1);
        register=(Button)findViewById(R.id.btn2);
        //EditText txtEmail=(EditText)findViewById(R.id.email);
        /*EditText txtStreet=(EditText)findViewById(R.id.street);
        EditText txtPlace=(EditText)findViewById(R.id.place);*/

        mydb = new DBHelper(this);
        mydb.deleteTable();


        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final String Username = user.getText().toString();
                final String Password = password.getText().toString();

                mydb.insertContact(user.getText().toString(),password.getText().toString());
                Toast.makeText(getBaseContext(),"Done",Toast.LENGTH_LONG).show();

                ArrayList contactsList = adapter.getAllCotacts();
                Log.d("Contacts lis ","Contacts List "+contactsList.size());
                for(int i=0;i<contactsList.size();i++)
                {
                    Log.d("Contacts lis ","Contacts List "+contactsList.get(i));
                }
                user.setText(null);
                password.setText(null);
                user.requestFocus();
            }
        });
        login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                /*final String username=user.getText().toString();
                final String password=txtPassword.getText().toString();*/
                Cursor cursor;
                String a;
                ArrayList c = adapter.getAllCotacts();
                if(c.contains(user.getText().toString()))
                {
                    Toast.makeText(getBaseContext(), "accepted", Toast.LENGTH_LONG).show();
                    mydb.close();
                    Intent i = new Intent(context,Add_restaurent.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getBaseContext(), "Not accepted", Toast.LENGTH_LONG).show();
                }
                user.setText(null);
                password.setText(null);
                user.requestFocus();
                /*for(int i=0;i<c.size();i++)
                {
                    if([c==user.getText().toString())
                    {*/
                /*for (int i = 0; i < c.lastIndexOf(c); i++)
                {*/
                    /*if (c.toString().equals(user.getText().toString()) && c.toString().equals(password.getText().toString())) {
                        Toast.makeText(getBaseContext(), "accepted", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(getBaseContext(), "Not accepted", Toast.LENGTH_LONG).show();

                    user.setText(null);
                    password.setText(null);
                user.requestFocus();*/
                // }
                /*while(c==adapter.getData(cursor.))
                {
                    String c1=c.getString(2);
                    String c2=c.getString(3);

                    if(c1 == username)
                    {
                        if(c2 == password)
                        {
                            Toast.makeText(loginForm.this,
                                    "You are succesfully logged in.",
                                    Toast.LENGTH_LONG).show();

                            Intent myIntent = new Intent(view.getContext(), Menu.class);
                            startActivityForResult(myIntent, 0);
                        }
                        else
                        {
                            Toast.makeText(loginForm.this, "Incorrect password",Toast.LENGTH_LONG).show();
                        }
                        Intent myIntent = new Intent(view.getContext(), loginForm.class);
                        startActivityForResult(myIntent, 0);
                    }

                    else
                        Toast.makeText(loginForm.this, "Incorrect",Toast.LENGTH_LONG).show();
                }
*/
               /* mydb.close();
                Intent i = new Intent(context,Add_restaurent.class);
                startActivity(i);*/


            }

        });
    }
}
