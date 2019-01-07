package com.darcos.julie.moodtracker.Controller;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.darcos.julie.moodtracker.R;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    private ArrayList<String> mDayMood = MainActivity.getTabDayMood();
    private ArrayList<String> mComment = MainActivity.getTabComment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // create 3 list and connect button layout and view

        ArrayList<RelativeLayout> listLayout = new ArrayList<>();
        ArrayList<Button> listButton = new ArrayList<>();

        RelativeLayout mLayout1 = this.findViewById(R.id.activity_history_7_jours_layout);
        RelativeLayout mLayout2 = this.findViewById(R.id.activity_history_6_jours_layout);
        RelativeLayout mLayout3 = this.findViewById(R.id.activity_history_5_jours_layout);
        RelativeLayout mLayout4 = this.findViewById(R.id.activity_history_4_jours_layout);
        RelativeLayout mLayout5 = this.findViewById(R.id.activity_history_3_jours_layout);
        RelativeLayout mLayout6 = this.findViewById(R.id.activity_history_2_jours_layout);
        RelativeLayout mLayout7 = this.findViewById(R.id.activity_history_1_jours_layout);
        Button mButton1 = findViewById(R.id.activity_history_7_jours_btn);
        Button mButton2 = findViewById(R.id.activity_history_6_jours_btn);
        Button mButton3 = findViewById(R.id.activity_history_5_jours_btn);
        Button mButton4 = findViewById(R.id.activity_history_4_jours_btn);
        Button mButton5 = findViewById(R.id.activity_history_3_jours_btn);
        Button mButton6 = findViewById(R.id.activity_history_2_jours_btn);
        Button mButton7 = findViewById(R.id.activity_history_1_jours_btn);
        listLayout.add(mLayout7);
        listButton.add(mButton7);
        listLayout.add(mLayout6);
        listButton.add(mButton6);
        listLayout.add(mLayout5);
        listButton.add(mButton5);
        listLayout.add(mLayout4);
        listButton.add(mButton4);
        listLayout.add(mLayout3);
        listButton.add(mButton3);
        listLayout.add(mLayout2);
        listButton.add(mButton2);
        listLayout.add(mLayout1);
        listButton.add(mButton1);


        this.layoutConstructor(listLayout, listButton);

    }


    // choose color of layout in term of mood and change dimmention of layout
    public void colorOfLayout(RelativeLayout r1, String mood) {
        ViewGroup.LayoutParams layoutParams = r1.getLayoutParams();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        if (mood == null) {
            r1.setBackgroundColor(Color.rgb(255, 255, 255));
        } else {
            switch (mood) {
                case "superHappy":
                    r1.setBackgroundColor(getResources().getColor(R.color.banana_yellow));
                    break;
                case "happy":
                    r1.setBackgroundColor(getResources().getColor(R.color.light_sage));
                    layoutParams.width = ((metrics.widthPixels) * 8) / 10;
                    r1.setLayoutParams(layoutParams);
                    break;
                case "normal":
                    r1.setBackgroundColor(getResources().getColor(R.color.cornflower_blue_65));
                    layoutParams.width = ((metrics.widthPixels) * 6) / 10;
                    r1.setLayoutParams(layoutParams);
                    break;
                case "disappointed":
                    r1.setBackgroundColor(getResources().getColor(R.color.warm_grey));
                    layoutParams.width = ((metrics.widthPixels) * 5) / 10;
                    r1.setLayoutParams(layoutParams);
                    break;
                case "sad":
                    r1.setBackgroundColor(getResources().getColor(R.color.faded_red));

                    layoutParams.width = ((metrics.widthPixels) * 4) / 10;
                    r1.setLayoutParams(layoutParams);
                    break;
                case "":
                    r1.setBackgroundColor(getResources().getColor(R.color.faded_red));
                    break;
                default:

            }

        }
    }

    //if they are not comment put button invisible
    public void buttonVisibility(Button b, final String comment) {
        if (comment == null) {
            b.setVisibility(View.INVISIBLE);
        } else {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, comment, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    //constructor of different layout
    public void layoutConstructor(ArrayList<RelativeLayout> listLayout, ArrayList<Button> listButton) {

        for (int i = 1; i <= listLayout.size(); i++) {
            colorOfLayout(listLayout.get(i - 1), this.mDayMood.get(i));
            buttonVisibility(listButton.get(i - 1), this.mComment.get(i));
        }
    }

}
