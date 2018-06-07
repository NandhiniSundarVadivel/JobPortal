package com.jobportal.jobseeker.seeker.Company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class StagesProfileActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.prfPic)
    CircleImageView prfPic;

    @BindView(R.id.linearStage1)
    LinearLayout linearStage1;
    @BindView(R.id.lineStage3)
    LinearLayout lineStage3;
    @BindView(R.id.linearStage2)
    LinearLayout linearStage2;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.btn_stop)
    Button btnStop;
    @BindView(R.id.btn_advance)
    Button btnAdvance;
    String page;
    @BindView(R.id.btn_cmp_prf)
    Button btnCmpPrf;
    @BindView(R.id.ratevalue)
    TextView ratevalue;
    @BindView(R.id.linearRating)
    LinearLayout linearRating;
    Float aFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages_profile);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            page = getIntent().getStringExtra("page");
            if (page.equalsIgnoreCase("1")) {
                linearStage1.setVisibility(View.VISIBLE);
                linearStage2.setVisibility(View.GONE);
            } else {
                linearStage1.setVisibility(View.GONE);
                linearStage2.setVisibility(View.VISIBLE);
            }
        }
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int ratinvalu = Math.round(rating);
                String string = String.valueOf(ratinvalu);
                Log.e("rating", string);
                ratevalue.setText(string);
            }
        });
    }

    @OnClick({R.id.btn_back, R.id.btn_stop, R.id.btn_advance, R.id.btn_cmp_prf,R.id.linearRating})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linearRating:
               /* final Dialog dialog = new Dialog(StagesProfileActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
                dialog.setContentView(R.layout.dialog_ratingbar);
                dialog.show();
                RatingBar ratingBar1 = (RatingBar)dialog.findViewById(R.id.ratingBarDialog);
                Button btnSubmit = (Button)dialog.findViewById(R.id.btnSubmit);
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        ratingBar.setRating(aFloat);
                    }
                });
                ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        aFloat = rating;

                    }
                });*/

                break;
            case R.id.btn_cmp_prf:
                Intent intentCmp = new Intent(StagesProfileActivity.this, CompanyProfileActivity.class);
                startActivity(intentCmp);
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_stop:
                btnStop.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                btnAdvance.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                break;
            case R.id.btn_advance:
                btnStop.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                btnAdvance.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent = new Intent(StagesProfileActivity.this, AdavancedProfileActivity.class);
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
