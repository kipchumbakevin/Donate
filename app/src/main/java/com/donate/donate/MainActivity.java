package com.donate.donate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    Button donate;
    LinearLayoutCompat linearLayoutCompat,mpesaNo,payBill,bank,paypal;
    RelativeLayout relativeLayout;
    BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donate = findViewById(R.id.donate);
        mpesaNo = findViewById(R.id.linear_mpesa_number);
        payBill  =findViewById(R.id.linear_paybill);
        bank = findViewById(R.id.linear_bank);
        paypal = findViewById(R.id.linear_paypal);
        relativeLayout = findViewById(R.id.rela);
        linearLayoutCompat = findViewById(R.id.bottom);
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayoutCompat);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                Intent intent = new Intent(MainActivity.this,PaypalActivity.class);
                startActivity(intent);
            }
        });
        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                Intent intent = new Intent(MainActivity.this,CreditCard.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
