package com.jobportal.jobseeker.seeker.Company;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScheduleDetailsActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.btn_job_buuble)
    Button btnJobBuuble;
    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.btn_reschedule)
    Button btnReschedule;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    long lastDown,lastDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_details);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_reschedule, R.id.btn_delete,R.id.btn_job_buuble})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_reschedule:
                btnReschedule.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                btnDelete.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                callStartTimeDialog();
                break;
            case R.id.btn_delete:
                btnReschedule.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                btnDelete.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                callDeleteScheduleDialog();
                break;
            case R.id.btn_job_buuble:
                Intent intent = new Intent(ScheduleDetailsActivity.this,ChatCompanyActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    /*Schedule delete dialog*/

    private void callDeleteScheduleDialog() {
        final Dialog dialog = new Dialog(ScheduleDetailsActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_delete_schedule);
        dialog.show();

        final Button btnCancel = (Button)dialog.findViewById(R.id.btn_cancel);
        final Button btnSubmit = (Button)dialog.findViewById(R.id.btn_submit);

        btnCancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click","1");
                    btnCancel.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click","2");
                    dialog.dismiss();
                }

                return true;
            }
        });
        btnSubmit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click","1");
                    btnSubmit.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click","2");
                    dialog.dismiss();
                }

                return true;
            }
        });

    }

    /*Reschedule start time Dialog Showing*/
    private void callStartTimeDialog() {
        final Dialog dialog = new Dialog(ScheduleDetailsActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_reschedule_start_time);
        dialog.show();

        final Button btnCancel = (Button)dialog.findViewById(R.id.btn_cancel);
        final Button btnSet = (Button)dialog.findViewById(R.id.btn_set);

        btnCancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click","1");
                    btnCancel.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click","2");
                    dialog.dismiss();
                }

                return true;
            }
        });
        btnSet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click","1");
                    btnSet.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click","2");
                    dialog.dismiss();
                    callEndTimeDialog();
                }

                return true;
            }
        });


    }
    /*Reschedule end time Dialog Showing*/
    private void callEndTimeDialog() {
        final Dialog dialog = new Dialog(ScheduleDetailsActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_reschedule_end_time);
        dialog.show();

        final Button btnCancel = (Button)dialog.findViewById(R.id.btn_cancel);
        final Button btnSet = (Button)dialog.findViewById(R.id.btn_set);

        btnCancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click","1");
                    btnCancel.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click","2");
                    dialog.dismiss();
                }

                return true;
            }
        });
        btnSet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click","1");
                    btnSet.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click","2");
                    dialog.dismiss();
                    callMessageDialog();
                }

                return true;
            }
        });


    }

    /*Reschedule Message Dialog Showing*/
    private void callMessageDialog() {
        final Dialog dialog = new Dialog(ScheduleDetailsActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_message_schedule);
        dialog.show();

        final Button btnSubmit = (Button)dialog.findViewById(R.id.btn_submit);

        btnSubmit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                    Log.e("click","1");
                    btnSubmit.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    Log.e("click","2");
                    dialog.dismiss();

                }

                return true;
            }
        });
    }


}
