package com.example.gaurav.firstproject;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    double val1, val2, valresult;
    EditText et1, et2;
    TextView t1;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnequal, btnplus, btnminus, btndiv, btnmul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnequal = (Button) findViewById(R.id.btnequal);
        btnplus = (Button) findViewById(R.id.btnplus);
        btnminus = (Button) findViewById(R.id.btnminus);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnmul = (Button) findViewById(R.id.btnmul);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        t1 = (TextView) findViewById(R.id.textView);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnequal.setOnClickListener(this);
        et1.setInputType(InputType.TYPE_NULL);
        et2.setInputType(InputType.TYPE_NULL);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                String var = "1";
               /* if (!et1.getText().toString().isEmpty()) {
                    var = Integer.parseInt(et1.getText().toString());
                    var = Integer.parseInt(et2.getText().toString());
                }
                int disp = var * 10 + 1;
            */
                if (et1.isFocused())
                    et1.setText(et1.getText().toString()+var);
                else
                    et2.setText(et2.getText().toString()+var);
                break;
            case R.id.btn2:
                et1.setText("1");
                break;
            case R.id.btn3:
                break;
            case R.id.btn4:
                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                break;
            case R.id.btn7:
                break;
            case R.id.btn8:
                break;
            case R.id.btn9:
                break;
            case R.id.btnplus:
                val1=Double.parseDouble(et1.getText().toString());
                val2=Double.parseDouble(et2.getText().toString());
                valresult=val1+val2;
                t1.setText(""+valresult);
                break;
            case R.id.btnminus:
                break;
            case R.id.btnmul:
                break;
            case R.id.btndiv:
                break;
            case R.id.btnequal:

                break;

        }
    }
}

