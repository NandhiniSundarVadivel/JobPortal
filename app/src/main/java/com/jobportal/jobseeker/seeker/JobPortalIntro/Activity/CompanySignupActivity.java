package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Company.MainActivityCompany;
import com.jobportal.jobseeker.seeker.Global.Global;
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
    @BindView(R.id.txt_terms)
    TextView txtTerms;
    String terms = "<pre>I agree with <strong>Terms Of Use</strong> and <strong>Privacy Policy</strong></pre>";
    String edt_cmp_name, edt_cmp_size, edt_cmp_phone, edt_cmp_email, edt_personnel_posi, edt_mobileno, edt_address_one, edt_address_two, edt_city, edt_pswd, edt_conf_pswd;
    @BindView(R.id.linearthree)
    LinearLayout linearthree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_signup);
        ButterKnife.bind(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleCmpnSize.setLayoutManager(new LinearLayoutManager(this));
        txtTerms.setText(Html.fromHtml(terms));
        edtCompanySize.setEnabled(false);
        companySizeModels = new ArrayList<>();
        companySizeModels.add(new CompanySizeModel("1 to 9 Employees"));
        companySizeModels.add(new CompanySizeModel("10 to 19 Employees"));
        companySizeModels.add(new CompanySizeModel("20 to 49 Employees"));
        companySizeModels.add(new CompanySizeModel("30 to 59 Employees"));
        companySizeModels.add(new CompanySizeModel("40 to 69 Employees"));
        companySizeModels.add(new CompanySizeModel("50 to 79 Employees"));
        companySizeModels.add(new CompanySizeModel("60 to 89 Employees"));
        companySizeModels.add(new CompanySizeModel("71 to 99 Employees"));
        adapterCompanySize = new AdapterCompanySize(companySizeModels, CompanySignupActivity.this, new AdapterCompanySize.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String item = companySizeModels.get(position).getTitle();
                Log.e("selecteditem", item);
                edtCompanySize.setText(item);
                linearCompanySize.setVisibility(View.GONE);
            }
        });
        recycleCmpnSize.setAdapter(adapterCompanySize);

    }

    @OnClick({R.id.btn_signup_back, R.id.btn_signup, R.id.btn_down_arrow_cs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_signup_back:
                onBackPressed();
                break;
            case R.id.btn_signup:
                // callValidation();
                btnSignup.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                Intent intent = new Intent(CompanySignupActivity.this, MainActivityCompany.class);
                startActivity(intent);
                break;
            case R.id.btn_down_arrow_cs:
                linearCompanySize.setVisibility(View.VISIBLE);
                break;
        }
    }

    /*Validatio Part*/
    private void callValidation() {
        boolean cancel = false;
        edt_cmp_name = edtComopanyName.getText().toString().trim();
        edt_cmp_size = edtCompanySize.getText().toString().trim();
        edt_cmp_email = edtComopanyEmail.getText().toString().trim();
        edt_cmp_phone = edtComopanyPhoneno.getText().toString().trim();
        edt_personnel_posi = edtPerssonnelPosition.getText().toString().trim();
        edt_mobileno = edtMobileNo.getText().toString().trim();
        edt_address_one = edtAdderessOne.getText().toString().trim();
        edt_address_two = edtAddressTwo.getText().toString().trim();
        edt_city = edtCity.getText().toString().trim();
        edt_pswd = edtPassword.getText().toString().trim();
        edt_conf_pswd = edtConfirmPassword.getText().toString().trim();
        if (TextUtils.isEmpty(edt_cmp_name)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.cmp_name_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_cmp_size)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.cmp_size_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_cmp_email)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.cmp_email_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_cmp_phone)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.cmp_phone_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_personnel_posi)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.persnl_posi_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_mobileno)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.mobile_no_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_address_one)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.addres_one_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_address_two)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.address_two_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_city)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.city_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_pswd)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.pswd_valid));
            cancel = true;
        } else if (!edt_pswd.equalsIgnoreCase(edt_conf_pswd)) {
            Global.Toast(CompanySignupActivity.this, getString(R.string.cnf_pswd_valid));
            cancel = true;
        }
        if (!cancel) {

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
