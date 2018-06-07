package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.Company.DashboardProfileActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ShortlistFragment extends Fragment {


    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.linearItem)
    LinearLayout linearItem;
    Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shortlist, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({ R.id.linearItem})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.linearItem:
                Intent intent = new Intent(getContext(), DashboardProfileActivity.class);
                intent.putExtra("page","3");
                startActivity(intent);
                break;
        }
    }

    /*@OnClick(R.id.linearItem)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), InterestedProfileActivity.class);
        startActivity(intent);
    }*/
}
