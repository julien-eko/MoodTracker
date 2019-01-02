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

    private ArrayList<String> mDayMood =MainActivity.getTabDayMood();
    private ArrayList<String> mComment =MainActivity.getTabComment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // create 3 list and connect button layout and view

        ArrayList<RelativeLayout> listLayout =new ArrayList<>();
        ArrayList<Button> listButton = new ArrayList<>();
        ArrayList<View> listView =new ArrayList<>();

        RelativeLayout mLayout1 = this.findViewById(R.id.layout1);
        RelativeLayout mLayout2 =this.findViewById(R.id.layout2);
        RelativeLayout mLayout3 =this.findViewById(R.id.layout3);
        RelativeLayout mLayout4 =this.findViewById(R.id.layout4);
        RelativeLayout mLayout5 =this.findViewById(R.id.layout5);
        RelativeLayout mLayout6 =this.findViewById(R.id.layout6);
        RelativeLayout mLayout7 =this.findViewById(R.id.layout7);
        Button mButton1=findViewById(R.id.Comment1);
        Button mButton2=findViewById(R.id.Comment2);
        Button mButton3=findViewById(R.id.Comment3);
        Button mButton4=findViewById(R.id.Comment4);
        Button mButton5=findViewById(R.id.Comment5);
        Button mButton6=findViewById(R.id.Comment6);
        Button mButton7=findViewById(R.id.Comment7);
        View view1 = findViewById(R.id.layout1);
        View view2 = findViewById(R.id.layout2);
        View view3 = findViewById(R.id.layout3);
        View view4 = findViewById(R.id.layout4);
        View view5 = findViewById(R.id.layout5);
        View view6 = findViewById(R.id.layout6);
        View view7 = findViewById(R.id.layout7);
        listLayout.add(mLayout7);listButton.add(mButton7);listView.add(view7);
        listLayout.add(mLayout6);listButton.add(mButton6);listView.add(view6);
        listLayout.add(mLayout5);listButton.add(mButton5);listView.add(view5);
        listLayout.add(mLayout4);listButton.add(mButton4);listView.add(view4);
        listLayout.add(mLayout3);listButton.add(mButton3);listView.add(view3);
        listLayout.add(mLayout2);listButton.add(mButton2);listView.add(view2);
        listLayout.add(mLayout1);listButton.add(mButton1);listView.add(view1);

        this.layoutConstructor(listLayout,listButton,listView);

    }


    // choose color of layout in term of mood and change dimmention of layout
    public void colorOfLayout(RelativeLayout r1,String mood,View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        if (mood == null) {
            r1.setBackgroundColor(Color.rgb(255,255,255));
        } else {
            switch (mood) {
                case "superHappy":
                    r1.setBackgroundColor(getResources().getColor(R.color.banana_yellow));
                    break;
                case "happy":
                    r1.setBackgroundColor(getResources().getColor(R.color.light_sage));
                    layoutParams.width = ((metrics.widthPixels)*8)/10 ;
                    view.setLayoutParams(layoutParams);
                    break;
                case "normal":
                    r1.setBackgroundColor(getResources().getColor(R.color.cornflower_blue_65));
                    layoutParams.width = ((metrics.widthPixels)*6)/10 ;
                    view.setLayoutParams(layoutParams);
                    break;
                case "disappointed":
                    r1.setBackgroundColor(getResources().getColor(R.color.warm_grey));
                    layoutParams.width = ((metrics.widthPixels)*5)/10 ;
                    view.setLayoutParams(layoutParams);
                    break;
                case "sad":
                    r1.setBackgroundColor(getResources().getColor(R.color.faded_red));

                    layoutParams.width = ((metrics.widthPixels)*4)/10 ;
                    view.setLayoutParams(layoutParams);
                    break;
                case "":
                    r1.setBackgroundColor(getResources().getColor(R.color.faded_red));
                    break;
                default:

            }

        }
    }

    //if they are not comment put button invisible
    public void buttonVisibility(Button b, final String comment){
        if(comment==null){
            b.setVisibility(View.INVISIBLE);
        }
        else{
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(History.this, comment, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    //constructor of different layout
    public void layoutConstructor(ArrayList<RelativeLayout> listLayout,ArrayList<Button> listButton,ArrayList<View> listView){

        for(int i=1;i<=listLayout.size();i++){
            colorOfLayout(listLayout.get(i-1),this.mDayMood.get(i),listView.get(i-1));
            buttonVisibility(listButton.get(i-1),this.mComment.get(i));
        }
    }

}
