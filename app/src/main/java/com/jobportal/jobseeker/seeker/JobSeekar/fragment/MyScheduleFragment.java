package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jobportal.jobseeker.seeker.R;

/**
 * Created by uniflyn on 28/4/18.
 */

public class MyScheduleFragment extends Fragment {

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView=inflater.inflate(R.layout.fragment_my_schedules,container,false);
        return rootView;
    }
}
