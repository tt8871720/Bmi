package com.user.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edweight;
    private EditText edheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edweight = findViewById(R.id.ed_wieght);
        edheight  = findViewById(R.id.ed_height);
    }
    public void bmi(View view){//view要import
        Log.d("Mainactivity" , "bmi");
        String w = edweight.getText().toString();
        String h = edheight.getText().toString();
        Log.d("MainActivity"  , w + "/" + h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        Log.d("MainActivity" ,  bmi + "");//畫面還不會顯示
        Toast.makeText(this,"Your BMI is " + bmi,Toast.LENGTH_LONG).show();//顯示也可選creat()
        new AlertDialog.Builder(this).setMessage("Your BMI is " + bmi).setTitle("BMI").setPositiveButton("OK" ,null).setNegativeButton("Clear", new DialogInterface.OnClickListener(){
            //按ok後,app重新一次
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edweight.setText("");//按ok後,將重新設置數值
                edheight.setText("");
            }
        }).show();

    }
}
