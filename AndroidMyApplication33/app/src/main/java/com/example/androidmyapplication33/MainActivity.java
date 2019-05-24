package com.example.androidmyapplication33;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int ADDACTIVITY = 1;
    private static final int SUBACTIVITY = 2;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* textView=(TextView)findViewById(R.id.textShow);*/
        result = (TextView) findViewById(R.id.result);
        final Button addbt = (Button) findViewById(R.id.addbt);
        final Button subbt = (Button) findViewById(R.id.subbt);
        final EditText num1= (EditText) findViewById(R.id.num1);
        final EditText num2= (EditText) findViewById(R.id.num2);

        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        AddActivity.class);

                String num_1=num1.getText().toString();
                String num_2=num2.getText().toString();
                intent.putExtra("num1",num_1);
                intent.putExtra("num2",num_2);

                /* intent.putExtra("message", num1.getText().toString().trim() + " + " + num2.getText().toString().trim() + " = ?");*/

                startActivityForResult(intent, ADDACTIVITY);
                /*MainActivity.this.startActivity(intent);*/

            }
        });

        subbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        SubActivity.class);
                /*Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(":////));*/
                String num_1=num1.getText().toString();
                String num_2=num2.getText().toString();
                intent.putExtra("num1",num_1);
                intent.putExtra("num2",num_2);


                /*  intent.putExtra("message", num1.getText().toString().trim() + " - " + num2.getText().toString().trim() + " = ?");*/
                startActivityForResult(intent, SUBACTIVITY);
                /*MainActivity.this.startActivity(intent);*/
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        result = (TextView) findViewById(R.id.result);

        switch (requestCode) {
            case ADDACTIVITY:
                if (resultCode == RESULT_OK) {
                    /*Uri uriData = data.getData();
                    result.setText(uriData.toString());*/
                    /*String result_value = data.getStringExtra("result");
                    result.setText(result_value);*/
                    //Intent intent = getIntent();
                    String addresult = data.getStringExtra("result1");
                    result.setText(addresult);

                }
                break;
            case SUBACTIVITY:
                if (resultCode == RESULT_OK) {
                    /*String result_value = data.getStringExtra("result");
                    result.setText(result_value);*/
                    String subresult = data.getStringExtra("result2");
                    result.setText(subresult);
                }
                break;
        }
    }
}

