package com.jobportal.jobseeker.seeker.JobSeekar.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;


public class MyPagerAdapter extends PagerAdapter{

    Context context;
    int[] listItems;
    int adapterType;
    String[] string1;
    CustomItemClickListener listener;

    public MyPagerAdapter(Context context, String[] listItems,CustomItemClickListener itemClickListener) {
        this.context = context;
        this.string1 = listItems;
        this.adapterType=adapterType;
        this.listener = itemClickListener;
    }
    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        try {

            TextView textview = (TextView)view.findViewById(R.id.txt_item);
//            LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.linnearBack);
            ImageView imageView = (ImageView)view.findViewById(R.id.imgBanner);


         //  view.setBackgroundResource(R.drawable.bg_home_image);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, position);
                }
            });
          /*  switch (adapterType)
            {
                case MainActivityOne.ADAPTER_TYPE_TOP:
                    linMain.setBackgroundResource(R.drawable.shadow);
                    break;
                case MainActivityOne.ADAPTER_TYPE_BOTTOM:
                    linMain.setBackgroundResource(0);
                    break;
            }*/
            textview.setText(string1[position]);
          /*  Glide.with(context)
                    .load(listItems[position])
                    .into(imageCover);*/

            container.addView(view);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return string1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

}