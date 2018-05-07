package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.JobSeekar.MyScheduleDetailsActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by uniflyn on 28/4/18.
 */

public class MyScheduleFragment extends Fragment {

    View rootView;
    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.linearTwo)
    LinearLayout linearTwo;
    @BindView(R.id.linearThree)
    LinearLayout linearThree;
    @BindView(R.id.linearFour)
    LinearLayout linearFour;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_my_schedules, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.linearOne, R.id.linearTwo, R.id.linearThree, R.id.linearFour})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linearOne:
                Intent intent1 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent1);
                break;
            case R.id.linearTwo:
                Intent intent2 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent2);
                break;
            case R.id.linearThree:
                Intent intent3 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent3);
                break;
            case R.id.linearFour:
                Intent intent4 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
