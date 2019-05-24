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

public class SubActivity extends MainActivity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sub);
            final EditText num1 = (EditText) findViewById(R.id.num1);
            final EditText num2 = (EditText) findViewById(R.id.num2);
            final TextView subnum1 = (TextView) findViewById(R.id.subnum1);
            final TextView subnum2 = (TextView) findViewById(R.id.subnum2);
            Button subbt1 = (Button) findViewById(R.id.subbt1);
            Button subbt2 = (Button) findViewById(R.id.subbt2);

            Intent intent = getIntent();
            final String snum1 = intent.getStringExtra("num1");
            final String snum2 = intent.getStringExtra("num2");
            subnum1.setText("运算数1："+snum1);
            subnum2.setText("运算数2："+snum2);

            subbt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*String uriString3 = subnum1.getText().toString();
                    String uriString4 = subnum2.getText().toString();
                    Uri subdata = Uri.parse(sub(uriString3,uriString4));
                    Intent result = new Intent(null, subdata);
                    setResult(RESULT_OK, result);
                    finish();*/

          /*          String s1 = num1.getText().toString();
                    String s2 = num2.getText().toString();*/
                    Intent intent = getIntent();
                    String result2 = sub(snum1,snum2);
                    /*Intent intent = new Intent();*/
                    intent.putExtra("result2", result2);


                    /*  调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                     */

                    setResult(RESULT_OK, intent);
                    //    结束当前这个Activity对象的生命
                    finish();
                }
            });
            subbt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setResult(RESULT_CANCELED, null);
                    finish();
                }
            });


        }
    public static String sub(String sub1, String... sub2) {

        String v1;

        try {

            // 去掉千位分割符

            v1 = new DecimalFormat().parse(sub1).toString();

            // 用字符串构造BigDecimal

            BigDecimal sum = new BigDecimal(v1);

            // 减法计算

            for (String v2 : sub2) {

                v2 = new DecimalFormat().parse(v2).toString();

                sum = sum.subtract(new BigDecimal(v2));

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

    /*int SUBACTIVITY2 = 2;
    Uri uri = Uri.parse("content://contacts/people");
    Intent intent = new Intent(Intent,ACTION_PICK,uri);
    startActivityForResult(intent,SUBACTIVITY2);*/
}
