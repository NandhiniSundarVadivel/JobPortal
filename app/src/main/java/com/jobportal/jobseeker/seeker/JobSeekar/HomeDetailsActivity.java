package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeDetailsActivity extends AppCompatActivity {
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtSubTitle)
    TextView txtSubTitle;
    private String[] titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_details);
        ButterKnife.bind(this);
        titleText = getResources().getStringArray(R.array.begain_title_two);
        try {
            if (getIntent() != null) {
                String pos = getIntent().getStringExtra("pos");
                Log.e("posit", pos);
                int position = Integer.parseInt(pos);
                Log.e("position",position+"");
                txtTitle.setText(titleText[position]);
                txtSubTitle.setText(titleText[position]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
