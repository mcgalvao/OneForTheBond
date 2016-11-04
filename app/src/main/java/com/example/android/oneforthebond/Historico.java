package com.example.android.oneforthebond;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class Historico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        total_c();
    }


    public void por_rodada(View view) {

        SharedPreferences spref = getSharedPreferences("pontos",0);
        int pos = spref.getInt("posicao",0);
        LinearLayout lp1 = (LinearLayout) findViewById(R.id.lj1);
        LinearLayout lp2 = (LinearLayout) findViewById(R.id.lj2);
        LinearLayout lp3 = (LinearLayout) findViewById(R.id.lj3);
        LinearLayout lp4 = (LinearLayout) findViewById(R.id.lj4);

        lp1.removeAllViews();
        lp2.removeAllViews();
        lp3.removeAllViews();
        lp4.removeAllViews();

        for (int i = 2;i<=pos;i++) {
            TextView valor1 = new TextView(this);
            valor1.setTextSize(20);
            valor1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView valor2 = new TextView(this);
            valor2.setTextSize(20);
            valor2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView valor3 = new TextView(this);
            valor3.setTextSize(20);
            valor3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView valor4 = new TextView(this);
            valor4.setTextSize(20);
            valor4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            valor1.setText(String.valueOf((spref.getInt("player1_"+i,0)-(spref.getInt("player1_"+(i-1),0)))));
            lp1.addView(valor1,-1);


            valor2.setText(String.valueOf((spref.getInt("player2_"+i,0)-(spref.getInt("player2_"+(i-1),0)))));
            lp2.addView(valor2,-1);

            valor3.setText(String.valueOf((spref.getInt("player3_"+i,0)-(spref.getInt("player3_"+(i-1),0)))));
            lp3.addView(valor3,-1);

            valor4.setText(String.valueOf((spref.getInt("player4_"+i,0)-(spref.getInt("player4_"+(i-1),0)))));
            lp4.addView(valor4,-1);


        }



    }

    public void total(View view){
        total_c();
    }
    public void total_c() {

        SharedPreferences spref = getSharedPreferences("pontos",0);
        int pos = spref.getInt("posicao",0);
        LinearLayout lp1 = (LinearLayout) findViewById(R.id.lj1);
        LinearLayout lp2 = (LinearLayout) findViewById(R.id.lj2);
        LinearLayout lp3 = (LinearLayout) findViewById(R.id.lj3);
        LinearLayout lp4 = (LinearLayout) findViewById(R.id.lj4);

        lp1.removeAllViews();
        lp2.removeAllViews();
        lp3.removeAllViews();
        lp4.removeAllViews();

        for (int i = 2;i<=pos;i++) {
            TextView valor1 = new TextView(this);
            valor1.setTextSize(20);
            valor1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView valor2 = new TextView(this);
            valor2.setTextSize(20);
            valor2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView valor3 = new TextView(this);
            valor3.setTextSize(20);
            valor3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView valor4 = new TextView(this);
            valor4.setTextSize(20);
            valor4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            valor1.setText(String.valueOf((spref.getInt("player1_"+i,0))));
            lp1.addView(valor1,-1);


            valor2.setText(String.valueOf((spref.getInt("player2_"+i,0))));
            lp2.addView(valor2,-1);

            valor3.setText(String.valueOf((spref.getInt("player3_"+i,0))));
            lp3.addView(valor3,-1);

            valor4.setText(String.valueOf((spref.getInt("player4_"+i,0))));
            lp4.addView(valor4,-1);


        }

        

    }
}