package com.donate.donate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class CreditCard extends AppCompatActivity {
    CardForm cardForm;
    Button buy;
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
        cardForm = findViewById(R.id.card_form);
        buy = findViewById(R.id.btnbuy);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .setup(CreditCard.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardForm.isValid()){
                    alert = new AlertDialog.Builder(CreditCard.this);
                    alert.setTitle("Confirm before contributing")
                            .setMessage("Card number: "+cardForm.getCardNumber()+"\n"+
                                    "Card expiry date: "+cardForm.getExpirationDateEditText().getText().toString()+"\n"+
                                    "Card CVV: "+cardForm.getCvv()+"\n"+
                                    "Postal code: "+cardForm.getPostalCode()+ "\n"+
                                    "Phone number: " + cardForm.getMobileNumber());
                    alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(CreditCard.this,"Thank you for donating",Toast.LENGTH_SHORT).show();
                        }
                    })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else {
                    Toast.makeText(CreditCard.this,"Please complete the form",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
