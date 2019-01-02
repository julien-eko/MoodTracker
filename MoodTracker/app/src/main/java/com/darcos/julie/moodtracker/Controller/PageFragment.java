package com.darcos.julie.moodtracker.Controller;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.darcos.julie.moodtracker.R;


public class PageFragment extends Fragment implements View.OnClickListener {

    // 1 - Create keys for our Bundle
    private static final String KEY_POSITION = "position";
    private static final String KEY_COLOR = "color";
    //2 - Declare callback
    private OnButtonClickedListener mCallback;


    // 1 - Declare our interface that will be implemented by any container activity
    public interface OnButtonClickedListener {
        void onButtonClicked(View view);
    }

    public PageFragment() {
    }


    // 2 - Method that will create a new instance of PageFragment, and add data to its bundle.
    public static PageFragment newInstance(int position, int color) {

        // 2.1 Create new fragment
        PageFragment frag = new PageFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);

        return (frag);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 3 - Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_page, container, false);
        Button addComment =result.findViewById(R.id.addComment);
        Button history =result.findViewById(R.id.history);
        Button pieChart =result.findViewById(R.id.pie_chart);

        addComment.setOnClickListener(this);
        history.setOnClickListener(this);
        pieChart.setOnClickListener(this);
        addComment.setTag(0);
        history.setTag(1);
        pieChart.setTag(2);

        // 4 - Get widgets from layout and serialise it
        RelativeLayout rootView =result.findViewById(R.id.fragment_page_rootview);
        ImageView img =result.findViewById(R.id.imageView);

        // 5 - Get data from Bundle (created in method newInstance)
        assert getArguments() != null;
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it
        rootView.setBackgroundColor(color);

        this.drawImage(position,img);

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
    private void createCallbackToParentActivity() {
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString() + " must implement OnButtonClickedListener");
        }


    }

    //add smiley in terms of pagefragment selectioned
    public void drawImage(int position, ImageView img) {
        switch (position) {
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
    }

}