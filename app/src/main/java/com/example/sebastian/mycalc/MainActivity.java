package com.example.sebastian.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView = null;
    String operation = "";
    Double aNumb = 0.0;
    Double bNumb = 0.0;
    Boolean isOld = false;
    String lastClick = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textViewSum);

        final Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);

        final Button buttonSum = (Button)findViewById(R.id.buttonSum);
        final Button buttonAdd = (Button)findViewById(R.id.buttonAdd);
        final Button buttonOdd = (Button)findViewById(R.id.buttonOdd);
        Button buttonMult = (Button)findViewById(R.id.buttonMult);
        Button buttonDev = (Button)findViewById(R.id.buttonDev);

        Button buttonDot = (Button)findViewById(R.id.buttonDot);
        Button buttonClear = (Button)findViewById(R.id.buttonClear);

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

                if (!textView.getText().equals("0.0")) {
                    if (isOld) {
                        textView.setText("");
                        bNumb = 0.0;
                        isOld = false;
                    }

                    if (textView.getText().equals("0.0")) {
                        textView.setText(button0.getText().toString());
                    } else {
                        textView.setText(textView.getText() + button0.getText().toString());
                    }

                    lastClick = "zero";
                }
            }
        });


        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().equals("0.0") || textView.getText().equals("0")) {
                    setTextViewNumb(aNumb);
                    buttonSum.setEnabled(false);
                    bNumb = 0.0;
                    isOld = true;
                    aNumb = 0.0;
                }
                else calc();

                lastClick = "sum";
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("add")) {
                    if (!operation.equals("add") && !operation.equals("") && !isOld) calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textView.getText().toString());
                    else {
                        aNumb += Double.parseDouble(textView.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    operation = "add";
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "add";
            }

        });

        buttonOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!lastClick.equals("odd")) {
                    if (!operation.equals("odd") && !operation.equals("") && !isOld) calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textView.getText().toString());
                    else {
                        aNumb -= Double.parseDouble(textView.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    operation = "odd";
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "odd";
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!lastClick.equals("mult")) {
                    if (!operation.equals("mult") && !operation.equals("") && !isOld) calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textView.getText().toString());
                    else {
                        aNumb *= Double.parseDouble(textView.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    operation = "mult";
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "mult";
            }
        });

        buttonDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!lastClick.equals("dev")) {
                    if (!operation.equals("dev") && !operation.equals("") && !isOld) calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textView.getText().toString());
                    else {
                        aNumb /= Double.parseDouble(textView.getText().toString());
                        setTextViewNumb(aNumb);

                    }

                    bNumb = 0.0;
                    operation = "dev";
                    isOld = true;
                    buttonSum.setEnabled(true);
                }
                lastClick = "dev";
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aNumb = 0.0;
                bNumb = 0.0;
                operation = "";
                isOld = false;
                lastClick = "";
                textView.setText("0.0");
                buttonSum.setEnabled(true);
            }
        });



    }

    private void ownOnClickNump(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isOld) {
                    textView.setText("");
                    bNumb = 0.0;
                    isOld = false;
                }

                if(textView.getText().equals("0.0")) {
                    textView.setText(button.getText().toString());
                }
                else
                {
                    textView.setText(textView.getText() + button.getText().toString());
                }

                lastClick = "nump";
            }
        });
    }

    private void calc(){
        switch (operation) {
            case "add":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textView.getText().toString());
                    aNumb += bNumb;
                    setTextViewNumb(aNumb);
                } else {
                    bNumb = Double.parseDouble(textView.getText().toString());
                    aNumb += bNumb;
                    setTextViewNumb(aNumb);
                }

                break;
            case "odd":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textView.getText().toString());
                    aNumb -= bNumb;
                    setTextViewNumb(aNumb);
                } else {
                    bNumb = Double.parseDouble(textView.getText().toString());
                    aNumb -= bNumb;
                    setTextViewNumb(aNumb);
                }

                break;
            case "mult":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textView.getText().toString());
                    aNumb *= bNumb;
                    setTextViewNumb(aNumb);
                } else {
                    bNumb = Double.parseDouble(textView.getText().toString());
                    aNumb *= bNumb;
                    setTextViewNumb(aNumb);
                }

                break;
            case "dev":

                if (bNumb != 0.0) {
                    aNumb = Double.parseDouble(textView.getText().toString());
                    if (aNumb == 0.0 || bNumb == 0.0) textView.setText("0.0");
                    else {
                        aNumb /= bNumb;
                        setTextViewNumb(aNumb);
                    }
                } else {
                    bNumb = Double.parseDouble(textView.getText().toString());
                    if (aNumb == 0.0 || bNumb == 0.0) {
                        textView.setText("0.0");
                    }
                    else {
                        aNumb /= bNumb;
                        setTextViewNumb(aNumb);
                    }
                }

                break;
        }


        isOld = true;
        aNumb = 0.0;
    }

    private void setTextViewNumb(Double number){
        textView.setText(String.valueOf(number));
    }


}