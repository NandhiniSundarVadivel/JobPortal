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
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.adapter.MainPagerAdapter;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * Created by uniflyn on 28/4/18.
 */

public class HomeFragment extends Fragment {

    View roootView;
    @BindView(R.id.btn_location)
    Button btnLocation;
    @BindView(R.id.btn_search_job)
    Button btnSearchJob;

    Unbinder unbinder;

    @BindView(R.id.edtSearchText)
    EditText edtSearchText;
    int NUMBER_OF_PAGES = 4;

    String[] strings = {"Android Developer", "Web Designer", "ios Developer"};
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;

    private int PLACE_AUTOCOMPLETE_REQUEST_CODE = 200;
    String latitude = "", longitude = "", location;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        roootView = inflater.inflate(R.layout.fragment_home, container, false);


        unbinder = ButterKnife.bind(this, roootView);

        final ViewPager viewPager = (ViewPager) roootView.findViewById(R.id.vp_main);

        viewPager.setAdapter(new MainPagerAdapter(getFragmentManager()));




       /* MyPagerAdapter adapterBackground = new MyPagerAdapter(getActivity(), strings, new MyPagerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });
        viewPager.setAdapter(adapterBackground);*/


      /*  viewpagerTop.setClipChildren(false);
        viewpagerTop.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.pager_margin));
        viewpagerTop.setOffscreenPageLimit(3);
        viewpagerTop.setPageTransformer(false, new CarouselEffectTransformer(getActivity()));*/
        //setupViewPager();


/*
        pager.setAdapter(new MainPagerAdapter(getFragmentManager()));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("position2",position+"");
            }

            @Override
            public void onPageSelected(int position) {

                Log.e("position1",position+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("position",state+"");
            }
        });*/

      /*  carouselView.setPageCount(NUMBER_OF_PAGES);
        // set ViewListener for custom view
        carouselView.setViewListener(viewListener);*/


       /* final HomeFragmentAdapter adapter1 = new HomeFragmentAdapter(getContext(), new HomeFragmentAdapter.CustomItemClickListener() {
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
*//*
        tabLayout.setupWithViewPager(pager, true);
*//*
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
*/
        return roootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        SupportPlaceAutocompleteFragment autocompleteFragment = null;
        try {
            autocompleteFragment = (SupportPlaceAutocompleteFragment) getChildFragmentManager().findFragmentById(R.id.place_autocomplete);

            AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                    .setTypeFilter(Place.TYPE_COUNTRY)
                    .build();
            autocompleteFragment.setFilter(typeFilter);
           /* ImageView searchicon = (ImageView) ((LinearLayout) autocompleteFragment.getView()).getChildAt(0);
            searchicon.setImageDrawable(null);
            autocompleteFragment.setHint("");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                try {
                    Log.e("Place1nan: ", String.valueOf(place.getName()));//get place details here
                    Log.e("lat", String.valueOf(place.getLatLng().latitude + "," + place.getLatLng().longitude));
                    location = String.valueOf(place.getName());
                    latitude = String.valueOf(place.getLatLng().latitude);
                    longitude = String.valueOf(place.getLatLng().longitude);


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(Status status) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    Place place = PlaceAutocomplete.getPlace(getContext(), data);
                    Log.e("Place:", place.toString());
                } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                    Status status = PlaceAutocomplete.getStatus(getContext(), data);
                    Log.e("gfj", status.getStatusMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupViewPager() {
        // Set Top ViewPager Adapter
          /*  MyPagerAdapter adapter = new MyPagerAdapter(getActivity(), strings, new MyPagerAdapter.CustomItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    String posi = String.valueOf(position);

                    Intent intent = new Intent(getContext(), HomeDetailsActivity.class);
                    intent.putExtra("pos", posi);
                    startActivity(intent);
                }
            });
            viewpagerTop.setAdapter(adapter);*/

        // Set Background ViewPager Adapter

/*
        viewpagerTop.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int index = 0;

            @Override
            public void onPageSelected(int position) {
                index = position;

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int width = viewPagerbackground.getWidth();
                viewPagerbackground.scrollTo((int) (width * position + width * positionOffset), 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    viewPagerbackground.setCurrentItem(index);
                }

                // viewPagerBackground.setCurrentItem(index);
            }
        });
*/
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
                relativeLayout.setVisibility(View.VISIBLE);
                edtSearchText.setVisibility(View.GONE);
                edtSearchText.setHint("Type Location Here");
                break;
            case R.id.btn_search_job:
                relativeLayout.setVisibility(View.GONE);
                edtSearchText.setVisibility(View.VISIBLE);
                edtSearchText.setHint("Type Job Here");
                break;
        }
    }
}
