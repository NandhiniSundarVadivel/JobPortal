package com.jobportal.jobseeker.seeker.JobPortalIntroAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;


public class BegainAdapter extends PagerAdapter {

    private String [] titleText;
    private String [] explainText;
    private Context mcontext;
    LinearLayout linearImage;
    private LayoutInflater inflater;
    TextView text_titile,text_explain;





    public BegainAdapter(Context context){
        this.mcontext = context;
        inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        titleText = mcontext.getResources().getStringArray(R.array.begain_title);

    }
    @Override
    public int getCount() {
        return this.titleText.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;

        View viewLayout = inflater.inflate(R.layout.activity_begain_adapter, container, false);
        text_titile = (TextView) viewLayout.findViewById(R.id.txtTitle);



        text_titile.setText(titleText[position]);



        ((ViewPager) container).addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
