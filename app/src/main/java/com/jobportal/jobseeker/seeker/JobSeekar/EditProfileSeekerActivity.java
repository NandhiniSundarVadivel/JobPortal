package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by uniflyn on 27/4/18.
 */

public class EditProfileSeekerActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_surname)
    EditText editSurname;
    @BindView(R.id.edit_age)
    EditText editAge;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_mobile_number)
    EditText editMobileNumber;
    @BindView(R.id.edit_address_lin1)
    EditText editAddressLin1;
    @BindView(R.id.edit_address_line2)
    EditText editAddressLine2;
    @BindView(R.id.edit_city)
    EditText editCity;
    @BindView(R.id.edit_website)
    EditText editWebsite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_seeker);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_upload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_upload:
                onBackPressed();
                break;
        }
    }
}
