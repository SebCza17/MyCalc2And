package com.example.sebastian.mycalc;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    TextView textViewSum = null;
    TextView textViewDebug = null;
    Double aNumb = 0.0;
    Double bNumb = 0.0;
    Boolean isOld = false;
    String lastClick = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            startActivity(new Intent(Main2Activity.this, MainActivity.class));
        }
        textViewSum = (TextView) findViewById(R.id.textViewSum);
        textViewDebug = (TextView) findViewById(R.id.textViewDebug);

        final Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        final Button buttonSum = (Button) findViewById(R.id.buttonSum);
        final Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        final Button buttonOdd = (Button) findViewById(R.id.buttonOdd);
        Button buttonMult = (Button) findViewById(R.id.buttonMult);
        Button buttonDev = (Button) findViewById(R.id.buttonDev);

        Button buttonDot = (Button) findViewById(R.id.buttonDot);
        Button buttonClear = (Button) findViewById(R.id.buttonClear);

        Button buttonPower = (Button) findViewById(R.id.buttonPow);

        ownOnClickNump(button1);
        ownOnClickNump(button2);
        ownOnClickNump(button3);
        ownOnClickNump(button4);
        ownOnClickNump(button5);
        ownOnClickNump(button6);
        ownOnClickNump(button7);
        ownOnClickNump(button8);
        ownOnClickNump(button9);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isOld) {
                    textViewSum.setText("");
                    bNumb = 0.0;
                    isOld = false;
                }

                if (textViewSum.getText().equals("0")) {
                    textViewSum.setText(button0.getText().toString());
                } else {
                    textViewSum.setText(textViewSum.getText() + button0.getText().toString());
                }

                lastClick = "zero";

            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("add") && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("+") && !textViewDebug.getText().equals("") && !isOld)
                        calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if (isOld) ;
                    else {
                        aNumb += Double.parseDouble(textViewSum.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    textViewDebug.setText("+");
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "add";
            }

        });

        buttonOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!lastClick.equals("odd") && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("-") && !textViewDebug.getText().equals("") && !isOld)
                        calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if (isOld) ;
                    else {
                        aNumb -= Double.parseDouble(textViewSum.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    textViewDebug.setText("-");
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "odd";
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!lastClick.equals("mult") && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("*") && !textViewDebug.getText().equals("") && !isOld)
                        calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if (isOld) ;
                    else {
                        aNumb *= Double.parseDouble(textViewSum.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    textViewDebug.setText("*");
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "mult";
            }
        });

        buttonDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!lastClick.equals("dev") && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("/") && !textViewDebug.getText().equals("") && !isOld)
                        calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if (isOld) ;
                    else {
                        aNumb /= Double.parseDouble(textViewSum.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    textViewDebug.setText("/");
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "dev";
            }
        });

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((textViewSum.getText().equals("0.0") || textViewSum.getText().equals("0") || textViewSum.getText().equals("")) && !textViewDebug.getText().equals("^")) {
                    setTextViewNumb(aNumb);
                    buttonSum.setEnabled(false);
                    bNumb = 0.0;
                    isOld = true;
                    aNumb = 0.0;
                    System.out.println("test");
                } else
                {
                    calc();
                    System.out.println("test");
                }

                lastClick = "sum";
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Double.parseDouble(textViewSum.getText().toString()) % 1 == 0 && !textViewSum.getText().equals("0.0")) {
                    textViewSum.setText(textViewSum.getText().toString() + ".");
                    lastClick = "dot";
                    isOld = false;

                }
            }
        });

        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!lastClick.equals("pow") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("^") && !textViewDebug.getText().equals("") && !isOld)
                        calc();

                    if (aNumb == 0.0)
                        aNumb = 1.0;
                    else if (isOld) ;
                    else {
                        aNumb = Math.pow(aNumb, Double.parseDouble(textViewSum.getText().toString()));
                        setTextViewNumb(aNumb);

                    }
                    textViewDebug.setText("^");
                    bNumb = 0.0;
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "pow";

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aNumb = 0.0;
                bNumb = 0.0;
                textViewDebug.setText("");
                isOld = false;
                lastClick = "";
                textViewSum.setText("");
                buttonSum.setEnabled(true);
            }
        });

    }

    private void ownOnClickNump(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lastClick.equals("sum")){
                    aNumb = 0.0;
                    textViewDebug.setText("");
                }
                if(isOld) {
                    textViewSum.setText("");
                    bNumb = 0.0;
                    isOld = false;
                }

                if(textViewSum.getText().equals("")) {
                    textViewSum.setText(button.getText().toString());
                }
                else
                {
                    textViewSum.setText(textViewSum.getText() + button.getText().toString());
                }

                lastClick = "nump";
            }
        });
    }

    private void calc(){
        switch (textViewDebug.getText().toString()) {
            case "+":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    aNumb += bNumb;
                    setTextViewNumb(aNumb);
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    aNumb += bNumb;
                    setTextViewNumb(aNumb);
                }

                break;
            case "-":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    aNumb -= bNumb;
                    setTextViewNumb(aNumb);
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    aNumb -= bNumb;
                    setTextViewNumb(aNumb);
                }

                break;
            case "*":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    aNumb *= bNumb;
                    setTextViewNumb(aNumb);
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    aNumb *= bNumb;
                    setTextViewNumb(aNumb);
                }

                break;
            case "/":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0.0 || bNumb == 0.0) textViewSum.setText("0.0");
                    else {
                        aNumb /= bNumb;
                        setTextViewNumb(aNumb);
                    }
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0.0 || bNumb == 0.0) {
                        textViewSum.setText("0");
                    }
                    else {
                        aNumb /= bNumb;
                        setTextViewNumb(aNumb);
                    }
                }

                break;

            case "^":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0.0 || bNumb == 0.0) textViewSum.setText("0.0");
                    else {
                        aNumb = Math.pow(aNumb, bNumb);
                        setTextViewNumb(aNumb);
                    }
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0.0 || bNumb == 0.0) {
                        textViewSum.setText("0");
                    }
                    else {
                        aNumb = Math.pow(aNumb, bNumb);
                        setTextViewNumb(aNumb);
                    }
                }

                break;
        }


        isOld = true;
        aNumb = 0.0;
    }

    private void setTextViewNumb(Double number){
        textViewSum.setText(String.valueOf(number));
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        textViewDebug.setText(savedInstanceState.getString("textDebug"));
        textViewSum.setText(savedInstanceState.getString("textSum"));
        lastClick = savedInstanceState.getString("lastClick");

        aNumb = savedInstanceState.getDouble("aNumb");
        bNumb = savedInstanceState.getDouble("bNumb");

        isOld = savedInstanceState.getBoolean("isOld");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("textDebug", textViewDebug.getText().toString());
        outState.putString("textSum", textViewSum.getText().toString());
        outState.putString("lastClick", lastClick);

        outState.putDouble("aNumb", aNumb);
        outState.putDouble("bNumb", bNumb);

        outState.putBoolean("isOld", isOld);


        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }


}
