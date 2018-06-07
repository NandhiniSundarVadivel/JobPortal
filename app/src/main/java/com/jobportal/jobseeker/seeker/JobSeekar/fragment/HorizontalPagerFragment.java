package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.jobportal.jobseeker.seeker.JobSeekar.HomeDetailsZoomActivity;
import com.jobportal.jobseeker.seeker.JobSeekar.adapter.HorizontalPagerAdapter;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by uniflyn on 14/5/18.
 */

public class HorizontalPagerFragment extends Fragment {
    float initialX, initialY;
    /*  @BindView(R.id.btnright)
      Button btnright;
      @BindView(R.id.btnleft)
      Button btnleft;*/
    Unbinder unbinder;
    int lastPage = 0;
    @BindView(R.id.viewGreen)
    View viewGreen;
    @BindView(R.id.viewRed)
    View viewRed;
    long lastDown;
    long lastDuration = 0;
    @BindView(R.id.framelayout)
    RelativeLayout framelayout;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_horizontal, container, false);
        unbinder = ButterKnife.bind(this, view);

        framelayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click11","1");

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click11","2");

                }

                return false;
            }
        });



     /*   btnleft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("left","left touch lis");
                return false;
            }
        });
        btnright.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("right","right touch list");
                return false;
            }
        });*/
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) view.findViewById(R.id.hicvp);
        horizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter(getContext(), false, new HorizontalPagerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String posi = String.valueOf(position);

                Intent intent = new Intent(getContext(), HomeDetailsZoomActivity.class);
                intent.putExtra("pos", posi);
                startActivity(intent);
            }
        }));


        horizontalInfiniteCycleViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("position", position+":::"+positionOffset + "::"+positionOffsetPixels);
                if(positionOffset==0){
                    viewGreen.setVisibility(View.GONE);
                    viewRed.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("onPageSelected", position + "");
                lastDown = System.currentTimeMillis();
                Log.e("click", "1"+lastDown);
                lastDuration = System.currentTimeMillis() - lastDown;
                Log.e("click", "2"+lastDuration);

                if (lastPage > position) {//User Move to left
                    lastPage = position;
                    Log.e("move", "lyes"+lastPage+"::"+position);//for me right
                 /*   viewGreen.setVisibility(View.GONE);
                    viewRed.setVisibility(View.VISIBLE); First change*/


                    viewGreen.setVisibility(View.VISIBLE);//Second change
                    viewRed.setVisibility(View.GONE);

                }else {

                    Log.e("move", "ryes"+lastPage+"::"+position);//for me left
                    lastPage = position;


                /*    viewGreen.setVisibility(View.VISIBLE);
                    viewRed.setVisibility(View.GONE);First Change*/

                    viewGreen.setVisibility(View.GONE);//Second change
                    viewRed.setVisibility(View.VISIBLE);
                }
                /*else if (lastPage < position) {//User Move to right
                    Log.e("move", "ryes");//for me left
                    lastPage = position;


                    viewGreen.setVisibility(View.VISIBLE);
                    viewRed.setVisibility(View.GONE);
                }*/

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("scroll",state+"");

            }
        });

/*
        horizontalInfiniteCycleViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();

                switch (action) {

                    case MotionEvent.ACTION_DOWN:
                        initialX = event.getX();
                        initialY = event.getY();

                        Log.e("down", "Action was DOWN");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        Log.d("move", "Action was MOVE");
                        break;

                    case MotionEvent.ACTION_UP:
                        float finalX = event.getX();
                        float finalY = event.getY();

                        Log.d("UP", "Action was UP");

                        if (initialX < finalX) {
                            Log.d("Right", "Left to Right swipe performed");
                        }

                        if (initialX > finalX) {
                            Log.d("Left", "Right to Left swipe performed");
                        }

                        if (initialY < finalY) {
                            Log.d("Down", "Up to Down swipe performed");
                        }

                        if (initialY > finalY) {
                            Log.d("up", "Down to Up swipe performed");
                        }

                        break;

                    case MotionEvent.ACTION_CANCEL:
                        Log.d("CANCEL","Action was CANCEL");
                        break;

                    case MotionEvent.ACTION_OUTSIDE:
                        Log.d("occurred", "Movement occurred outside bounds of current screen element");
                        break;
                }
                return true;
            }
        });
*/

//        horizontalInfiniteCycleViewPager.setScrollDuration(400);
//        horizontalInfiniteCycleViewPager.setPageDuration(1000);
//        horizontalInfiniteCycleViewPager.setInterpolator(
//                AnimationUtils.loadInterpolator(getContext(), android.R.anim.overshoot_interpolator)
//        );
//        horizontalInfiniteCycleViewPager.setMediumScaled(false);
//        horizontalInfiniteCycleViewPager.setMaxPageScale(0.8F);
//        horizontalInfiniteCycleViewPager.setMinPageScale(0.5F);
//        horizontalInfiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
//        horizontalInfiniteCycleViewPager.setMinPageScaleOffset(5.0F);
//        horizontalInfiniteCycleViewPager.setOnInfiniteCyclePageTransformListener();

//        horizontalInfiniteCycleViewPager.setCurrentItem(
//                horizontalInfiniteCycleViewPager.getRealItem() + 1
//        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
/*
    @OnClick({R.id.btnright, R.id.btnleft})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnright:
                break;
            case R.id.btnleft:
                break;
        }
    }*/
}