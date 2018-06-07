package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    @BindView(R.id.btn_view)
    Button btnView;
    @BindView(R.id.btn_view_one)
    Button btnViewOne;
    @BindView(R.id.btn_view_two)
    Button btnViewTwo;
    @BindView(R.id.btn_view_three)
    Button btnViewThree;
    @BindView(R.id.dateandday)
    TextView dateandday;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.parent_linear)
    LinearLayout parentLinear;
    @BindView(R.id.dateandday1)
    TextView dateandday1;
    @BindView(R.id.time1)
    TextView time1;
    @BindView(R.id.dateandday2)
    TextView dateandday2;
    @BindView(R.id.time2)
    TextView time2;
    @BindView(R.id.dateandday3)
    TextView dateandday3;
    @BindView(R.id.time3)
    TextView time3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_my_schedules, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        dateandday.setText(Html.fromHtml("<big>THU, 11</big> <sup>th</sup>"));
        time.setText(Html.fromHtml("<big>11:00 </big><small>AM</small>"));

        dateandday1.setText(Html.fromHtml("<big>MON, 10</big> <sup>th</sup>"));
        time1.setText(Html.fromHtml("<big>10:00 </big><small>AM</small>"));

        dateandday2.setText(Html.fromHtml("<big>THU, 20</big> <sup>th</sup>"));
        time2.setText(Html.fromHtml("<big>09:00 </big><small>AM</small>"));

        dateandday3.setText(Html.fromHtml("<big>FRI, 15</big> <sup>th</sup>"));
        time3.setText(Html.fromHtml("<big>10:00 </big><small>AM</small>"));

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_view, R.id.btn_view_one, R.id.btn_view_two, R.id.btn_view_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_view:
                btnView.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent1 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_view_one:
                btnViewOne.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent2 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_view_two:
                btnViewTwo.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent3 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_view_three:
                btnViewThree.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent4 = new Intent(getContext(), MyScheduleDetailsActivity.class);
                startActivity(intent4);
                break;
        }
    }


/*
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
*/
}
