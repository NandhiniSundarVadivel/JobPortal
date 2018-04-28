package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobSeekar.MainActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobSeekerSignupActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup_back)
    Button btnSignupBack;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_surname)
    EditText edtSurname;
    @BindView(R.id.edt_age)
    EditText edtAge;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_mobile_no)
    EditText edtMobileNo;
    @BindView(R.id.edt_adderess_one)
    EditText edtAdderessOne;
    @BindView(R.id.edt_address_two)
    EditText edtAddressTwo;
    @BindView(R.id.edt_city)
    EditText edtCity;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_confirm_password)
    EditText edtConfirmPassword;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.linearTwo)
    LinearLayout linearTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        textTitle.setText(getString(R.string.sign_up));
    }

    @Override
    protected void onResume() {
        super.onResume();
        JobSeekerSignupActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick({R.id.btn_signup_back, R.id.btn_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_signup_back:
                finish();
                break;
            case R.id.btn_signup:
                Intent navigation = new Intent(JobSeekerSignupActivity.this, MainActivity.class);
                startActivity(navigation);
                break;
        }
    }

}