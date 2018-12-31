package com.darcos.julie.moodtracker;


import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public  class PageFragment extends Fragment implements View.OnClickListener {

    // 1 - Create keys for our Bundle
    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";
    //2 - Declare callback
    private OnButtonClickedListener mCallback;
    private ViewPager.OnPageChangeListener mPageCHange;
    private Button mHistory;
    private Button mAddComment;
    private Button mPieChart;
    private int numPage;



    // 1 - Declare our interface that will be implemented by any container activity
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }

    public PageFragment() { }


    // 2 - Method that will create a new instance of PageFragment, and add data to its bundle.
    public static PageFragment newInstance(int position, int color) {

        // 2.1 Create new fragment
        PageFragment frag = new PageFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);

        return(frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 3 - Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_page, container, false);
        mAddComment= (Button) result.findViewById(R.id.addComment);
        mHistory = (Button) result.findViewById(R.id.history);
        mPieChart = (Button) result.findViewById(R.id.pie_chart);

        mAddComment.setOnClickListener(this);
        mHistory.setOnClickListener(this);
        mPieChart.setOnClickListener(this);
        mAddComment.setTag(0);
        mHistory.setTag(1);
        mPieChart.setTag(2);
        //result.findViewById(R.id.history).setOnClickListener(this);





        // 4 - Get widgets from layout and serialise it
        RelativeLayout rootView= (RelativeLayout) result.findViewById(R.id.fragment_page_rootview);
        ImageView img = (ImageView) result.findViewById(R.id.imageView);


        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it
        rootView.setBackgroundColor(color);

        switch (position)
        {
            case 0:
                img.setImageDrawable(getResources().getDrawable(R.drawable.smiley_super_happy));

                break;
            case 1:
                img.setImageDrawable(getResources().getDrawable(R.drawable.smiley_happy));
                break;
            case 2:
                img.setImageDrawable(getResources().getDrawable(R.drawable.smiley_normal));
                break;
            case 3:
                img.setImageDrawable(getResources().getDrawable(R.drawable.smiley_disappointed));
                break;
            case 4:
                img.setImageDrawable(getResources().getDrawable(R.drawable.smiley_sad));
                break;
            default:

        }


        //Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);







        return result;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }
    @Override
    public void onClick(View v) {
        // 5 - Spread the click to the parent activity
        mCallback.onButtonClicked(v);
    }


    // 3 - Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
        

    }


}