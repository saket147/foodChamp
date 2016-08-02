package com.example.saket.foodchamp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Cuisine extends AppCompatActivity
{
Button add,save;
    Context context;
    static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);
        context=getBaseContext();
        final LinearLayout linearLayout=(LinearLayout) findViewById(R.id.rlayout);
        add=(Button)findViewById(R.id.btnAddCuisine);
        save=(Button)findViewById(R.id.btnSaveCuisine);
        add.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view)
            {
               /* i++;
                if (i < 5)
                {*/
                    for(i=0;i<10;i++)
                    {
                        final EditText editText=new EditText(context);
                        editText.setId(i);
                        editText.setHint("Add Cuisine"+(String.valueOf(i+1)));
                        linearLayout.setOrientation(LinearLayout.VERTICAL);
                        linearLayout.addView(editText,100,100);
                    }
                    /*EditText editText = new EditText(getBaseContext());

                    //editText.setGravity(Gravity.RIGHT);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                    *//*layoutParams.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
                    layoutParams.setMargins(0, 100, 100, 200);*//*
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    layoutParams.width=LinearLayout.LayoutParams.MATCH_PARENT;
                    layoutParams.height=LinearLayout.LayoutParams.WRAP_CONTENT;
                    // RelativeLayout.LayoutParams()
                    editText.setLayoutParams(layoutParams);
                    //if you want to identify the created editTexts, set a tag, like below
                    editText.setTextSize(30);
                    linearLayout.addView(editText);*/
                //}
                Intent intent=new Intent(getBaseContext(),Facility.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getBaseContext(),"saved",Toast.LENGTH_LONG).show();
            }
        });
    }
}
