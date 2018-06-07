package com.jobportal.jobseeker.seeker.Company;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatCompanyActivity extends AppCompatActivity {

    @BindView(R.id.btn_chat_back)
    Button btnChatBack;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.btn_chat_attach)
    Button btnChatAttach;
    @BindView(R.id.btn_chat_send)
    Button btnChatSend;
    @BindView(R.id.relative_calendar)
    RelativeLayout relativeCalendar;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_company);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_chat_back, R.id.text_title, R.id.btn_chat_attach, R.id.btn_chat_send,R.id.relative_calendar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_chat_back:
                onBackPressed();
                break;
            case R.id.text_title:
                break;
            case R.id.btn_chat_attach:
                break;
            case R.id.btn_chat_send:
                break;
            case R.id.relative_calendar:

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

//                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
