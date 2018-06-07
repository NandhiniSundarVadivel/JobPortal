package com.jobportal.jobseeker.seeker.JobPortalIntroAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import java.lang.reflect.Field;


public class BegainAdapter extends PagerAdapter {

    private String [] titleText;
    private String [] explainText;
    private Context mcontext;
    LinearLayout linearImage;
    private LayoutInflater inflater;
    TextView text_titile,text_explain;
    ImageView imageCenrter;

    private Integer[] imageSelectBanner = new Integer[]{
            R.drawable.slider_one_chg,
            R.drawable.slider_two_chng,
            R.drawable.slider_three_chng,
            R.drawable.slider_match_chng,
            R.drawable.slider_four_chng,
            R.drawable.slider_five_chng

    };



    public BegainAdapter(Context context){
        this.mcontext = context;
        inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        titleText = mcontext.getResources().getStringArray(R.array.begain_title);
        setMyScroller();

    }

    private void setMyScroller() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new MyScroller(mcontext));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MyScroller extends Scroller {
        public MyScroller(Context context) {
            super(context, new DecelerateInterpolator());
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, 1000 /*1 secs*/);
        }
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
        imageCenrter = (ImageView)viewLayout.findViewById(R.id.imageCenter);

        imageCenrter.setBackgroundDrawable(mcontext.getResources().getDrawable(imageSelectBanner[position]));

        text_titile.setText(titleText[position]);



        ((ViewPager) container).addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
