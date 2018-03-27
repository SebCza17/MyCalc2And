package com.example.sebastian.mycalc;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewSum = null;
    TextView textViewDebug = null;
    Double aNumb = 0.0;
    Double bNumb = 0.0;
    Boolean isOld = false;
    String lastClick = "start";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch (getResources().getConfiguration().orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main2);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;

        }
        /*
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }*/


        textViewSum = (TextView)findViewById(R.id.textViewSum);
        textViewDebug = (TextView)findViewById(R.id.textViewDebug);

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

        Button buttonPower = (Button) findViewById(R.id.buttonPow);
        Button buttonMod = (Button)findViewById(R.id.buttonMod);
        Button buttonStrong = (Button)findViewById(R.id.buttonFactorial);
        Button buttonSqrt = (Button)findViewById(R.id.buttonSqrt);

        Button buttonSin = (Button)findViewById(R.id.buttonSin);
        Button buttonCos = (Button)findViewById(R.id.buttonCos);
        Button buttonTan = (Button)findViewById(R.id.buttonTan);
        Button buttonExp = (Button)findViewById(R.id.buttonExp);

        Button buttonPi = (Button)findViewById(R.id.buttonPi);

        Button buttonChange = (Button)findViewById(R.id.buttonChange);

        Button buttonDot = (Button)findViewById(R.id.buttonDot);
        final Button buttonClear = (Button)findViewById(R.id.buttonClear);

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

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calc();

                lastClick = "sum";
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("add")  && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("+") && !textViewDebug.getText().equals("") && !isOld) calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if(isOld);
                    else {
                        textViewDebug.setText("+");
                        calc();

                    }

                    if(isEnabled()) setParam("+");
                }
                lastClick = "add";
            }

        });

        buttonOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!lastClick.equals("odd")  && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("-") && !textViewDebug.getText().equals("") && !isOld)
                        calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if (isOld) ;
                    else {
                        textViewDebug.setText("-");
                        calc();

                    }

                    if(isEnabled()) setParam("-");
                }
                lastClick = "odd";
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!lastClick.equals("mult")  && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("*") && !textViewDebug.getText().equals("") && !isOld) calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if(isOld);
                    else {
                        textViewDebug.setText("*");
                        calc();

                    }

                    if(isEnabled()) setParam("*");
                }
                lastClick = "mult";
            }
        });

        buttonDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!lastClick.equals("dev") && !textViewSum.getText().equals("")) {
                    if (!textViewDebug.getText().equals("/") && !textViewDebug.getText().equals("") && !isOld) calc();
                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if(isOld);
                    else {
                        textViewDebug.setText("/");
                        calc();

                    }

                    if(isEnabled()) setParam("/");
                }
                lastClick = "dev";
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textViewSum.getText().equals("") && !textViewSum.getText().toString().contains(".")) {
                    if (Double.parseDouble(textViewSum.getText().toString()) % 1 == 0) {
                        textViewSum.setText(textViewSum.getText() + ".");
                        lastClick = "dot";
                        isOld = false;
                    }

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
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if (isOld) ;
                    else {
                        textViewDebug.setText("^");
                        calc();

                    }
                    if(isEnabled()) setParam("^");
                }
                lastClick = "pow";

            }
        });

        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("mod") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("%") && !textViewDebug.getText().equals("") && !isOld)
                        calc();

                    if (aNumb == 0.0)
                        aNumb = Double.parseDouble(textViewSum.getText().toString());
                    else if (isOld) ;
                    else {
                        textViewDebug.setText("%");
                        calc();

                    }
                    if(isEnabled()) setParam("%");
                }
                lastClick = "mod";
            }
        });


        buttonStrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("fact") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("!") && !textViewDebug.getText().equals("") && !isOld)
                        calc();

                        Double tempNumb = Double.parseDouble(textViewSum.getText().toString());
                        Integer intTempNumb = tempNumb.intValue();

                        if(intTempNumb < 9999) {
                            for (Integer i = intTempNumb - 1; i > 1; i--) tempNumb *= i;
                            textViewSum.setText("" + tempNumb);
                            aNumb = Double.parseDouble(textViewSum.getText().toString());
                        }

                    if(isEnabled()) setParam("!");
                }
                lastClick = "fact";
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("sqrt") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("sqrt") && !textViewDebug.getText().equals("") && !isOld)
                        calc();

                        Double tempNumb = Math.sqrt(Double.parseDouble(textViewSum.getText().toString()));

                        textViewSum.setText("" + tempNumb);
                        aNumb = Double.parseDouble(textViewSum.getText().toString());


                    if(isEnabled()) setParam("sqrt");
                }
                lastClick = "sqrt";
            }
        });


        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("sin") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("sin") && !textViewDebug.getText().equals("") && !isOld)
                        calc();


                        Double tempNumb = Math.sin(Double.parseDouble(textViewSum.getText().toString()));

                        textViewSum.setText("" + tempNumb);
                        aNumb = Double.parseDouble(textViewSum.getText().toString());


                    if(isEnabled()) setParam("sin");
                }
                lastClick = "sin";
            }
        });

        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("cos") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("cos") && !textViewDebug.getText().equals("") && !isOld)
                        calc();


                        Double tempNumb = Math.cos(Double.parseDouble(textViewSum.getText().toString()));

                        textViewSum.setText("" + tempNumb);
                        aNumb = Double.parseDouble(textViewSum.getText().toString());


                    if(isEnabled()) setParam("cos");
                }
                lastClick = "cos";
            }
        });

        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("tan") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("tan") && !textViewDebug.getText().equals("") && !isOld)
                        calc();


                    Double tempNumb = Math.tan(Double.parseDouble(textViewSum.getText().toString()));

                    textViewSum.setText("" + tempNumb);
                    aNumb = Double.parseDouble(textViewSum.getText().toString());


                   if(isEnabled()) setParam("tan");
                }
                lastClick = "tan";
            }
        });

        buttonExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lastClick.equals("exp") && !textViewSum.getText().equals("")) {

                    if (!textViewDebug.getText().equals("exp") && !textViewDebug.getText().equals("") && !isOld)
                        calc();


                    Double tempNumb = Math.exp(Double.parseDouble(textViewSum.getText().toString()));

                    textViewSum.setText("" + tempNumb);
                    aNumb = Double.parseDouble(textViewSum.getText().toString());


                    if(isEnabled()) setParam("exp");
                }
                lastClick = "exp";
            }
        });

        buttonPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSum.setText(String.valueOf(Math.PI));
            }
        });


        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textViewSum.getText().equals("") && Double.parseDouble(textViewSum.getText().toString()) != 0)

                textViewSum.setText( Double.toString(Double.parseDouble(textViewSum.getText().toString()) * -1) );
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aNumb = 0.0;
                bNumb = 0.0;
                textViewDebug.setText("");
                isOld = false;
                lastClick = "start";
                textViewSum.setText("");
                changeBlock(true);
            }
        });

    }

    private void setParam(String s) {
        textViewDebug.setText(s);
        bNumb = 0.0;
        isOld = true;
    }

    private void changeBlock(boolean isEnabled){

        RelativeLayout relativeLayoutButtons = (RelativeLayout)findViewById(R.id.relativeLayoutButtons);
        Button buttonClear = (Button)findViewById(R.id.buttonClear);

        for (int i = 0; i < relativeLayoutButtons.getChildCount(); i++) {
            View child = relativeLayoutButtons.getChildAt(i);
            child.setEnabled(isEnabled);
        }

        buttonClear.setEnabled(true);

    }

    private boolean isEnabled(){
        Button buttonSample = (Button)findViewById(R.id.buttonSum);
        return buttonSample.isEnabled();
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

                if (bNumb != 0) {
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

                if (bNumb != 0) {
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

                if (bNumb != 0) {
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

                if (bNumb != 0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb != 0) {
                        aNumb /= bNumb;
                        setTextViewNumb(aNumb);
                    }
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0 || bNumb == 0) {
                        changeBlock(false);
                        textViewDebug.setText("Nie Dziel przez 0 Debilu");
                    } else {
                        aNumb /= bNumb;
                        setTextViewNumb(aNumb);
                    }
                }

                break;

            case "^":

                if (bNumb != 0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0) textViewSum.setText("1");
                    else {
                        aNumb = Math.pow(aNumb, bNumb);
                        setTextViewNumb(aNumb);
                    }
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0 || bNumb == 0) {
                        textViewSum.setText("1");
                    } else {
                        aNumb = Math.pow(aNumb, bNumb);
                        setTextViewNumb(aNumb);
                    }
                }

                break;

            case "%":

                if (bNumb != 0) {
                    aNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0) textViewSum.setText("1");
                    else {
                        aNumb = aNumb%bNumb;
                        setTextViewNumb(aNumb);
                    }
                } else {
                    bNumb = Double.parseDouble(textViewSum.getText().toString());
                    if (aNumb == 0 || bNumb == 0) {
                        textViewSum.setText("1");
                    } else {
                        aNumb = aNumb%bNumb;
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