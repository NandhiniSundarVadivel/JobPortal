package com.jobportal.jobseeker.seeker.JobSeekar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Company.Adapter.LeftNavAdapter;
import com.jobportal.jobseeker.seeker.Company.Model.ClassLeftDrawer;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.HomeFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.LettersFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.MyScheduleFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.RecordFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.SavedJobsFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.SettingsFragment;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivityJobSeeker extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.imv_mainnaveicon)
    ImageView imvMainnaveicon;
    @BindView(R.id.txv_title)
    TextView txvTitle;
   /* @BindView(R.id.my_toolbar)
    Toolbar myToolbar;*/
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.linear_header)
    LinearLayout linearHeader;
    @BindView(R.id.lst_nave)
    ListView lstNave;
    @BindView(R.id.navlayout)
    LinearLayout navlayout;
    @BindView(R.id.drawer_layout_new)
    DrawerLayout drawerLayoutNew;
    @BindView(R.id.btn_chat)
    Button btnChat;
    @BindView(R.id.relative_chat)
    RelativeLayout relativeChat;
    @BindView(R.id.img_chat)
    ImageView imgChat;
    @BindView(R.id.btn_dot)
    Button btnDot;
    @BindView(R.id.img_dots)
    ImageView imgDots;
    @BindView(R.id.relative_dot)
    RelativeLayout relativeDot;
    @BindView(R.id.imgLog)
    ImageView imgLog;
    @BindView(R.id.relativeBack)
    LinearLayout relativeBack;
    private ActionBarDrawerToggle mDrawerToggle;
    List<ClassLeftDrawer> rowItems;
    LeftNavAdapter leftNavAdapter;
    String chat = "1",menushow="1";
    public static final String[] titles = new String[]{"HOME",
            "SAVED JOBS", "RECORD", "MY SCHEDULE", "LETTERS", "SETTINGS"};


    public static final Integer[] images = {R.drawable.home_icon,
            R.drawable.saved_jobs_icon, R.drawable.record_icon, R.drawable.my_schedule_icon, R.drawable.letter_icon, R.drawable.setting_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);
        ButterKnife.bind(this);
        setupDrawer();
        setupnavigation();
        beginTransction(new HomeFragment());
        relativeChat.setVisibility(View.INVISIBLE);
        relativeDot.setVisibility(View.VISIBLE);
        imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
        chat = "1";
        imgLog.setVisibility(View.VISIBLE);
        txvTitle.setVisibility(View.GONE);
        relativeBack.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayoutNew, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                relativeBack.setVisibility(View.GONE);
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                relativeBack.setVisibility(View.GONE);
            }
        };
        mDrawerToggle.syncState();

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayoutNew.setDrawerListener(mDrawerToggle);
    }

    private void setupnavigation() {

        rowItems = new ArrayList<ClassLeftDrawer>();
        for (int i = 0; i < titles.length; i++) {
            ClassLeftDrawer item = new ClassLeftDrawer(images[i], titles[i]);
            rowItems.add(item);
        }

        leftNavAdapter = new LeftNavAdapter(this,
                R.layout.activity_main_left_drawer_menu, rowItems);
        lstNave.setAdapter(leftNavAdapter);
        lstNave.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        if (i == 0) {

            beginTransction(new HomeFragment());
            relativeChat.setVisibility(View.INVISIBLE);
            relativeDot.setVisibility(View.VISIBLE);
            imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
            chat = "1";
            imgLog.setVisibility(View.VISIBLE);
            txvTitle.setVisibility(View.GONE);
            relativeBack.setVisibility(View.GONE);
            linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        } else if (i == 1) {
            beginTransction(new SavedJobsFragment());
            txvTitle.setText(R.string.saved_jobs_small);
            relativeChat.setVisibility(View.INVISIBLE);
            relativeDot.setVisibility(View.VISIBLE);
            imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
            chat = "1";
            imgLog.setVisibility(View.GONE);
            txvTitle.setVisibility(View.VISIBLE);
            relativeBack.setVisibility(View.GONE);
            linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        } else if (i == 2) {
            beginTransction(new RecordFragment());
            txvTitle.setText(R.string.record_small);
            relativeChat.setVisibility(View.VISIBLE);
            relativeDot.setVisibility(View.VISIBLE);
            imgLog.setVisibility(View.GONE);
            imgDots.setImageDrawable(getResources().getDrawable(R.drawable.dots_icon));
            imgChat.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
            chat = "2";
            txvTitle.setVisibility(View.VISIBLE);
            relativeBack.setVisibility(View.GONE);
            linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        } else if (i == 3) {
            beginTransction(new MyScheduleFragment());
            txvTitle.setText(R.string.my_schedule_small);
            relativeChat.setVisibility(View.INVISIBLE);
            relativeDot.setVisibility(View.VISIBLE);
            imgLog.setVisibility(View.GONE);
            imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
            txvTitle.setVisibility(View.VISIBLE);
            relativeBack.setVisibility(View.GONE);
            chat = "1";
            linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        } else if (i == 4) {
            beginTransction(new LettersFragment());
            txvTitle.setText(R.string.letters_small);
            relativeChat.setVisibility(View.VISIBLE);
            relativeDot.setVisibility(View.VISIBLE);
            imgLog.setVisibility(View.GONE);
            imgDots.setImageDrawable(getResources().getDrawable(R.drawable.dots_icon));
            imgChat.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
            txvTitle.setVisibility(View.VISIBLE);
            relativeBack.setVisibility(View.GONE);
            chat = "2";
            linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        } else if (i == 5) {
            beginTransction(new SettingsFragment());
            txvTitle.setText(R.string.settings_small);
            imgLog.setVisibility(View.GONE);
            relativeChat.setVisibility(View.INVISIBLE);
            relativeDot.setVisibility(View.INVISIBLE);
            txvTitle.setVisibility(View.VISIBLE);
            relativeBack.setVisibility(View.GONE);
            linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @OnClick({R.id.btn_menu_open, R.id.txv_title, R.id.btn_chat, R.id.btn_dot, R.id.linear_header,R.id.frame_container})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.frame_container:
                relativeBack.setVisibility(View.GONE);
                break;
            case R.id.linear_header:
                linearHeader.setBackgroundColor(getResources().getColor(R.color.colorHeader));
                Intent profile = new Intent(MainActivityJobSeeker.this, ProfileSeekarActivity.class);
                startActivity(profile);
                break;
            case R.id.btn_menu_open:
                opendrawer();

                break;
            case R.id.txv_title:
                break;
            case R.id.btn_chat:
                Intent intentChat2 = new Intent(MainActivityJobSeeker.this, InboxJobSeekerActivity.class);
                startActivity(intentChat2);
                break;
            case R.id.btn_dot:
                Log.e("chatstring", chat);
                if (chat.equalsIgnoreCase("1")) {
                    Intent intentChat = new Intent(MainActivityJobSeeker.this, InboxJobSeekerActivity.class);
                    startActivity(intentChat);
                }else {
/*
                    if(menushow.equals("1")) {

                        relativeBack.setVisibility(View.VISIBLE);
                        menushow = "2";
                    }else {
                        relativeBack.setVisibility(View.GONE);
                        menushow = "1";
                    }*/
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onresume","in"+menushow);
        relativeBack.setVisibility(View.GONE);
    }

    public void beginTransction(final Fragment fragment) {
     /*   InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.frame_container, fragment);
                    // transaction.addToBackStack(null);
                    transaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, 250);
        drawerLayoutNew.closeDrawers();
    }

    public void opendrawer() {

        drawerLayoutNew.openDrawer(GravityCompat.START);
    }

    public void closedrawer() {

        drawerLayoutNew.closeDrawers();
    }
}
