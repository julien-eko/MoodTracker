package com.darcos.julie.moodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        TextView test = (TextView) findViewById(R.id.test) ;
        test.setText((CharSequence) User.getInstance().getDate());

    }
}
