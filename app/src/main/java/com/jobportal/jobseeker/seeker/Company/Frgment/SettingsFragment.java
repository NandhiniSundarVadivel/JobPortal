package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jobportal.jobseeker.seeker.JobSeekar.AccountSettingActivity;
import com.jobportal.jobseeker.seeker.JobSeekar.SetPreferencesActivity;
import com.jobportal.jobseeker.seeker.JobSeekar.VerifyProfileActivity;
import com.jobportal.jobseeker.seeker.JobSeekar.VersionActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by uniflyn on 28/4/18.
 */

public class SettingsFragment extends Fragment {

    View rootView;
    @BindView(R.id.btn_setting)
    Button btnSetting;
    @BindView(R.id.btn_preference)
    Button btnPreference;
    @BindView(R.id.btn_verify_profile)
    Button btnVerifyProfile;
    @BindView(R.id.btn_subscription)
    Button btnSubscription;
    @BindView(R.id.btn_version)
    Button btnVersion;
    @BindView(R.id.btn_sharebe_reach)
    Button btnSharebeReach;
    @BindView(R.id.btn_terms)
    Button btnTerms;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_setting, R.id.btn_preference, R.id.btn_verify_profile, R.id.btn_version, R.id.btn_sharebe_reach, R.id.btn_terms})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_setting:
                Intent intentAS = new Intent(getContext(), AccountSettingActivity.class);
                startActivity(intentAS);
                break;
            case R.id.btn_preference:
                Intent intentSP = new Intent(getContext(), SetPreferencesActivity.class);
                startActivity(intentSP);
                break;
            case R.id.btn_verify_profile:
                Intent intentVP = new Intent(getContext(), VerifyProfileActivity.class);
                startActivity(intentVP);
                break;
            case R.id.btn_version:
                Intent intentV = new Intent(getContext(), VersionActivity.class);
                startActivity(intentV);
                break;
            case R.id.btn_sharebe_reach:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Send Email"));
                break;
            case R.id.btn_terms:
                break;
        }
    }
}
