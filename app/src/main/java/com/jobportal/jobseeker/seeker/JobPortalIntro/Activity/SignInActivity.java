package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jobportal.jobseeker.seeker.Company.MainActivityCompany;
import com.jobportal.jobseeker.seeker.Global.Global;
import com.jobportal.jobseeker.seeker.JobSeekar.MainActivityJobSeeker;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.edt_email_signin)
    EditText edtEmailSignin;
    @BindView(R.id.edt_password_signin)
    EditText edtPasswordSignin;
    @BindView(R.id.btn_forget_pswd)
    Button btnForgetPswd;
    @BindView(R.id.btn_signip)
    Button btnSignip;
    @BindView(R.id.btn_face_book)
    Button btnFaceBook;
    @BindView(R.id.btn_googleplus)
    Button btnGoogleplus;
    @BindView(R.id.btn_linkedin)
    Button btnLinkedin;
    String page,edt_email,edt_pswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        try{
            if(getIntent()!=null){
                page = getIntent().getStringExtra("page");

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClick({R.id.btn_forget_pswd, R.id.btn_signip, R.id.btn_face_book, R.id.btn_googleplus, R.id.btn_linkedin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_forget_pswd:
                break;
            case R.id.btn_signip:
                //callValidation();
                btnSignip.setBackground(getResources().getDrawable(R.drawable.background_rounded_signup));
                if(page.equalsIgnoreCase("1")) {
                    Intent intent = new Intent(SignInActivity.this, MainActivityJobSeeker.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SignInActivity.this, MainActivityCompany.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn_face_book:
                break;
            case R.id.btn_googleplus:
                break;
            case R.id.btn_linkedin:
                break;
        }
    }

    /*Validation Part*/
    private void callValidation() {
        edt_email = edtEmailSignin.getText().toString();
        edt_pswd = edtPasswordSignin.getText().toString();

        boolean cancel = false;

        if(TextUtils.isEmpty(edt_email)){
            cancel = true;
            Global.Toast(SignInActivity.this,getString(R.string.email_valid));
        }else if(TextUtils.isEmpty(edt_pswd)){
            cancel = true;
            Global.Toast(SignInActivity.this,getString(R.string.pswd_valid));
        }
        if(!cancel){

        }
    }
}
