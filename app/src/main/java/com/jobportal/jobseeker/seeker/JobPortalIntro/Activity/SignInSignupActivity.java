package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInSignupActivity extends AppCompatActivity {

    @BindView(R.id.btn_signin)
    Button btnSignin;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    String page;

    String terms_condition = "<pre>By signing up you agree with our <strong>Terms and conditions<br /></strong>and <strong>Privacy Policy</strong></pre>";
    @BindView(R.id.txt_terms)
    TextView txtTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_signup);
        ButterKnife.bind(this);
        try {
            if (getIntent() != null) {
                page = getIntent().getStringExtra("page");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTerms.setText(Html.fromHtml(terms_condition));
    }

    @OnClick({R.id.btn_signin, R.id.btn_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_signin:
                if (page.equalsIgnoreCase("job")) {
                    Intent intents = new Intent(SignInSignupActivity.this, SignInActivity.class);
                    intents.putExtra("page","1");
                    startActivity(intents);
                }
                else {
                    Intent intents = new Intent(SignInSignupActivity.this, SignInActivity.class);
                    intents.putExtra("page","2");
                    startActivity(intents);
                }
                break;
            case R.id.btn_signup:
                if (page.equalsIgnoreCase("job")) {
                    Intent intent = new Intent(SignInSignupActivity.this, JobSeekerSignupActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SignInSignupActivity.this, CompanySignupActivity.class);
                    startActivity(intent);
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
