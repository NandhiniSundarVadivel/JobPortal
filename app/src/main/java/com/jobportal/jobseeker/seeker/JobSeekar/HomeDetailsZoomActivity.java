package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeDetailsZoomActivity extends AppCompatActivity {
    @BindView(R.id.txtSubTitle)
    TextView txtSubTitle;
    @BindView(R.id.img_item)
    ImageView imgItem;
    @BindView(R.id.image_company)
    ImageView imageCompany;
    private String[] titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_details_zoom);
        ButterKnife.bind(this);
        titleText = getResources().getStringArray(R.array.begain_title_two);
        try {
            if (getIntent() != null) {
                String pos = getIntent().getStringExtra("pos");
                Log.e("posit", pos);
                int position = Integer.parseInt(pos);
                Log.e("position", position + "");
                txtSubTitle.setText(titleText[position]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*float x1 = relativeLayout.getScaleX();
        float y1 = relativeLayout.getScaleY();
        relativeLayout.setScaleX((float) (x1 - 0.1));
        relativeLayout.setScaleY((float) (y1 - 0.1));*/
    }
}
