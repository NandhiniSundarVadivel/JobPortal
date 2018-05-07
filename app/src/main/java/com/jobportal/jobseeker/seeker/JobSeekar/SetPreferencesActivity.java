package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetPreferencesActivity extends AppCompatActivity {

    @BindView(R.id.btn_back_sp)
    Button btnBackSp;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.edt_cit)
    EditText edtCit;
    @BindView(R.id.btn_down_arrow_cs)
    Button btnDownArrowCs;

    @BindView(R.id.linearCity)
    LinearLayout linearCity;
    @BindView(R.id.edt_job_field)
    EditText edtJobField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_preferences);
        ButterKnife.bind(this);
        edtCit.setEnabled(false);
    }

    @OnClick({R.id.btn_back_sp, R.id.btn_upload, R.id.btn_down_arrow_cs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back_sp:
                onBackPressed();
                break;
            case R.id.btn_upload:
                break;
            case R.id.btn_down_arrow_cs:
                linearCity.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
