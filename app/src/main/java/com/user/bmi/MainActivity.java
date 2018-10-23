package com.user.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edweight;
    private EditText edheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity " , "onCreat");
        setContentView(R.layout.activity_main);
        findView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity " , "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity " , "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity " , "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity " , "onPause");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("MainActivity " , "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity " , "onRestart");
    }

    private void findView() {
        edweight = findViewById(R.id.ed_wieght);
        edheight  = findViewById(R.id.ed_height);
        Button help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//匿名類別
                Log.d("MainActivity " , "omClick : help");
                new AlertDialog.Builder(MainActivity.this).setMessage(
                        R.string.bmi_info).setTitle("Help")
                        .setPositiveButton(R.string.ok ,null).show();
            }
        });
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
        Intent intent = new Intent(this , ResultActivity.class);
        intent.putExtra("result" , bmi);
        startActivity(intent);
// Toast.makeText(this,getString(R.string.your_bmi_is) + bmi,Toast.LENGTH_LONG).show();//顯示也可選creat()
//        new AlertDialog.Builder(this).setMessage(getString(R.string.your_bmi_is) + bmi).setTitle("BMI").setPositiveButton(R.string.ok ,null).setNegativeButton(R.string.clear, new DialogInterface.OnClickListener(){
//            //按ok後,app重新一次
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                edweight.setText("");//按ok後,將重新設置數值
//                edheight.setText("");
//            }
//        }).show();

    }
}
