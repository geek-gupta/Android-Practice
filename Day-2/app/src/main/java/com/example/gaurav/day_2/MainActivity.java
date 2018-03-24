package com.example.gaurav.day_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String Tag="mainActivity";

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus,btnminus,btnmul,btndiv,btnequal,btnpoint,btnclear;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Log.d(Tag,"in create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnplus=(Button)findViewById(R.id.btnplus);
        btnminus=(Button)findViewById(R.id.btnminus);
        btnmul=(Button)findViewById(R.id.btnmul);
        btndiv=(Button)findViewById(R.id.btndiv);
        btnclear=(Button)findViewById(R.id.btnclear);
        btnpoint=(Button)findViewById(R.id.btnpoint);
        btnequal=(Button)findViewById(R.id.btnequal);
        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);


        btn0.setOnClickListener(this);
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
        btnpoint.setOnClickListener(this);
        btnclear.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn0: {

                t1.setText(t1.getText().toString()+"0");
                break;
            }
            case R.id.btn1:{
                t1.setText(t1.getText().toString()+"1");
                break;
            }
            case R.id.btn2:{
                t1.setText(t1.getText().toString()+"2");
                break;
            }
            case R.id.btn3:{
                t1.setText(t1.getText().toString()+"3");
                break;
            }
            case R.id.btn4:{
                t1.setText(t1.getText().toString()+"4");
                break;
            }
            case R.id.btn5:{
                t1.setText(t1.getText().toString()+"5");
                break;
            }
            case R.id.btn6:{
                t1.setText(t1.getText().toString()+"6");
                break;
            }
            case R.id.btn7:{
                t1.setText(t1.getText().toString()+"7");
                break;
            }
            case R.id.btn8:{
                t1.setText(t1.getText().toString()+"8");
                break;
            }
            case R.id.btn9:{
                t1.setText(t1.getText().toString()+"9");
                break;
            }
            case R.id.btnplus:{
                t1.setText(t1.getText().toString()+"+");
                break;
            }
            case R.id.btnminus:{
                t1.setText(t1.getText().toString()+"-");
                break;
            }
            case R.id.btnmul:{
                t1.setText(t1.getText().toString()+"*");
                break;
            }
            case R.id.btndiv:{
                t1.setText(t1.getText().toString()+"/");
                break;
            }
            case R.id.btnpoint:{
                t1.setText(t1.getText().toString()+".");
                break;
            }
            case R.id.btnclear:{
                t1.setText("");
                break;
            }
            case R.id.btnequal:{
                try {
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByName("Javascript");
                    String expres = t1.getText().toString();

                    t2.setText(((double)engine.eval(expres)) + "");


                }catch (Exception e){
                    e.printStackTrace();
                }


            }



        }

    }
}
