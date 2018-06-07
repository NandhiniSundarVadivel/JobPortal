package com.jobportal.jobseeker.seeker.JobSeekar;

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

public class VerificationCodeActivity extends AppCompatActivity {

    @BindView(R.id.btn_vc_back)
    Button btnVcBack;
    @BindView(R.id.edt_enter_code)
    EditText edtEnterCode;
    @BindView(R.id.btn_enter_vc)
    Button btnEnterVc;
    @BindView(R.id.btn_resend_code)
    Button btnResendCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_vc_back, R.id.btn_enter_vc, R.id.btn_resend_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_vc_back:
                onBackPressed();
                break;
            case R.id.btn_enter_vc:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btnEnterVc.setBackground(getResources().getDrawable(R.drawable.background_rounded_sp_two_darkblue));
                }
                break;
            case R.id.btn_resend_code:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
