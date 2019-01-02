package com.darcos.julie.moodtracker.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.darcos.julie.moodtracker.R;
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
        this.pieChartConfigure(pieChart);


    }
    //create a pie chart
    public void pieChartConfigure(PieChart pieChart){

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

        PieDataSet pieDataSet =new PieDataSet(value,"Mood");

        PieData pieData=new PieData(pieDataSet);

        pieChart.setData(pieData);

        ArrayList<Integer> col= new ArrayList<>();
        col.add(getResources().getColor(R.color.banana_yellow));
        col.add(getResources().getColor(R.color.light_sage));
        col.add(getResources().getColor(R.color.cornflower_blue_65));
        col.add(getResources().getColor(R.color.warm_grey));
        col.add(getResources().getColor(R.color.faded_red));

        pieDataSet.setColors(col);
    }

    //counter different mood and add in list (0 mood superhappy,1 mood happy,2mood normal,3mood disapointed,4mood sad)
    public ArrayList<Float> counterMood(){
        ArrayList<Float> list = new ArrayList<>();
        Float superHappy = 0f;
        Float happy =0f;
        Float normal=0f;
        Float disappointed=0f;
        Float sad=0f;

        for (int i=1;i<hundredMood.size();i++){
            String mood= hundredMood.get(i);

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
        }

        list.add(superHappy);
        list.add(happy);
        list.add(normal);
        list.add(disappointed);
        list.add(sad);
        return list;
    }
}
