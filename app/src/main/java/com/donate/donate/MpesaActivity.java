package com.donate.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.donate.donate.models.MessageModel;
import com.donate.donate.networking.RetrofitClient;
import com.donate.donate.utils.SharedPreferencesConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MpesaActivity extends AppCompatActivity {
    Button donate;
    EditText amount;
    ProgressBar pr;
    SharedPreferencesConfig sharedPreferencesConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpesa);
        donate = findViewById(R.id.readytopay);
        amount = findViewById(R.id.amount);
        pr = findViewById(R.id.pr);
        sharedPreferencesConfig = new SharedPreferencesConfig(this);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (amount.getText().toString().isEmpty()){
                    Toast.makeText(MpesaActivity.this,"Please enter amount",Toast.LENGTH_SHORT).show();
                }else {
                    initiatePayment();
                }
            }
        });
    }

    private void initiatePayment() {
        String am = amount.getText().toString();
        String phone = sharedPreferencesConfig.readClientsPhone();
        pr.setVisibility(View.VISIBLE);
        Call<MessageModel> call = RetrofitClient.getInstance(MpesaActivity.this)
                .getApiConnector()
                .initiate(phone,am);
        call.enqueue(new Callback<MessageModel>() {
            @Override
            public void onResponse(Call<MessageModel> call, Response<MessageModel> response) {
                pr.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    Toast.makeText(MpesaActivity.this, "System redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MpesaActivity.this, "Server error", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<MessageModel> call, Throwable t) {
                pr.setVisibility(View.GONE);
                Toast.makeText(MpesaActivity.this, "Network error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
