package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VersionActivity extends AppCompatActivity {

    @BindView(R.id.btn_v_back)
    Button btnVBack;
    @BindView(R.id.txt_version)
    TextView txtVersion;
    @BindView(R.id.btn_version_update)
    Button btnVersionUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_v_back, R.id.btn_version_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_v_back:
                onBackPressed();
                break;
            case R.id.btn_version_update:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
