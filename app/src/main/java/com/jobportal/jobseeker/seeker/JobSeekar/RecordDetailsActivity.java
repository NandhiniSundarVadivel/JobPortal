package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by uniflyn on 28/4/18.
 */

public class RecordDetailsActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.relativeEditDetails)
    RelativeLayout relativeEditDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        ButterKnife.bind(this);
        relativeEditDetails.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
