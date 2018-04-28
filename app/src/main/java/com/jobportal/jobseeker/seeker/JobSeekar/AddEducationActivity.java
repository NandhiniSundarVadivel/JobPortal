package com.jobportal.jobseeker.seeker.JobSeekar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by uniflyn on 27/4/18.
 */

public class AddEducationActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.edit_institution)
    EditText editInstitution;
    @BindView(R.id.edit_degree)
    EditText editDegree;
    @BindView(R.id.edit_field_study)
    EditText editFieldStudy;
    @BindView(R.id.edit_start)
    EditText editStart;
    @BindView(R.id.linear_start_year)
    LinearLayout linearStartYear;
    @BindView(R.id.edit_end)
    EditText editEnd;
    @BindView(R.id.linear_end_year)
    LinearLayout linearEndYear;
    @BindView(R.id.edit_grade)
    EditText editGrade;
    @BindView(R.id.edit_description)
    EditText editDescription;
    int year, month, day;
    @BindView(R.id.txt_title)
    TextView txtTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_education);
        ButterKnife.bind(this);
        if (getIntent()!=null){
            if (getIntent().getStringExtra("edit_add").equals("edit")){
                txtTitle.setText(R.string.edit_education);
            }else {
                txtTitle.setText(R.string.add_education);
            }
        }
    }

    @OnClick({R.id.btn_back, R.id.btn_upload, R.id.linear_start_year, R.id.linear_end_year})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_upload:
                onBackPressed();
                break;
            case R.id.linear_start_year:
                callDatePickerDialog("start");
                break;
            case R.id.linear_end_year:
                callDatePickerDialog("end");
                break;
        }
    }

    private void callDatePickerDialog(final String start_end) {
        Calendar mcurrentDate = Calendar.getInstance();
        year = mcurrentDate.get(Calendar.YEAR);
        month = mcurrentDate.get(Calendar.MONTH);
        day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(AddEducationActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                year = selectedyear;
                month = selectedmonth;
                day = selectedday;

                String dateofbr = String.valueOf(new StringBuilder().append(year).append("/").append(month + 1).append("/").append(day));
                Log.e("dateof", dateofbr + "");

                if (start_end.equals("start")) {
                    editStart.setText(dateofbr);
                } else {
                    editEnd.setText(dateofbr);
                }


            }
        }, year, month, day);

        mDatePicker.show();
    }
}
