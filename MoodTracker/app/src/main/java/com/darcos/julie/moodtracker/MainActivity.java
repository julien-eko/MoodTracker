package com.darcos.julie.moodtracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements PageFragment.OnButtonClickedListener {


    private static ArrayList<String> tabDayMood ;
    private static ArrayList<String> tabComment ;
    private static ArrayList<String> hundredLastMood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //3 - Configure ViewPager

        this.configureViewPager();

        //Toast.makeText(this, "test!",
          //      Toast.LENGTH_LONG).show();

    }



    private void configureViewPager() {
        // 1 - Get ViewPager from layout

        VerticalViewPager pager = (VerticalViewPager) findViewById(R.id.activity_main_viewpager);
        pager.addOnPageChangeListener(listener);
        // 2 - Set Adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)) {
        });
    }
    @Override
    public void onButtonClicked(View view) {
        //Log.e(getClass().getSimpleName(),"Button clicked !");
        int responseIndex = (int) view.getTag();
        if (responseIndex == 2) {
            hundredLastMood=lastMood(100);
            Intent pieChart = new Intent(MainActivity.this, graph.class);
            startActivity(pieChart);
        }
        if (responseIndex == 1) {
            tabDayMood =lastMood(7);
            tabComment=sevenLastComment();
            Intent history = new Intent(MainActivity.this, History.class);
            startActivity(history);
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
                    SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Comment"+User.getInstance().dateToString(new Date()), input.getText().toString());
                    editor.apply();
                    //User.getInstance().setDayComment(input.getText().toString());
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




    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    User.getInstance().setDayMood("superHappy");
                    break;
                case 1:
                    User.getInstance().setDayMood("happy");
                    break;
                case 2:
                    User.getInstance().setDayMood("normal");
                    break;
                case 3:
                    User.getInstance().setDayMood("disappointed");
                    break;
                case 4:
                    User.getInstance().setDayMood("sad");
                    break;
                default:

            }
                    SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Mood"+User.getInstance().dateToString(new Date()), User.getInstance().getDayMood());
                    editor.apply();

                    //String dayMood = getPreferences(MODE_PRIVATE).getString("Comment20181227", null);
                    //Toast.makeText(MainActivity.this, dayMood, Toast.LENGTH_SHORT).show();
            //tabDayMood =sevenLastMood1();
            //Toast.makeText(MainActivity.this, test.get(0), Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public ArrayList<String> lastMood(int nbMood)  {
        String mood ;
        ArrayList<String> list =new ArrayList<String>();

        Date d=new Date() ;
        String s ;
        while(list.size()<(nbMood+1) ){
            s =User.getInstance().dateToString(d);
            mood=getPreferences(MODE_PRIVATE).getString("Mood"+s,null);
            list.add(mood);
            d=User.getInstance().stringToDate(s);
            d=User.getInstance().removeOneDay(d);

        }


        return list;
    }

    public ArrayList<String> sevenLastComment()  {
        String comment ;
        ArrayList<String> list =new ArrayList<String>();

        Date d=new Date() ;
        String s ;
        while(list.size()<8 ){
            s =User.getInstance().dateToString(d);
            comment=getPreferences(MODE_PRIVATE).getString("Comment"+s,null);
            list.add(comment);
            d=User.getInstance().stringToDate(s);
            d=User.getInstance().removeOneDay(d);

        }


        return list;
    }

    public static ArrayList<String> getTabDayMood() {
        return tabDayMood;
    }

    public static ArrayList<String> getTabComment() {
        return tabComment;
    }

    public static ArrayList<String> getHundredLastMood() {
        return hundredLastMood;
    }

}