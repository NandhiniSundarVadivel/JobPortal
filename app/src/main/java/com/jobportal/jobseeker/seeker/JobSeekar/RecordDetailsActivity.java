package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
