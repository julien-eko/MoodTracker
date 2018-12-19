package com.darcos.julie.moodtracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements PageFragment.OnButtonClickedListener {
    private Button mHistory;
    private Button mComment;
    private String m_Text ="";

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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Comementaire");

// Set up the input
            final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
            builder.setView(input);

// Set up the buttons
            builder.setPositiveButton("VALIDER", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                }
            });
            builder.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();

        }
    }

}