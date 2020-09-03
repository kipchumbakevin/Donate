package com.donate.donate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DonationOptions extends AppCompatActivity {
    LinearLayoutCompat mpesaNo,payBill,bank,paypal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_options);
        mpesaNo = findViewById(R.id.linear_mpesa_number);
        payBill  =findViewById(R.id.linear_paybill);
        bank = findViewById(R.id.linear_bank);
        paypal = findViewById(R.id.linear_paypal);

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonationOptions.this,PaypalActivity.class);
                startActivity(intent);
            }
        });
        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonationOptions.this,CreditCard.class);
                startActivity(intent);
            }
        });
    }
}
