package com.darcos.julie.moodtracker;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements PageFragment.OnButtonClickedListener {
    private Button mHistory;
    private Button mComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //3 - Configure ViewPager

        this.configureViewPager();
    }
    private void configureViewPager() {
        // 1 - Get ViewPager from layout

        VerticalViewPager pager = (VerticalViewPager) findViewById(R.id.activity_main_viewpager);

        // 2 - Set Adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)) {
        });
    }
    @Override
    public void onButtonClicked(View view) {
        //Log.e(getClass().getSimpleName(),"Button clicked !");
        int responseIndex = (int) view.getTag();
        if (responseIndex == 1) {
            startActivity(new Intent(this, History.class));
        }
        if (responseIndex == 0){
            

        }
    }

}