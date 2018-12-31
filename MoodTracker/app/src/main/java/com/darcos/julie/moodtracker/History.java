package com.darcos.julie.moodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class History extends AppCompatActivity {

    private ArrayList<String> mDayMood =MainActivity.getTabDayMood();
    private ArrayList<String> mComment =MainActivity.getTabComment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<RelativeLayout> listLayout =new ArrayList<RelativeLayout>();
        ArrayList<Button> listButton =new ArrayList<Button>();
        ArrayList<View> listView =new ArrayList<View>();

        RelativeLayout mLayout1 =(RelativeLayout) findViewById(R.id.layout1);
        RelativeLayout mLayout2 =(RelativeLayout) findViewById(R.id.layout2);
        RelativeLayout mLayout3 =(RelativeLayout) findViewById(R.id.layout3);
        RelativeLayout mLayout4 =(RelativeLayout) findViewById(R.id.layout4);
        RelativeLayout mLayout5 =(RelativeLayout) findViewById(R.id.layout5);
        RelativeLayout mLayout6 =(RelativeLayout) findViewById(R.id.layout6);
        RelativeLayout mLayout7 =(RelativeLayout) findViewById(R.id.layout7);
        Button mButton1=(Button) findViewById(R.id.Comment1);
        Button mButton2=(Button) findViewById(R.id.Comment2);
        Button mButton3=(Button) findViewById(R.id.Comment3);
        Button mButton4=(Button) findViewById(R.id.Comment4);
        Button mButton5=(Button) findViewById(R.id.Comment5);
        Button mButton6=(Button) findViewById(R.id.Comment6);
        Button mButton7=(Button) findViewById(R.id.Comment7);
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

        //mButton1.setVisibility(View.INVISIBLE);
        //View view = findViewById(R.id.layout1);
        //ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        //layoutParams.width = (layoutParams.width)/2 ;
        //view.setLayoutParams(layoutParams);

       


        this.layoutConstructor(listLayout,listButton,listView);


       //Toast.makeText(History.this, Integer.toString(metrics.widthPixels), Toast.LENGTH_SHORT).show();

    }



    public void colorOfLayout(RelativeLayout r1,String mood,View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        if (mood == null) {

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
    public void layoutConstructor(ArrayList<RelativeLayout> listLayout,ArrayList<Button> listButton,ArrayList<View> listView){

        for(int i=1;i<=listLayout.size();i++){
            colorOfLayout(listLayout.get(i-1),this.mDayMood.get(i),listView.get(i-1));
            buttonVisibility(listButton.get(i-1),this.mComment.get(i));
        }
    }

}
