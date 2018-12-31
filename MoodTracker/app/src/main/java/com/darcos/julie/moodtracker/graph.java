package com.darcos.julie.moodtracker;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class graph extends AppCompatActivity {

    private ArrayList<String> hundredMood =MainActivity.getHundredLastMood();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


        PieChart pieChart = findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        Description desc=new Description();
        desc.setText("Mood");
        desc.setTextSize(20f);

        pieChart.setDescription(desc);

        pieChart.setHoleRadius(0f);
        pieChart.setTransparentCircleRadius(0f);
        ArrayList<Float> list=counterMood();
        List<PieEntry> value =new ArrayList<>();
        value.add(new PieEntry(list.get(0),"Super Happy"));
        value.add(new PieEntry(list.get(1),"Happy"));
        value.add(new PieEntry(list.get(2),"Normal"));
        value.add(new PieEntry(list.get(3),"Disappointed"));
        value.add(new PieEntry(list.get(4),"Sad"));
        value.add(new PieEntry(list.get(5),"No mood"));

        PieDataSet pieDataSet =new PieDataSet(value,"Mood");

        PieData pieData=new PieData(pieDataSet);

        pieChart.setData(pieData);

        ArrayList<Integer> col=new ArrayList<Integer>();
        col.add(getResources().getColor(R.color.banana_yellow));
        col.add(getResources().getColor(R.color.light_sage));
        col.add(getResources().getColor(R.color.cornflower_blue_65));
        col.add(getResources().getColor(R.color.warm_grey));
        col.add(getResources().getColor(R.color.faded_red));
        col.add(Color.rgb(0,0,0));

        pieDataSet.setColors(col);
        //ArrayList<Float> list=counterMood();

        Toast.makeText(graph.this, Float.toString(list.get(0)), Toast.LENGTH_SHORT).show();
        //Toast.makeText(graph.this, hundredMood.get(2), Toast.LENGTH_SHORT).show();




    }



    public ArrayList<Float> counterMood(){
        ArrayList<Float> list = new ArrayList<Float>();
        Float superHappy = 0f;
        Float happy =0f;
        Float normal=0f;
        Float disappointed=0f;
        Float sad=0f;
        Float nothing=0f;


        for (int i=1;i<hundredMood.size();i++){
            String mood= hundredMood.get(i);
            //String mood ="happy";

            if(mood != null && mood.equals("superHappy"))
                superHappy=superHappy+1;
            if(mood != null && mood.equals("happy"))
                happy=happy+1;
            if(mood != null && mood.equals("normal"))
                normal=normal+1;
            if(mood != null && mood.equals("disappointed"))
               disappointed=disappointed+1;
            if(mood != null && mood.equals("sad"))
                sad=sad+1;
            if(mood == null)
                nothing=nothing+1;
        }

        list.add(superHappy);
        list.add(happy);
        list.add(normal);
        list.add(disappointed);
        list.add(sad);
        list.add(nothing);
        return list;
    }
}
