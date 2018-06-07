package com.jobportal.jobseeker.seeker.JobSeekar.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jobportal.jobseeker.seeker.R;
import com.jobportal.jobseeker.seeker.utils.Utils;

import static com.jobportal.jobseeker.seeker.utils.Utils.setupItem;

/**
 * Created by uniflyn on 14/5/18.
 */

public class VerticalPagerAdapter extends PagerAdapter {

    private final Utils.LibraryObject[] TWO_WAY_LIBRARIES = new Utils.LibraryObject[]{
            new Utils.LibraryObject(

                    "Android Developer"

            ),
            new Utils.LibraryObject(

                    "Web Designer"

            ),
            new Utils.LibraryObject(

                    "ios Developer"

            ),
            new Utils.LibraryObject(

                    "PHP Developer"

            ),
            new Utils.LibraryObject(

                    "PHP Developer"

            ),
            new Utils.LibraryObject(

                    "PHP Developer"

            )
    };

    private LayoutInflater mLayoutInflater;

    public VerticalPagerAdapter(final Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return TWO_WAY_LIBRARIES.length;
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view = mLayoutInflater.inflate(R.layout.item, container, false);

        setupItem(view, TWO_WAY_LIBRARIES[position]);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
