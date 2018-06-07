package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * Created by uniflyn on 28/4/18.
 */

public class BrowseCandidtesFragment extends Fragment {

    View roootView;

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;
    @BindView(R.id.edtSearchText)
    EditText edtSearchText;
    @BindView(R.id.btn_location)
    Button btnLocation;
    @BindView(R.id.btn_search_job)
    Button btnSearchJob;
    @BindView(R.id.tablinear)
    LinearLayout tablinear;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    private int PLACE_AUTOCOMPLETE_REQUEST_CODE = 200;
    String latitude = "", longitude = "", location;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        roootView = inflater.inflate(R.layout.fragment_browse_candidates, container, false);

        unbinder = ButterKnife.bind(this, roootView);

        setupViewPager(viewpager);

      /*  placeAutocompleteFragment = (PlaceAutocompleteFragment) getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete);
        //   ((EditText)autocompleteFragment.getActivity().findViewById(R.id.place_autocomplete)).setTextColor(getResources().getColor(R.color.white));
        ImageView searchicon = (ImageView) ((LinearLayout) placeAutocompleteFragment.getView()).getChildAt(0);
        searchicon.setImageDrawable(null);

        callPlacesFragment();
*/
        return roootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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

            //((EditText)autocompleteFragment.getView().findViewById(R.id.place_autocomplete)).setTextSize(10.0f);

           /* ImageView searchicon = (ImageView) ((LinearLayout) autocompleteFragment.getView()).getChildAt(0);
            searchicon.setImageDrawable(null);


            ((EditText)autocompleteFragment.getView().findViewById(R.id.place_autocomplete)).setTextSize(1.0f);
*/

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

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new BCLocationFragment(), "");
//        adapter.addFragment(new BCSearchJobFragment(), "");
        viewPager.setAdapter(adapter);
    }

    @OnClick({R.id.btn_search_job, R.id.tablinear, R.id.btn_location})
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
            case R.id.tablinear:

                break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
