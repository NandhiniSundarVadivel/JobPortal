package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashPageActivity extends AppCompatActivity {

    @BindView(R.id.btn_as_job_seeker)
    Button btnAsJobSeeker;
    @BindView(R.id.btn_as_company)
    Button btnAsCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_as_job_seeker, R.id.btn_as_company})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_as_job_seeker:
                Intent intent  = new Intent(SplashPageActivity.this,SignInSignupActivity.class);
                intent.putExtra("page","job");
                startActivity(intent);
                break;
            case R.id.btn_as_company:
                Intent intentcompany  = new Intent(SplashPageActivity.this,SignInSignupActivity.class);
                intentcompany.putExtra("page","company");
                startActivity(intentcompany);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
