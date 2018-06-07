package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Global.Global;
import com.jobportal.jobseeker.seeker.JobSeekar.MainActivityJobSeeker;
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
    @BindView(R.id.txt_terms)
    TextView txtTerms;
    String terms = "<pre>I agree with <strong>Terms Of Use</strong> and <strong>Privacy Policy</strong></pre>";
    String edt_name,edt_surname,edt_age,edt_email,edt_mobileno,edt_address_one,edt_address_two,edt_city,edt_pswd,edt_conf_pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        textTitle.setText(getString(R.string.sign_up));
        txtTerms.setText(Html.fromHtml(terms));
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
                //callValidation();
                btnSignup.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent navigation = new Intent(JobSeekerSignupActivity.this, MainActivityJobSeeker.class);
                startActivity(navigation);
                break;
        }
    }

    /*Validatio Part*/
    private void callValidation() {
        edt_name  = edtName.getText().toString().trim();
        edt_surname = edtSurname.getText().toString().trim();
        edt_age = edtAge.getText().toString().trim();
        edt_email = edtEmail.getText().toString().trim();
        edt_mobileno = edtMobileNo.getText().toString().trim();
        edt_address_one  = edtAdderessOne.getText().toString();
        edt_address_two = edtAddressTwo.getText().toString();
        edt_city = edtCity.getText().toString().trim();
        edt_pswd = edtPassword.getText().toString();
        edt_conf_pswd = edtConfirmPassword.getText().toString().trim();
        boolean cancel = false;

        if(TextUtils.isEmpty(edt_name)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.name_valid));
            cancel  = true;
        }
        else if(TextUtils.isEmpty(edt_surname)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.surname_valid));
            cancel = true;
        }
        else if(TextUtils.isEmpty(edt_age)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.age_valid));
            cancel = true;
        }else if(TextUtils.isEmpty(edt_email)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.email_valid));
            cancel = true;
        }else if(TextUtils.isEmpty(edt_mobileno)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.mobile_no_valid));
            cancel = true;
        }else if(TextUtils.isEmpty(edt_address_one)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.addres_one_valid));
            cancel = true;
        }else if(TextUtils.isEmpty(edt_address_two)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.address_two_valid));
            cancel = true;
        }else if(TextUtils.isEmpty(edt_city)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.city_valid));
            cancel = true;
        }else if(TextUtils.isEmpty(edt_pswd)){
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.pswd_valid));
            cancel = true;;
        }else if(!edt_pswd.equalsIgnoreCase(edt_conf_pswd)){
            cancel = true;
            Global.Toast(JobSeekerSignupActivity.this,getString(R.string.cnf_pswd_valid));
        }if(!cancel){

        }

    }

}
