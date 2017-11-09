package org.adry.simplecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String CONTADOR = "Contador";


    private Button counterBtn;
    private TextView counterValue;
    private Button resetBtn;
    private Button infoBtn;;

    private int mValor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() llamado");
        setContentView(R.layout.activity_main);

        counterBtn = (Button) findViewById(R.id.counterBtn);
        counterValue = (TextView) findViewById(R.id.counterValueTextView);
        resetBtn = (Button) findViewById(R.id.restartBtn);
        infoBtn = (Button) findViewById(R.id.info);

        if (savedInstanceState != null){
            mValor = savedInstanceState.getInt(CONTADOR);
        }


        counterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValor++;

                counterValue.setText(mValor + "");
            }
        });

        /*
        * Boton que reinicia el contador a 0.
        * */
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mValor = 0;
                counterValue.setText(mValor+"");
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart() llamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() llamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() llamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() llamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart() llamado");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CONTADOR,mValor);
    }
}
