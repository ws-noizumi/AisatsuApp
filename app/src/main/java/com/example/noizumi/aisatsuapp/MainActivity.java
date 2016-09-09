package com.example.noizumi.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.text.format.DateFormat;

import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }


    private void showTimePickerDialog() {
        long now = System.currentTimeMillis();
        // システム時間を取得
        int nowHour    = Integer.parseInt(DateFormat.format("k",now).toString());
        int nowMinutes = Integer.parseInt(DateFormat.format("m",now).toString());

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        int serialTime = hourOfDay * 100 + minute;

                        if(serialTime>=200 && serialTime<=959) {
                            mTextView.setText("おはよう");
                        }
                        if(serialTime>=1000 && serialTime<=1759) {
                            mTextView.setText("こんにちは");
                        }
                        if((serialTime>=1800 && serialTime<=2359)||(serialTime>=0 && serialTime<=159)) {
                            mTextView.setText("こんばんは");
                        }

                    }
                },
                nowHour, // 初期値（時間）
                nowMinutes,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

}
