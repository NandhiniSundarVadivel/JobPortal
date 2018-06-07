package com.jobportal.jobseeker.seeker.Company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InterestedProfileActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.radioone_ignore)
    RadioButton radiooneIgnore;
    @BindView(R.id.radiotwo_save)
    RadioButton radiotwoSave;
    @BindView(R.id.radiothree_shortlist)
    RadioButton radiothreeShortlist;
    @BindView(R.id.radiofour_reach)
    RadioButton radiofourReach;
    @BindView(R.id.radiogrp_button)
    RadioGroup radiogrpButton;
    @BindView(R.id.btn_profile_company)
    Button btnProfileCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested_profile);
        ButterKnife.bind(this);
        radiogrpButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioone_ignore) {

                } else if (checkedId == R.id.radiotwo_save) {

                } else if (checkedId == R.id.radiothree_shortlist) {

                } else if (checkedId == R.id.radiofour_reach) {

                }
            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick({R.id.btn_back, R.id.btn_profile_company})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_profile_company:
                Intent intent = new Intent(InterestedProfileActivity.this,CompanyProfileActivity.class);
                startActivity(intent);
                break;
        }
    }
}
