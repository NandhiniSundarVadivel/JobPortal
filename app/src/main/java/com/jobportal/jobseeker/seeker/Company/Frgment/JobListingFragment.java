package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.Company.JobListingActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class JobListingFragment extends Fragment {


    @BindView(R.id.linearItem)
    LinearLayout linearItem;
    Unbinder unbinder;
    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.linearTwo)
    LinearLayout linearTwo;
    @BindView(R.id.linearThree)
    LinearLayout linearThree;
    @BindView(R.id.linearFour)
    LinearLayout linearFour;
    @BindView(R.id.linearFive)
    LinearLayout linearFive;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_listing, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.linearOne, R.id.linearTwo, R.id.linearThree, R.id.linearFour, R.id.linearFive})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linearOne:
                linearOne.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intentjob = new Intent(getContext(), JobListingActivity.class);
                startActivity(intentjob);
                break;
            case R.id.linearTwo:
                linearTwo.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intentjob1 = new Intent(getContext(), JobListingActivity.class);
                startActivity(intentjob1);
                break;
            case R.id.linearThree:
                linearThree.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intentjob2 = new Intent(getContext(), JobListingActivity.class);
                startActivity(intentjob2);
                break;
            case R.id.linearFour:
                linearFour.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intentjob3 = new Intent(getContext(), JobListingActivity.class);
                startActivity(intentjob3);
                break;
            case R.id.linearFive:
                linearFive.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intentjob4 = new Intent(getContext(), JobListingActivity.class);
                startActivity(intentjob4);
                break;
        }
    }
}
