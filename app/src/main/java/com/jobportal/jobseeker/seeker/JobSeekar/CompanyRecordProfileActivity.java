package com.jobportal.jobseeker.seeker.JobSeekar;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class CompanyRecordProfileActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.prfPic)
    CircleImageView prfPic;
    @BindView(R.id.img_edit_profile_pic)
    ImageView imgEditProfilePic;
    @BindView(R.id.btn_edit_about)
    Button btnEditAbout;
    @BindView(R.id.btn_edit_cd)
    Button btnEditCd;
    @BindView(R.id.relativeEditDetails)
    RelativeLayout relativeEditDetails;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    Bitmap rotatedBitmap = null;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_record_profile);
        ButterKnife.bind(this);
        relativeEditDetails.setVisibility(View.GONE);

    }

    @OnClick({R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;

        }
    }

}
