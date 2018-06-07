package com.jobportal.jobseeker.seeker.Company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImportCandidateActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_chat)
    Button btnChat;
    @BindView(R.id.lineOne)
    LinearLayout lineOne;
    @BindView(R.id.lineTwo)
    LinearLayout lineTwo;
    @BindView(R.id.lineThree)
    LinearLayout lineThree;
    @BindView(R.id.lineFour)
    LinearLayout lineFour;
    @BindView(R.id.lineFive)
    LinearLayout lineFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_candidate);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_chat,R.id.lineOne, R.id.lineTwo, R.id.lineThree, R.id.lineFour, R.id.lineFive})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_chat:
                Intent intent = new Intent(ImportCandidateActivity.this, InboxCompanyActivity.class);
                startActivity(intent);
                break;
            case R.id.lineOne:
                lineOne.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
            case R.id.lineTwo:
                lineTwo.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
            case R.id.lineThree:
                lineThree.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
            case R.id.lineFour:
                lineFour.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
            case R.id.lineFive:
                lineFive.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
