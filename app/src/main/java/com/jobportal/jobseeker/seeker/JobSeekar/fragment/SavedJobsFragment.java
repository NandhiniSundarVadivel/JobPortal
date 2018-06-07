package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.JobSeekar.SavedJobsDetailActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by uniflyn on 28/4/18.
 */

public class SavedJobsFragment extends Fragment {

    View rootView;
    @BindView(R.id.parent_linear)
    LinearLayout parentLinear;
    Unbinder unbinder;
    @BindView(R.id.btn_view)
    Button btnView;
    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;
    @BindView(R.id.btn_three)
    Button btnThree;
    @BindView(R.id.btn_four)
    Button btnFour;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_saved_jobs, container, false);

        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    @OnClick({R.id.btn_view, R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_view:
                btnView.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent next = new Intent(getContext(), SavedJobsDetailActivity.class);
                startActivity(next);
                break;
            case R.id.btn_one:
                btnOne.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent next1 = new Intent(getContext(), SavedJobsDetailActivity.class);
                startActivity(next1);
                break;
            case R.id.btn_two:
                btnTwo.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent next2 = new Intent(getContext(), SavedJobsDetailActivity.class);
                startActivity(next2);
                break;
            case R.id.btn_three:
                btnThree.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent next3 = new Intent(getContext(), SavedJobsDetailActivity.class);
                startActivity(next3);
                break;
            case R.id.btn_four:
                btnFour.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent next4 = new Intent(getContext(), SavedJobsDetailActivity.class);
                startActivity(next4);
                break;
        }
    }
}
