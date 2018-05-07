package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidpagecontrol.PageControl;
import com.jobportal.jobseeker.seeker.Company.NavigationActivity;
import com.jobportal.jobseeker.seeker.JobPortalIntroAdapter.BegainAdapter;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class SplashPageActivity extends AppCompatActivity {

    @BindView(R.id.btn_as_job_seeker)
    Button btnAsJobSeeker;
    @BindView(R.id.btn_as_company)
    Button btnAsCompany;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 2000;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.page_control)
    PageControl pageControl;

    /*   @BindView(R.id.tab_layout)
       TabLayout tabLayout;
   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        ButterKnife.bind(this);
        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            }
        }

        final BegainAdapter adapter1 = new BegainAdapter(SplashPageActivity.this);
        pager.setAdapter(adapter1);
        pageControl.setViewPager(pager);
//        pageControl.setPosition(1);
/*
        tabLayout.setupWithViewPager(pager, true);
*/
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("activity", "2");
                // pos = position;
//                imageView.setImageDrawable(getResources().getDrawable(image[position]));
                //   imageSelected.setImageDrawable(getResources().getDrawable(imageSelect[position]));
                Log.e("countadapter", String.valueOf(adapter1.getCount()));
                //  Log.e("pos", String.valueOf(pos));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//granted
                } else {
//not granted
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public boolean checkPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            ArrayList<String> permissionList = new ArrayList<>();
            if (checkSelfPermission(CAMERA) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(CAMERA);
            }
            if (checkSelfPermission(INTERNET) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(INTERNET);
            }
            if (checkSelfPermission(READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(READ_EXTERNAL_STORAGE);
            }
            if (permissionList.size() > 0) {
                String[] permissionArray = new String[permissionList.size()];
                permissionList.toArray(permissionArray);
                requestPermissions(permissionArray, REQUEST_ID_MULTIPLE_PERMISSIONS);
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    @OnClick({R.id.btn_as_job_seeker, R.id.btn_as_company})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_as_job_seeker:
                Intent intent = new Intent(SplashPageActivity.this, SignInSignupActivity.class);
                intent.putExtra("page", "job");
                startActivity(intent);
                break;
            case R.id.btn_as_company:
                Intent intentcompany = new Intent(SplashPageActivity.this, NavigationActivity.class);
                intentcompany.putExtra("page", "company");
                startActivity(intentcompany);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
