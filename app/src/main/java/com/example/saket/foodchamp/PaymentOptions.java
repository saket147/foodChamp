package com.example.saket.foodchamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
        TextView txt=(TextView)findViewById(R.id.textPayment);
        Toast.makeText(this,String.valueOf(txt),Toast.LENGTH_SHORT).show();


    }
}
