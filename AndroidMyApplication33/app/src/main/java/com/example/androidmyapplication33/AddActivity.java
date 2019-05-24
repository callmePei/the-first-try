package com.example.androidmyapplication33;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;


public class AddActivity extends MainActivity {

    /*private static final String TAG = "AddActivity";*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        final EditText num1 = (EditText) findViewById(R.id.num1);
        final EditText num2 = (EditText) findViewById(R.id.num2);
        final TextView addnum1 = (TextView) findViewById(R.id.addnum1);
        final TextView addnum2 = (TextView) findViewById(R.id.addnum2);
        Button addbt1 = (Button) findViewById(R.id.addbt1);
        Button addbt2 = (Button) findViewById(R.id.addbt2);


        Intent intent = getIntent();
        final String anum1 = intent.getStringExtra("num1");
        final String anum2 = intent.getStringExtra("num2");
        addnum1.setText("运算数1："+anum1);
        addnum2.setText("运算数2："+anum2);

        addbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String uriString1 = num1.getText().toString();
                String uriString2 = num2.getText().toString();
                String adddata =add(uriString1,uriString2);
                Intent result = new Intent(null, adddata);
                setResult(RESULT_OK, result);
                finish();*/

                Intent intent = getIntent();
             /*   String a1 = num1.getText().toString();
                String a2 = num2.getText().toString();*/
                String result1 = add(anum1,anum2);
               /* Intent intent = new Intent();*/

                intent.putExtra("result1", result1);



               /*  调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                 */


                setResult(RESULT_OK, intent);
                //    结束当前这个Activity对象的生命
                finish();


            }
        });
        addbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });


    }
    public static String add(String add1, String... add2) {

        String v1;

        try {

            // 去掉千位分割符

            v1 = new DecimalFormat().parse(add1).toString();

            // 用字符串构造BigDecimal

            BigDecimal sum = new BigDecimal(v1);

            for (String v2 : add2) {

                v2 = new DecimalFormat().parse(v2).toString();

                sum = sum.add(new BigDecimal(v2));

            }

            // 添加千位分隔符，保留两位小数

            DecimalFormat df = new DecimalFormat("#,###.00");

            String dfSum = df.format(sum);

            return dfSum;

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return null;

    }

}
