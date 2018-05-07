package com.jobportal.jobseeker.seeker.JobSeekar.adapter;

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


public class HomeFragmentAdapter extends PagerAdapter {

    private String [] titleText;
    private String [] explainText;
    private Context mcontext;
    LinearLayout linearImage;
    private LayoutInflater inflater;
    TextView text_titile,text_explain;
    CustomItemClickListener listener;




    public HomeFragmentAdapter(Context context,CustomItemClickListener itemClickListener){
        this.mcontext = context;
        inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        titleText = mcontext.getResources().getStringArray(R.array.begain_title_two);
        this.listener = itemClickListener;
    }
    @Override
    public int getCount() {
        return this.titleText.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }
    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imgDisplay;

        View viewLayout = inflater.inflate(R.layout.fragment_adpter_layout, container, false);
        text_titile = (TextView) viewLayout.findViewById(R.id.txtTitle);



        text_titile.setText(titleText[position]);

        viewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, position);
            }
        });


        ((ViewPager) container).addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
