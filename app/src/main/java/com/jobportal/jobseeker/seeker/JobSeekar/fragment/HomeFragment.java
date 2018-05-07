package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jobportal.jobseeker.seeker.JobSeekar.HomeDetailsActivity;
import com.jobportal.jobseeker.seeker.JobSeekar.adapter.HomeFragmentAdapter;
import com.jobportal.jobseeker.seeker.R;
import com.synnapps.carouselview.CarouselView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by uniflyn on 28/4/18.
 */

public class HomeFragment extends Fragment {

    View roootView;
    @BindView(R.id.btn_location)
    Button btnLocation;
    @BindView(R.id.btn_search_job)
    Button btnSearchJob;
    @BindView(R.id.pager)
    ViewPager pager;
    Unbinder unbinder;
    @BindView(R.id.carouselView)
    CarouselView carouselView;

    int NUMBER_OF_PAGES = 4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        roootView = inflater.inflate(R.layout.fragment_home, container, false);


        unbinder = ButterKnife.bind(this, roootView);

      /*  carouselView.setPageCount(NUMBER_OF_PAGES);
        // set ViewListener for custom view
        carouselView.setViewListener(viewListener);*/


        final HomeFragmentAdapter adapter1 = new HomeFragmentAdapter(getContext(), new HomeFragmentAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.e("postion",position+"");
                String posi = String.valueOf(position);

                Intent intent = new Intent(getContext(), HomeDetailsActivity.class);
                intent.putExtra("pos",posi);
                startActivity(intent);


            }
        });
        pager.setAdapter(adapter1);


//        pageControl.setPosition(1);
/*
        tabLayout.setupWithViewPager(pager, true);
*/
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int width = pager.getWidth();
                pager.scrollTo((int) (width * position + width * positionOffset), 0);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("activity", "2");

                // pos = position;
//                imageView.setImageDrawable(getResources().getDrawable(image[position]));
                //   imageSelected.setImageDrawable(getResources().getDrawable(imageSelect[position]));
                Log.e("countadapter", String.valueOf(adapter1.getCount()));
                //  Log.e("pos", String.valueOf(pos));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return roootView;
    }


  /*  ViewListener viewListener = new ViewListener() {

        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.fragment_adpter_layout, null);
            //set view attributes here

            return customView;
        }
    };*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_location, R.id.btn_search_job})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_location:
                break;
            case R.id.btn_search_job:
                break;
        }
    }
}
