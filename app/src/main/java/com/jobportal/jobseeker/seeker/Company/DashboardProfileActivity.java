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

public class DashboardProfileActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_profile_company)
    Button btnProfileCompany;
    @BindView(R.id.prfPic)
    CircleImageView prfPic;

    String page;
    @BindView(R.id.linearButtonOne)
    LinearLayout linearButtonOne;
    @BindView(R.id.linearButtonTwo)
    LinearLayout linearButtonTwo;
    @BindView(R.id.btn_save_import)
    Button btnSaveImport;
    @BindView(R.id.linearIgnore)
    LinearLayout linearIgnore;
    @BindView(R.id.linearReach)
    LinearLayout linearReach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_profile);
        ButterKnife.bind(this);
        try {
            if (getIntent() != null) {
                page = getIntent().getStringExtra("page");
                if (page.equalsIgnoreCase("1")) {
                    linearButtonOne.setVisibility(View.VISIBLE);
                    linearButtonTwo.setVisibility(View.GONE);
                } else if (page.equalsIgnoreCase("2")) {
                    btnSaveImport.setText("Import");
                    linearButtonOne.setVisibility(View.VISIBLE);
                    linearButtonTwo.setVisibility(View.GONE);
                } else if (page.equalsIgnoreCase("3")) {
                    linearButtonOne.setVisibility(View.GONE);
                    linearButtonTwo.setVisibility(View.VISIBLE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.btn_back, R.id.btn_save_import,R.id.linearIgnore, R.id.linearReach,R.id.btn_profile_company})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_profile_company:
                Intent intentCompanyPrf = new Intent(DashboardProfileActivity.this,CompanyProfileActivity.class);
                startActivity(intentCompanyPrf);
                break;
            case R.id.btn_back:
                onBackPressed();
                break;

            case R.id.btn_save_import:

                if (page.equalsIgnoreCase("2")) {
                    btnSaveImport.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                    Intent intent = new Intent(DashboardProfileActivity.this, ImportCandidateActivity.class);
                    startActivity(intent);
                }else {
                    btnSaveImport.setBackgroundColor(getResources().getColor(R.color.colorSignup));

                }
                break;
            case R.id.linearIgnore:
                linearIgnore.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                linearReach.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                break;
            case R.id.linearReach:
                linearIgnore.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                linearReach.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
