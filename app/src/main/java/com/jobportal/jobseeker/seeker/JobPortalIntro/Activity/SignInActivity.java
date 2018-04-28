package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jobportal.jobseeker.seeker.JobSeekar.MainActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_forget_pswd, R.id.btn_signip, R.id.btn_face_book, R.id.btn_googleplus, R.id.btn_linkedin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_forget_pswd:
                break;
            case R.id.btn_signip:
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_face_book:
                break;
            case R.id.btn_googleplus:
                break;
            case R.id.btn_linkedin:
                break;
        }
    }
}
