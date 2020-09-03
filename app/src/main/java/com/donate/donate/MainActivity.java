package com.donate.donate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button donate;
    LinearLayoutCompat linearLayoutCompat,mpesaNo,payBill,bank,paypal,menuu;
    RelativeLayout relativeLayout;
    BottomSheetBehavior bottomSheetBehavior,bottommenu;
    ImageView menu;
    TextView share,policy,message;
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
        share = findViewById(R.id.share);
        policy = findViewById(R.id.policy);
        message = findViewById(R.id.mess);
        menu = findViewById(R.id.menu);
        menuu = findViewById(R.id.menuu);
        linearLayoutCompat = findViewById(R.id.bottom);
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayoutCompat);
        bottommenu = BottomSheetBehavior.from(menuu);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        setText("Have you ever slept on an empty stomach?\nHave you ever been kicked out of your room?\n\n" +
                "Well, that's the situation my friend is currently facing. I am also struggling with life,thus not able to help on my own.\n\n" +"I decided to build a simple application and use this platform to reach willing donors across the world.\n\n" +
                "\nIf we can get a thousand people donating $1 each, we will improve the life of my struggling friend.\n\n" +"Please help me help a brother.\n\nNB: No amount is considered small. Together we can achieve.\n\n"+"Thank you.");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottommenu.setState(BottomSheetBehavior.STATE_EXPANDED);
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
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottommenu.setState(BottomSheetBehavior.STATE_COLLAPSED);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody =
                        "Help me help a Brother. Download Donate App now at https://play.google.com/store/apps/details?id="
                                + MainActivity.this.getPackageName();
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share via"));
            }
        });
        policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottommenu.setState(BottomSheetBehavior.STATE_COLLAPSED);
                Uri uri = Uri.parse("https://www.lovidovi.co.ke/ealoanspolicy");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.lovidovi.co.ke/ealoanspolicy")));
                }
            }
        });
    }

    public void setText(final String s){
        final int[]i = new int[1];
        i[0] = 0;
        final int length = s.length();
        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (s!=null){
                    char c = s.charAt(i[0]);
                    message.append(String.valueOf(c));
                }

                i[0]++;
            }
        };
        final Timer timer = new Timer();
        TimerTask taskEverySplitSecond = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                if (i[0] == length-1){
                    timer.cancel();
                }
            }
        };
        timer.schedule(taskEverySplitSecond,1,10);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
