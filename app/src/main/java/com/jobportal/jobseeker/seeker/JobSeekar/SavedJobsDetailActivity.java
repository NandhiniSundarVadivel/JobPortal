package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by uniflyn on 28/4/18.
 */

public class SavedJobsDetailActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_ignore)
    Button btnIgnore;
    @BindView(R.id.btn_reach)
    Button btnReach;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_jobs_detail);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_ignore, R.id.btn_reach})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_ignore:
                onBackPressed();
                break;
            case R.id.btn_reach:
                onBackPressed();
                break;
        }
    }
}
