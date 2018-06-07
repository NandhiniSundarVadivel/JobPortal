package com.jobportal.jobseeker.seeker.Company;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.Global.Global;
import com.jobportal.jobseeker.seeker.JobPortalIntroAdapter.AdapterCompanySize;
import com.jobportal.jobseeker.seeker.JobPortalIntroModel.CompanySizeModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompanyDetailsEditActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.edit_cmp_name)
    EditText editCmpName;
    @BindView(R.id.edit_cmp_size)
    EditText editCmpSize;
    @BindView(R.id.edit_cmp_email)
    EditText editCmpEmail;
    @BindView(R.id.edit_cmp_mobileno)
    EditText editCmpMobileno;
    @BindView(R.id.edit_personnel_position)
    EditText editPersonnelPosition;
    @BindView(R.id.edit_address_one)
    EditText editAddressOne;
    @BindView(R.id.edit_address_two)
    EditText editAddressTwo;
    @BindView(R.id.edit_city)
    EditText editCity;
    @BindView(R.id.edit_cmp_website)
    EditText editCmpWebsite;
    @BindView(R.id.edit_year_founded)
    EditText editYearFounded;
    String edt_cmp_name, edt_cmp_size, edt_mobileno, edt_cmp_email, edt_personnel_posi, edt_address_one, edt_address_two, edt_city, edt_cmp_website, edt_year_founded;
    List<CompanySizeModel> companySizeModels;
    AdapterCompanySize adapterCompanySize;
    @BindView(R.id.recycleCmpnSize)
    RecyclerView recycleCmpnSize;
    @BindView(R.id.linearCompanySize)
    LinearLayout linearCompanySize;
    @BindView(R.id.btnSize)
    Button btnSize;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details_edit);
        ButterKnife.bind(this);
        editCmpSize.setEnabled(false);
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
        adapterCompanySize = new AdapterCompanySize(companySizeModels, CompanyDetailsEditActivity.this, new AdapterCompanySize.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String item = companySizeModels.get(position).getTitle();
                Log.e("selecteditem", item);
                editCmpSize.setText(item);
                linearCompanySize.setVisibility(View.GONE);
            }
        });
        recycleCmpnSize.setAdapter(adapterCompanySize);

    }

    @OnClick({R.id.btn_back, R.id.btn_upload, R.id.btnSize})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_upload:
                // callValidation();
                break;
            case R.id.btnSize:
                if(!status) {
                    Log.e("status","false");
                    linearCompanySize.setVisibility(View.VISIBLE);
                    status = true;
                }else {
                    Log.e("status","true");
                    linearCompanySize.setVisibility(View.GONE);
                    status = false;
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /*Validatio Part*/
    private void callValidation() {
        boolean cancel = false;
        edt_cmp_name = editCmpName.getText().toString().trim();
        edt_cmp_size = editCmpSize.getText().toString().trim();
        edt_cmp_email = editCmpEmail.getText().toString().trim();
        edt_mobileno = editCmpMobileno.getText().toString().trim();
        edt_personnel_posi = editPersonnelPosition.getText().toString().trim();

        edt_address_one = editAddressOne.getText().toString().trim();
        edt_address_two = editAddressTwo.getText().toString().trim();
        edt_city = editCity.getText().toString().trim();

        if (TextUtils.isEmpty(edt_cmp_name)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.cmp_name_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_cmp_size)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.cmp_size_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_cmp_email)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.cmp_email_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_personnel_posi)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.persnl_posi_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_mobileno)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.mobile_no_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_address_one)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.addres_one_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_address_two)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.address_two_valid));
            cancel = true;
        } else if (TextUtils.isEmpty(edt_city)) {
            Global.Toast(CompanyDetailsEditActivity.this, getString(R.string.city_valid));
            cancel = true;
        }
        if (!cancel) {

        }

    }
}
