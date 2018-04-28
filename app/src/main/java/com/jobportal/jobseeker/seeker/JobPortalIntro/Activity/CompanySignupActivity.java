package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobPortalIntroAdapter.AdapterCompanySize;
import com.jobportal.jobseeker.seeker.JobPortalIntroModel.CompanySizeModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompanySignupActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup_back)
    Button btnSignupBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.edt_comopany_name)
    EditText edtComopanyName;
    @BindView(R.id.edt_company_size)
    EditText edtCompanySize;
    @BindView(R.id.btn_down_arrow_cs)
    Button btnDownArrowCs;
    @BindView(R.id.edt_comopany_email)
    EditText edtComopanyEmail;
    @BindView(R.id.edt_comopany_phoneno)
    EditText edtComopanyPhoneno;
    @BindView(R.id.edt_perssonnel_position)
    EditText edtPerssonnelPosition;
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
    @BindView(R.id.linearTwo)
    ScrollView linearTwo;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.linearCompanySize)
    LinearLayout linearCompanySize;
    @BindView(R.id.recycleCmpnSize)
    RecyclerView recycleCmpnSize;
    List<CompanySizeModel> companySizeModels;
    AdapterCompanySize adapterCompanySize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_signup);
        ButterKnife.bind(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleCmpnSize.setLayoutManager(new LinearLayoutManager(this));

        companySizeModels = new ArrayList<>();
        companySizeModels.add(new CompanySizeModel("1 to 9 Employees"));
        companySizeModels.add(new CompanySizeModel("10 to 19 Employees"));
        companySizeModels.add(new CompanySizeModel("20 to 49 Employees"));
        companySizeModels.add(new CompanySizeModel("30 to 59 Employees"));
        companySizeModels.add(new CompanySizeModel("40 to 69 Employees"));
        companySizeModels.add(new CompanySizeModel("50 to 79 Employees"));
        companySizeModels.add(new CompanySizeModel("60 to 89 Employees"));
        companySizeModels.add(new CompanySizeModel("71 to 99 Employees"));
        adapterCompanySize = new AdapterCompanySize(companySizeModels,CompanySignupActivity.this);
        recycleCmpnSize.setAdapter(adapterCompanySize);

    }

    @OnClick({R.id.btn_signup_back, R.id.btn_signup, R.id.btn_down_arrow_cs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_signup_back:
                onBackPressed();
                break;
            case R.id.btn_signup:
                break;
            case R.id.btn_down_arrow_cs:
                linearCompanySize.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        CompanySignupActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
}
