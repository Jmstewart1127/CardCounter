package com.example.jake.cardcounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jake.cardcounting.service.CardCounter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView runningCount = findViewById(R.id.runningCount);

        final TextView bet = findViewById(R.id.bet);

        final TextView mathematicalCount = findViewById(R.id.mathematicalCount);

        final CardCounter counter = new CardCounter();

//        EditText numberOfDecks = findViewById(R.id.numberOfDecks);
//        final String changeNumOfDecksToInt = numberOfDecks.getText().toString();
//        numberOfDecks.setOnKeyListener(new View.OnKeyListener(){
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event){
//                if (keyCode == event.KEYCODE_ENTER) {
//                    final double numOfDecks = Double.parseDouble(changeNumOfDecksToInt);
//                    counter.setNumberOfDecks(numOfDecks);
//                }
//                return true;
//            }
//        });

        final EditText numberOfDecks = findViewById(R.id.numberOfDecks);
        numberOfDecks.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Log.d("input", "input: " + numberOfDecks.getText().toString());
                    double numOfDecks = Double.parseDouble(numberOfDecks.getText().toString());
                    counter.setNumberOfDecks(numOfDecks);
                    return true;
                }
                return false;
            }
        });

        Button twoThroughSix = findViewById(R.id.twoThroughSix);
        twoThroughSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.drawTwoThroughSix();
                bet.setText(counter.betOrNot());
                runningCount.setText(counter.getCharRunningTotal());
                mathematicalCount.setText(counter.mathematicalRunningTotal());
            }
        });

        Button sevenThroughNine = findViewById(R.id.sevenThroughNine);
        sevenThroughNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.drawSevenThroughNine();
                bet.setText(counter.betOrNot());
                runningCount.setText(counter.getCharRunningTotal());
                mathematicalCount.setText(counter.mathematicalRunningTotal());
            }
        });

        Button tenPlus = findViewById(R.id.tenPlus);
        tenPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.drawTenPlusOrAce();
                bet.setText(counter.betOrNot());
                runningCount.setText(counter.getCharRunningTotal());
                mathematicalCount.setText(counter.mathematicalRunningTotal());
            }
        });

        Button ace = findViewById(R.id.ace);
        ace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.drawTenPlusOrAce();
                bet.setText(counter.betOrNot());
                runningCount.setText(counter.getCharRunningTotal());
                mathematicalCount.setText(counter.mathematicalRunningTotal());
            }
        });

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.newGame();
                bet.setText(counter.betOrNot());
                runningCount.setText(counter.getCharRunningTotal());
            }
        });

    }
}
