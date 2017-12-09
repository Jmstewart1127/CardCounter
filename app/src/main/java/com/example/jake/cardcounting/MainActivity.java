package com.example.jake.cardcounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jake.cardcounting.service.CardCounter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberOfDecks = findViewById(R.id.numberOfDecks);

        final TextView runningCount = findViewById(R.id.runningCount);

        final TextView bet = findViewById(R.id.bet);

        final TextView mathematicalCount = findViewById(R.id.mathematicalCount);

        final CardCounter counter = new CardCounter();

        Button twoThroughSix = findViewById(R.id.twoThroughSix);
        twoThroughSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String changeNumOfDecksToInt = numberOfDecks.getText().toString();
                double numOfDecks = Double.parseDouble(changeNumOfDecksToInt);
                counter.setNumberOfDecks(numOfDecks);
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
                String changeNumOfDecksToInt = numberOfDecks.getText().toString();
                double numOfDecks = Double.parseDouble(changeNumOfDecksToInt);
                counter.setNumberOfDecks(numOfDecks);
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
                String changeNumOfDecksToInt = numberOfDecks.getText().toString();
                double numOfDecks = Double.parseDouble(changeNumOfDecksToInt);
                counter.setNumberOfDecks(numOfDecks);
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
                String changeNumOfDecksToInt = numberOfDecks.getText().toString();
                double numOfDecks = Double.parseDouble(changeNumOfDecksToInt);
                counter.setNumberOfDecks(numOfDecks);
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
