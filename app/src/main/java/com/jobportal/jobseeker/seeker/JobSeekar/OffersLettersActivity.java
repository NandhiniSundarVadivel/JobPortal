package com.jobportal.jobseeker.seeker.JobSeekar;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OffersLettersActivity extends AppCompatActivity {

    @BindView(R.id.btn_offers_back)
    Button btnOffersBack;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    String desc = "<pre><strong><u>App Developer</u></strong> position at <strong><u>Scientronics Limited </u></strong> <span style=\"text-decoration: underline;\"><strong>Scientronics Limited</strong> </span>you have been hired! Your start date is <strong><u>01/01/2021</u></strong> with a starting salary of <strong><u>$5000.</u></strong></pre>";
    @BindView(R.id.btn_decline)
    Button btnDecline;
    @BindView(R.id.btn_accept)
    Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_letters);
        ButterKnife.bind(this);
        txtName.setPaintFlags(txtName.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtName.setText(getString(R.string.alexandros_papatheodoulou));


        txtDesc.setText(Html.fromHtml(desc));
        Log.e("value", txtDesc.getText().toString());

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick({R.id.btn_offers_back, R.id.btn_decline, R.id.btn_accept})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_offers_back:
                onBackPressed();
                break;
            case R.id.btn_decline:
                btnDecline.setBackgroundColor(getResources().getColor(R.color.colorRed1));
                break;
            case R.id.btn_accept:
                btnAccept.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
        }
    }
}
