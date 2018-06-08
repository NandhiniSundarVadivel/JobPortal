package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.jobportal.jobseeker.seeker.JobSeekar.adapter.TinderCard;
import com.jobportal.jobseeker.seeker.R;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

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
    private SwipePlaceHolderView mSwipView;
    public  static  View viewGreen;
    public static   View viewRed;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        roootView = inflater.inflate(R.layout.fragment_home, container, false);


        unbinder = ButterKnife.bind(this, roootView);
        viewGreen = (View) roootView.findViewById(R.id.viewGreen);
        viewRed = (View) roootView.findViewById(R.id.viewRed);
        mSwipView = (SwipePlaceHolderView) roootView.findViewById(R.id.swipeView);

        mSwipView.disableTouchSwipe();
        mSwipView.addItemRemoveListener(new ItemRemovedListener() {

            @Override
            public void onItemRemoved(int count) {
                if(count == 0){
                    Log.e("emters here","1");
                    mSwipView.addView(new TinderCard(getActivity(),"Designer","Scientronics Limited","Limassol,Cyprus"))
                            .addView(new TinderCard(getActivity(),"Android Developer","ExxonMobil","Beijing"))
                            .addView(new TinderCard(getActivity(),"Ios Developer","Apple Inc","Limassol,Cyprus"))
                            .addView(new TinderCard(getActivity(),"MEAN Stack Developer","Berkshire Hathaway","Beijing"))
                            .addView(new TinderCard(getActivity(),"Chemical Lead","Sinopec Group","Beijing"))
                            .addView(new TinderCard(getActivity(),"Designer","Scientronics Limited","Limassol,Cyprus"))
                            .addView(new TinderCard(getActivity(),"Android Developer","ExxonMobil","Beijing"))
                            .addView(new TinderCard(getActivity(),"Ios Developer","Apple Inc","Limassol,Cyprus"))
                            .addView(new TinderCard(getActivity(),"MEAN Stack Developer","Berkshire Hathaway","Beijing"))
                            .addView(new TinderCard(getActivity(),"Chemical Lead","Sinopec Group","Beijing"))
                            .addView(new TinderCard(getActivity(),"Designer","Scientronics Limited","Limassol,Cyprus"))
                            .addView(new TinderCard(getActivity(),"Android Developer","ExxonMobil","Beijing"))
                            .addView(new TinderCard(getActivity(),"Ios Developer","Apple Inc","Limassol,Cyprus"))
                            .addView(new TinderCard(getActivity(),"MEAN Stack Developer","Berkshire Hathaway","Beijing"))
                            .addView(new TinderCard(getActivity(),"Chemical Lead","Sinopec Group","Beijing"));
                }else{
                    Log.e("emters here","2");
                }

            }
        });


        mSwipView.getBuilder()
//                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_VERTICAL)
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setWidthSwipeDistFactor(4)
                .setHeightSwipeDistFactor(6)
                .setSwipeDecor(new SwipeDecor()
//                        .setMarginTop(300)
//                        .setMarginLeft(100)
//                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setSwipeMaxChangeAngle(2f)
                        .setRelativeScale(0.01f));



        Log.e("emters here","3");

        // mSwipView.getBuilder().getSwipePlaceHolderView();

        mSwipView.addView(new TinderCard(getActivity(),"Designer","Scientronics Limited","Limassol,Cyprus"))
                .addView(new TinderCard(getActivity(),"Android Developer","ExxonMobil","Beijing"))
                .addView(new TinderCard(getActivity(),"Ios Developer","Apple Inc","Limassol,Cyprus"))
                .addView(new TinderCard(getActivity(),"MEAN Stack Developer","Berkshire Hathaway","Beijing"))
                .addView(new TinderCard(getActivity(),"Chemical Lead","Sinopec Group","Beijing"))
                .addView(new TinderCard(getActivity(),"Designer","Scientronics Limited","Limassol,Cyprus"))
                .addView(new TinderCard(getActivity(),"Android Developer","ExxonMobil","Beijing"))
                .addView(new TinderCard(getActivity(),"Ios Developer","Apple Inc","Limassol,Cyprus"))
                .addView(new TinderCard(getActivity(),"MEAN Stack Developer","Berkshire Hathaway","Beijing"))
                .addView(new TinderCard(getActivity(),"Chemical Lead","Sinopec Group","Beijing"))
                .addView(new TinderCard(getActivity(),"Designer","Scientronics Limited","Limassol,Cyprus"))
                .addView(new TinderCard(getActivity(),"Android Developer","ExxonMobil","Beijing"))
                .addView(new TinderCard(getActivity(),"Ios Developer","Apple Inc","Limassol,Cyprus"))
                .addView(new TinderCard(getActivity(),"MEAN Stack Developer","Berkshire Hathaway","Beijing"))
                .addView(new TinderCard(getActivity(),"Chemical Lead","Sinopec Group","Beijing"));
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    mSwipView.enableTouchSwipe();

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();






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
