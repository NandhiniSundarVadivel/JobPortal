package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.JobSeekar.OffersLettersActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class LettersOffersFragment extends Fragment {


    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.linearTwo)
    LinearLayout linearTwo;
    @BindView(R.id.linearThree)
    LinearLayout linearThree;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_letters_offers, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.linearOne, R.id.linearTwo, R.id.linearThree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linearOne:
                Intent intent1 = new Intent(getContext(), OffersLettersActivity.class);
                startActivity(intent1);
                break;
            case R.id.linearTwo:
                Intent intent2 = new Intent(getContext(), OffersLettersActivity.class);
                startActivity(intent2);
                break;
            case R.id.linearThree:
                Intent intent3 = new Intent(getContext(), OffersLettersActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
