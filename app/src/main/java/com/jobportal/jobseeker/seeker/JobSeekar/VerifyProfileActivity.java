package com.jobportal.jobseeker.seeker.JobSeekar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VerifyProfileActivity extends AppCompatActivity {

    @BindView(R.id.btn_vp_back)
    Button btnVpBack;
    @BindView(R.id.edt_email_VP)
    EditText edtEmailVP;
    @BindView(R.id.btn_submit_VP)
    Button btnSubmitVP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_profile);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_vp_back, R.id.btn_submit_VP})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_vp_back:
                onBackPressed();
                break;
            case R.id.btn_submit_VP:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btnSubmitVP.setBackground(getResources().getDrawable(R.drawable.background_rounded_sp_two_darkblue));
                }
                Intent intentVC = new Intent(VerifyProfileActivity.this,VerificationCodeActivity.class);
                startActivity(intentVC);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
