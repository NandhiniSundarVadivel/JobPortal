package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.Company.InterestedProfileActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class HomeInterestedFragment extends Fragment {


    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.linearItem)
    LinearLayout linearItem;
    Unbinder unbinder;
    @BindView(R.id.btn_ignore)
    Button btnIgnore;
    @BindView(R.id.btn_reconsider)
    Button btnReconsider;
    @BindView(R.id.btn_delete)
    Button btnDelete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_interested_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_ignore, R.id.btn_reconsider, R.id.btn_delete, R.id.linearItem})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_ignore:
                break;
            case R.id.btn_reconsider:
                break;
            case R.id.btn_delete:
                break;
            case R.id.linearItem:
                Intent intent = new Intent(getContext(), InterestedProfileActivity.class);
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
