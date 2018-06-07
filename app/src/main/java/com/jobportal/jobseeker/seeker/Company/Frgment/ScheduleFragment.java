package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.Company.ScheduleDetailsActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ScheduleFragment extends Fragment {


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_schedule, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    @OnClick({R.id.btn_view, R.id.btn_one, R.id.btn_two, R.id.btn_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_view:
                btnView.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intenS = new Intent(getContext(), ScheduleDetailsActivity.class);
                startActivity(intenS);
                break;
            case R.id.btn_one:
                btnOne.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent inten1 = new Intent(getContext(), ScheduleDetailsActivity.class);
                startActivity(inten1);
                break;
            case R.id.btn_two:
                btnTwo.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent inten2 = new Intent(getContext(), ScheduleDetailsActivity.class);
                startActivity(inten2);
                break;
            case R.id.btn_three:
                btnThree.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent inten3 = new Intent(getContext(), ScheduleDetailsActivity.class);
                startActivity(inten3);
                break;
        }
    }
}
