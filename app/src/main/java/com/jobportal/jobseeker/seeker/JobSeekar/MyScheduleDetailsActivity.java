package com.jobportal.jobseeker.seeker.JobSeekar;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyScheduleDetailsActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_job_buuble)
    Button btnJobBuuble;
    @BindView(R.id.btn_delete_plan)
    Button btnDeletePlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_schedule_details);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_job_buuble, R.id.btn_delete_plan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_job_buuble:
                break;
            case R.id.btn_delete_plan:
                callDeleteDialog();

                break;
        }
    }

    /*Delete Dialog Showing*/
    private void callDeleteDialog() {
        final Dialog dialog = new Dialog(MyScheduleDetailsActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_of_schedule_delete);
        dialog.show();
        EditText edit_msg = (EditText)dialog.findViewById(R.id.edt_message);
        Button btnCancel = (Button)dialog.findViewById(R.id.btn_cancel);
        Button btnSubmit = (Button)dialog.findViewById(R.id.btn_submit);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
