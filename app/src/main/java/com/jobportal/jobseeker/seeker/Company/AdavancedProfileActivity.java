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
import de.hdodenhof.circleimageview.CircleImageView;

public class AdavancedProfileActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.prfPic)
    CircleImageView prfPic;
    @BindView(R.id.lineStage3)
    LinearLayout lineStage3;
    @BindView(R.id.linearStage2)
    LinearLayout linearStage2;
    @BindView(R.id.btn_reject)
    Button btnReject;
    @BindView(R.id.btn_make_an_offer)
    Button btnMakeAnOffer;
    @BindView(R.id.btn_cmp_prf)
    Button btnCmpPrf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adavanced_profile);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick({R.id.btn_back, R.id.btn_reject, R.id.btn_make_an_offer,R.id.btn_cmp_prf})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cmp_prf:
                Intent intentCmp = new Intent(AdavancedProfileActivity.this,CompanyProfileActivity.class);
                startActivity(intentCmp);
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_reject:
                btnReject.setBackgroundColor(getResources().getColor(R.color.colorRed1));
                Intent intentRJ = new Intent(AdavancedProfileActivity.this, RejectLetterActivity.class);
                startActivity(intentRJ);
                break;
            case R.id.btn_make_an_offer:
                btnMakeAnOffer.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent = new Intent(AdavancedProfileActivity.this, OfferLetterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
