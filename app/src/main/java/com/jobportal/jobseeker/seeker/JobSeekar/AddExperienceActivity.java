package com.jobportal.jobseeker.seeker.JobSeekar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
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

public class AddExperienceActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.edit_title)
    EditText editTitle;
    @BindView(R.id.edit_company_name)
    EditText editCompanyName;
    @BindView(R.id.edit_location)
    EditText editLocation;
    @BindView(R.id.edit_from)
    EditText editFrom;
    @BindView(R.id.edit_to)
    EditText editTo;
    @BindView(R.id.switch_compact)
    SwitchCompat switchCompact;
    @BindView(R.id.edit_description)
    EditText editDescription;
    @BindView(R.id.linear_from)
    LinearLayout linearFrom;
    @BindView(R.id.linear_to)
    LinearLayout linearTo;
    int year, month, day;
    @BindView(R.id.txt_title)
    TextView txtTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_experience);
        ButterKnife.bind(this);
        editFrom.setEnabled(false);
        editTo.setEnabled(false);

        if (getIntent()!=null){
            if (getIntent().getStringExtra("edit_add").equals("edit")){
                txtTitle.setText(R.string.edit_experience);
            }else {
                txtTitle.setText(R.string.add_experience);
            }
        }
    }

    @OnClick({R.id.btn_back, R.id.btn_upload, R.id.linear_from, R.id.linear_to})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_upload:
                onBackPressed();
                break;
            case R.id.linear_from:
                callDatePickerDialog("from");
                break;
            case R.id.linear_to:
                callDatePickerDialog("to");
                break;
        }
    }

    private void callDatePickerDialog(final String from_to) {
        Calendar mcurrentDate = Calendar.getInstance();
        year = mcurrentDate.get(Calendar.YEAR);
        month = mcurrentDate.get(Calendar.MONTH);
        day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(AddExperienceActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                year = selectedyear;
                month = selectedmonth;
                day = selectedday;

                String dateofbr = String.valueOf(new StringBuilder().append(year).append("/").append(month + 1).append("/").append(day));
                Log.e("dateof", dateofbr + "");

                if (from_to.equals("from")) {
                    editFrom.setText(dateofbr);
                } else {
                    editTo.setText(dateofbr);
                }


            }
        }, year, month, day);

        mDatePicker.show();
    }

}
