package com.example.saket.foodchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Facility extends AppCompatActivity
{
    int pos1=0,pos2=0;
    TextView filterTags;
    Button next;
    RadioGroup radioGroup;
    RadioButton homeDelievery,dineIn,airConditioned,alcohol;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility);
        next=(Button)findViewById(R.id.btnFacility);
        filterTags=(TextView)findViewById(R.id.textFacility);
        radioGroup=(RadioGroup)findViewById(R.id.groupFacility);
        homeDelievery=(RadioButton)findViewById(R.id.homeDelievery);
        dineIn=(RadioButton)findViewById(R.id.dineIn);
        airConditioned=(RadioButton)findViewById(R.id.airConditioned);
        alcohol=(RadioButton)findViewById(R.id.alcohol);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                pos1=radioGroup.indexOfChild(findViewById(i));
                Toast.makeText(getBaseContext(), "Method 1 ID = "+String.valueOf(pos1),
                        Toast.LENGTH_SHORT).show();

                pos1=radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));

                Toast.makeText(getBaseContext(), "Method 2 ID = "+String.valueOf(pos1),Toast.LENGTH_SHORT).show();


                switch (pos1)
                {
                    case 0 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 1",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 2",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 3",
                                Toast.LENGTH_SHORT).show();
                        break;
                    default :
                        //The default selection is RadioButton 1
                        Toast.makeText(getBaseContext(),"You have Clicked RadioButton 1" ,
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getBaseContext(),PaymentOptions.class);
                startActivity(intent);
            }
        });



    }
}
