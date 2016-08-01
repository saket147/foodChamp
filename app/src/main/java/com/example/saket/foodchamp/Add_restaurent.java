package com.example.saket.foodchamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_restaurent extends AppCompatActivity
{
    DBHelper mydb;
    TextView name,description,address,branch,email;
    EditText tname,tdescription,taddress,tbranch,temail;
    Button details;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurent);
        final DBHelper adapter=new DBHelper(getBaseContext());
        name=(TextView)findViewById(R.id.restaurentName);
        description=(TextView)findViewById(R.id.editDescription);
        address=(TextView)findViewById(R.id.editAddress);
        branch=(TextView)findViewById(R.id.editBranch);
        email=(TextView)findViewById(R.id.editEmail);
        tname=(EditText)findViewById(R.id.editRestaurentName);
        tdescription=(EditText)findViewById(R.id.editDescription);
        taddress=(EditText)findViewById(R.id.editAddress);
        tbranch=(EditText)findViewById(R.id.editBranch);
        temail=(EditText)findViewById(R.id.editEmail);
        details=(Button)findViewById(R.id.btnAdd);
        mydb = new DBHelper(this);
        details.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final String Restaurent_name = name.getText().toString();
                final String Description = description.getText().toString();
                final String Address = address.getText().toString();
                final String Branch = branch.getText().toString();
                final String Email = email.getText().toString();

                mydb.insertDetails(name.getText().toString(),description.getText().toString(),branch.getText().toString(),address.getText().toString(),email.getText().toString());
                Toast.makeText(getBaseContext(),"Done",Toast.LENGTH_LONG).show();

                ArrayList contactsList = adapter.getAllCotacts();
                Log.d("Contacts lis ","Contacts List "+contactsList.size());
                Log.d("Contacts lis ","Contacts List "+contactsList.size());
                for(int i=0;i<contactsList.size();i++)
                {
                    Log.d("Contacts lis ","Contacts List "+contactsList.get(i));
                }
                name.setText(null);
                description.setText(null);
                branch.setText(null);
                address.setText(null);
                email.setText(null);
            }
        });



    }
}
