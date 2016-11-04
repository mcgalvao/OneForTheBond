package com.example.android.oneforthebond;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    int tg1, tg2,tg3,tg4,pt1,pt2,pt3,pt4,pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atualiza(0,0,0,0);
    }

    public void busca(View view) {

        pega_dados();

    }

    public void pega_dados () {

        EditText pts1 = (EditText) findViewById(R.id.in1);
        EditText pts2 = (EditText) findViewById(R.id.in2);
        EditText pts3 = (EditText) findViewById(R.id.in3);
        EditText pts4 = (EditText) findViewById(R.id.in4);

        if (pts1.getText().toString().equals("")){
            pt1 = 0;    }

        else{
            pt1 = Integer.parseInt(pts1.getText().toString());
            }


        if (pts2.getText().toString().equals("")){
            pt2 = 0;}

        else{
            pt2 = Integer.parseInt(pts2.getText().toString());
            }


        if (pts3.getText().toString().equals("")){
            pt3 = 0;    }

        else{
            pt3 = Integer.parseInt(pts3.getText().toString());
            }


        if (pts4.getText().toString().equals("")){
            pt4 = 0;    }

        else{
            pt4 = Integer.parseInt(pts4.getText().toString());
            }

        switch (pt1+pt2+pt3+pt4) {
            case 26:
                atualiza(pt1, pt2, pt3, pt4);
                zera_entradas();
                break;

            case 26*3:
                atualiza(pt1, pt2, pt3, pt4);
                zera_entradas();
                break;

            default:
                new AlertDialog.Builder(this)
                        .setTitle("Olá, amg!")
                        .setMessage("A soma dos pontos não é 26. Quer continuar?")
                        .setPositiveButton("Sim!!", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                atualiza(pt1, pt2, pt3, pt4);
                                zera_entradas();

                            }
                        })
                        .setNegativeButton("Não, pf!!!", null).show();
                break;
        }


    }

    private void zera_entradas (){

        EditText pts1 = (EditText) findViewById(R.id.in1);
        EditText pts2 = (EditText) findViewById(R.id.in2);
        EditText pts3 = (EditText) findViewById(R.id.in3);
        EditText pts4 = (EditText) findViewById(R.id.in4);

        pts1.setText("");
        pts2.setText("");
        pts3.setText("");
        pts4.setText("");

    }


    private void atualiza(int t1, int t2, int t3, int t4) {

        SharedPreferences spref = getSharedPreferences("pontos",0);
        pos = spref.getInt("posicao",0);
        tg1 = spref.getInt("player1_"+pos,0);
        tg2 = spref.getInt("player2_"+pos,0);
        tg3 = spref.getInt("player3_"+pos,0);
        tg4 = spref.getInt("player4_"+pos,0);

        tg1 = tg1 + t1;
        tg2 = tg2 + t2;
        tg3 = tg3 + t3;
        tg4 = tg4 + t4;

        TextView quantityTextView = (TextView) findViewById(R.id.p1);
        quantityTextView.setText("" + tg1);

        TextView quantityTextView2 = (TextView) findViewById(R.id.p2);
        quantityTextView2.setText("" + tg2);

        TextView quantityTextView3 = (TextView) findViewById(R.id.p3);
        quantityTextView3.setText("" + tg3);

        TextView quantityTextView4 = (TextView) findViewById(R.id.p4);
        quantityTextView4.setText("" + tg4);

        pos++;

        SharedPreferences.Editor editor = spref.edit();
        editor.putInt("player1_"+pos, tg1);
        editor.putInt("player2_"+pos, tg2);
        editor.putInt("player3_"+pos, tg3);
        editor.putInt("player4_"+pos, tg4);
        editor.putInt("posicao",pos);
        editor.apply();

        EditText pts1 = (EditText) findViewById(R.id.in1);
        pts1.requestFocus();

    }

    public void deletar () {

        EditText pts1 = (EditText) findViewById(R.id.in1);
        pts1.setText("");

        EditText pts2 = (EditText) findViewById(R.id.in2);
        pts2.setText("");

        EditText pts3 = (EditText) findViewById(R.id.in3);
        pts3.setText("");

        EditText pts4 = (EditText) findViewById(R.id.in4);
        pts4.setText("");


        for (int i = 0;i<=pos;i++) {
            SharedPreferences spref = getSharedPreferences("pontos", 0);
            SharedPreferences.Editor editor = spref.edit();
            editor.remove("player1_"+i);
            editor.remove("player2_"+i);
            editor.remove("player3_"+i);
            editor.remove("player4_"+i);
            editor.apply();
        }

        SharedPreferences spref = getSharedPreferences("pontos", 0);
        SharedPreferences.Editor editor = spref.edit();
        editor.remove("posicao");
        editor.apply();
        atualiza(0,0,0,0);
    }

    public void apagar (View view) {

        new AlertDialog.Builder(this)
                .setTitle("Olá, amg!")
                .setMessage("Você está certo disso?")
                .setPositiveButton("Tô!!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(MainActivity.this, "Pronto maluco!", Toast.LENGTH_SHORT).show();
                        deletar();

                    }
                })
                .setNegativeButton("Não, me salva!!", null).show();
    }

    public void abreHistorico(View view) {
        Intent intent = new Intent(this, Historico.class);
        startActivity(intent);
    }

}