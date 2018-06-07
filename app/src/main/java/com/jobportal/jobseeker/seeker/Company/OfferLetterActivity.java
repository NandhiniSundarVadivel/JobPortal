package com.jobportal.jobseeker.seeker.Company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OfferLetterActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.linear_review_send)
    LinearLayout linearReviewSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_letter);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_back, R.id.linear_review_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.linear_review_send:
                linearReviewSend.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent = new Intent(OfferLetterActivity.this,OfferLetterReviewActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
