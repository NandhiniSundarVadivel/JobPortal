package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.jobportal.jobseeker.seeker.Company.StagesProfileActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class StagesFragment extends Fragment {


    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.linearOne)
    ScrollView linearOne;
    @BindView(R.id.linearSuc1)
    LinearLayout linearSuc1;
    @BindView(R.id.linearSuc2)
    LinearLayout linearSuc2;
    @BindView(R.id.linearTwo)
    LinearLayout linearTwo;
    Unbinder unbinder;
    @BindView(R.id.linearItem)
    LinearLayout linearItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stages, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.linear1, R.id.linear2, R.id.linearSuc1, R.id.linearSuc2,R.id.linearItem})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linear1:
                linearTwo.setVisibility(View.GONE);
                linearOne.setVisibility(View.VISIBLE);
                break;
            case R.id.linear2:
                linearTwo.setVisibility(View.VISIBLE);
                linearOne.setVisibility(View.GONE);
                break;
            case R.id.linearSuc1:
                Intent intent = new Intent(getContext(), StagesProfileActivity.class);
                intent.putExtra("page", "1");
                startActivity(intent);

                break;
            case R.id.linearSuc2:
                Intent intentSc = new Intent(getContext(), StagesProfileActivity.class);
                intentSc.putExtra("page", "1");
                startActivity(intentSc);

                break;
            case R.id.linearItem:
                Intent intentSm = new Intent(getContext(), StagesProfileActivity.class);
                intentSm.putExtra("page", "2");
                startActivity(intentSm);
                break;
        }
    }
}
