package com.jobportal.jobseeker.seeker.JobPortalIntro.Activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.androidpagecontrol.PageControl;
import com.jobportal.jobseeker.seeker.JobPortalFragment.FragmentFive;
import com.jobportal.jobseeker.seeker.JobPortalFragment.FragmentFour;
import com.jobportal.jobseeker.seeker.JobPortalFragment.FragmentOne;
import com.jobportal.jobseeker.seeker.JobPortalFragment.FragmentSix;
import com.jobportal.jobseeker.seeker.JobPortalFragment.FragmentThree;
import com.jobportal.jobseeker.seeker.JobPortalFragment.FragmentTwo;
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
  /*  @BindView(R.id.imageSelected)
    ImageView imageSelected;*/
   /* @BindView(R.id.imageBanner)
    ImageView imageBanner;*/
    @BindView(R.id.linearCompany)
    LinearLayout linearCompany;
    @BindView(R.id.linearJob)
    LinearLayout linearJob;

    /*   @BindView(R.id.tab_layout)
       TabLayout tabLayout;
   */

    private Integer[] imageSelect = new Integer[]{
            R.drawable.dot_one,
            R.drawable.dot_two,
            R.drawable.dot_three,
            R.drawable.dot_four,
            R.drawable.dot_five

    };

    private Integer[] imageSelectBanner = new Integer[]{
            R.drawable.slider_image,
            R.drawable.cv,
            R.drawable.swipe,
            R.drawable.match,
            R.drawable.chat,
            R.drawable.notifications

    };

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
        if (checkPermission()) {
            //  tracker.connectClient();

        } else {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                if (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(INTERNET) == PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    // tracker.connectClient();
                }
            } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
                // tracker.connectClient();

            }
        }



        MyPagerAdapter begainAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(begainAdapter);
        pageControl.setViewPager(pager);
    }
    public class MyPagerAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS = 6;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }


        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment

                    return new FragmentOne();
                case 1: // Fragment # 0 - This will show FirstFragment different title

                    return new FragmentTwo();
                case 2: // Fragment # 1 - This will show SecondFragment


                    return new FragmentThree();
                case 3:


                    return new FragmentFour();
                case 4:
                    return new FragmentFive();
                case 5:
                    return new FragmentSix();
                default:
                    return null;
            }

        }
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
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS,
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearCompany.setBackground(getResources().getDrawable(R.drawable.background_rounded_company_sp_two));
                    linearJob.setBackground(getResources().getDrawable(R.drawable.background_rounded_sp_two));
                }
                //  callWhatsapp();
                Intent intent = new Intent(SplashPageActivity.this, SignInSignupActivity.class);
                intent.putExtra("page", "job");
                startActivity(intent);
                break;
            case R.id.btn_as_company:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearCompany.setBackground(getResources().getDrawable(R.drawable.background_rounded_sp_two));
                    linearJob.setBackground(getResources().getDrawable(R.drawable.background_rounded_company_sp_two));
                }
                Intent intentcompany = new Intent(SplashPageActivity.this, SignInSignupActivity.class);//SignInSignupActivity
                intentcompany.putExtra("page", "company");
                startActivity(intentcompany);
                break;
        }
    }

    private void callWhatsapp() {
        ContentResolver cr = getApplication().getContentResolver();

//RowContacts for filter Account Types
        Cursor contactCursor = cr.query(
                ContactsContract.RawContacts.CONTENT_URI,
                new String[]{ContactsContract.RawContacts._ID,
                        ContactsContract.RawContacts.CONTACT_ID},
                ContactsContract.RawContacts.ACCOUNT_TYPE + "= ?",
                new String[]{"com.whatsapp"},
                null);

//ArrayList for Store Whatsapp Contact
        ArrayList<String> myWhatsappContacts = new ArrayList<>();

        if (contactCursor != null) {
            if (contactCursor.getCount() > 0) {
                if (contactCursor.moveToFirst()) {
                    do {
                        //whatsappContactId for get Number,Name,Id ect... from  ContactsContract.CommonDataKinds.Phone
                        String whatsappContactId = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.RawContacts.CONTACT_ID));

                        if (whatsappContactId != null) {
                            //Get Data from ContactsContract.CommonDataKinds.Phone of Specific CONTACT_ID
                            Cursor whatsAppContactCursor = cr.query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    new String[]{ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                                            ContactsContract.CommonDataKinds.Phone.NUMBER,
                                            ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI,
                                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME},
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                                    new String[]{whatsappContactId}, null);

                            if (whatsAppContactCursor != null) {
                                whatsAppContactCursor.moveToFirst();
                                String id = whatsAppContactCursor.getString(whatsAppContactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                                String name = whatsAppContactCursor.getString(whatsAppContactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                                String number = whatsAppContactCursor.getString(whatsAppContactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                                whatsAppContactCursor.close();

                                //Add Number to ArrayList
                                myWhatsappContacts.add(number);

                                Log.e(" WhatsApp contac1 ", id);
                                Log.e(" WhatsApp contact2 ", name);
                                Log.e(" WhatsApp contact3 ", number);
                            }
                        }
                    } while (contactCursor.moveToNext());
                    contactCursor.close();
                }
            }
        }

        Log.e(" WhatsApp cont4", myWhatsappContacts.size() + "");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
