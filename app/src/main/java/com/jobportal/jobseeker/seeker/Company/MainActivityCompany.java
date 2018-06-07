package com.jobportal.jobseeker.seeker.Company;

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
import com.jobportal.jobseeker.seeker.Company.Frgment.BrowseCandidtesFragment;
import com.jobportal.jobseeker.seeker.Company.Frgment.CreateJobFragment;
import com.jobportal.jobseeker.seeker.Company.Frgment.HomeCompanyFragment;
import com.jobportal.jobseeker.seeker.Company.Frgment.JobListingFragment;
import com.jobportal.jobseeker.seeker.Company.Frgment.SavedShortlistFragment;
import com.jobportal.jobseeker.seeker.Company.Frgment.ScheduleFragment;
import com.jobportal.jobseeker.seeker.Company.Frgment.SettingsFragment;
import com.jobportal.jobseeker.seeker.Company.Frgment.StagesFragment;
import com.jobportal.jobseeker.seeker.Company.Model.ClassLeftDrawer;
import com.jobportal.jobseeker.seeker.Global.Global;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivityCompany extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.imv_mainnaveicon)
    ImageView imvMainnaveicon;
    @BindView(R.id.txv_title)
    TextView txvTitle;
  /*  @BindView(R.id.my_toolbar)
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
    @BindView(R.id.relativeBack)
    LinearLayout relativeBack;
    @BindView(R.id.btn_menu_open)
    Button btnMenuOpen;
    @BindView(R.id.btn_sort_name)
    Button btnSortName;
    @BindView(R.id.btn_sort_age)
    Button btnSortAge;
    @BindView(R.id.relativedate)
    RelativeLayout relativedate;
    private ActionBarDrawerToggle mDrawerToggle;
    List<ClassLeftDrawer> rowItems;
    LeftNavAdapter leftNavAdapter;
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
    String chat = "1", menushow = "1",saveshort="1";
    public static final String[] titles = new String[]{"HOME",
            "BROWSE CANDIDATES", "SAVED / SHORTLISTED PROFILES", "CREATE A JOB", "JOB LISTING", "STAGES", "SCHEDULE", "SETTINGS"};


    public static final Integer[] images = {R.drawable.home_icon,
            R.drawable.search_icon, R.drawable.tick_icon_menu, R.drawable.as_job_icon, R.drawable.job_list, R.drawable.stage_icon,
            R.drawable.my_schedule_icon, R.drawable.setting_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);
        ButterKnife.bind(this);
        setupDrawer();
        setupnavigation();
        beginTransction(new HomeCompanyFragment());
        txvTitle.setText(R.string.home_small);
        chat = "2";
        profileImage.setImageDrawable(getResources().getDrawable(R.drawable.s_icon));
        txtName.setText("SCIENTRONICS LIMITED");
        relativeBack.setVisibility(View.GONE);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        //  lstNave.getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.background_selcted));

        if (i == 0) {
            beginTransction(new HomeCompanyFragment());
            HomeMenu();
//            view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        } else if (i == 1) {
            beginTransction(new BrowseCandidtesFragment());
            BrowseCandidate();
            // lstNave.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        } else if (i == 2) {
            beginTransction(new SavedShortlistFragment());
            SavedShorlist();
            //  lstNave.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        } else if (i == 3) {
            beginTransction(new CreateJobFragment());
            CreateJob();
            //  lstNave.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        } else if (i == 4) {
            beginTransction(new JobListingFragment());
            JobListing();
            // lstNave.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        } else if (i == 5) {
            beginTransction(new StagesFragment());
            Stages();
            //   lstNave.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        } else if (i == 6) {
            beginTransction(new ScheduleFragment());
            Schedule();
            // lstNave.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        } else if (i == 7) {
            beginTransction(new SettingsFragment());
            Setting();
            // lstNave.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        }
    }

    private void Setting() {
        txvTitle.setText(R.string.settings_small);
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.menu_icon));
        relativeChat.setVisibility(View.INVISIBLE);
        relativeDot.setVisibility(View.INVISIBLE);
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    private void Schedule() {
        txvTitle.setText(R.string.schedule);
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.back_icon));
        relativeChat.setVisibility(View.INVISIBLE);
        relativeDot.setVisibility(View.VISIBLE);
        imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
        chat = "1";
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    private void Stages() {
        txvTitle.setText(R.string.stages_small);
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.back_icon));
        relativeChat.setVisibility(View.INVISIBLE);
        relativeDot.setVisibility(View.INVISIBLE);
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    private void JobListing() {
        txvTitle.setText(R.string.job_listing_small);
        relativeChat.setVisibility(View.INVISIBLE);
        relativeDot.setVisibility(View.VISIBLE);
        imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
        chat = "1";
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.menu_icon));
    }

    private void CreateJob() {
        txvTitle.setText(R.string.create_a_job_small);
        relativeChat.setVisibility(View.INVISIBLE);
        relativeDot.setVisibility(View.INVISIBLE);
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.menu_icon));
    }

    private void SavedShorlist() {
        txvTitle.setText(R.string.profile);
        relativeChat.setVisibility(View.VISIBLE);
        relativeDot.setVisibility(View.VISIBLE);
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.menu_icon));
        imgDots.setImageDrawable(getResources().getDrawable(R.drawable.dots_icon));
        imgChat.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
        chat = "2";
        saveshort ="2";
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }


    private void BrowseCandidate() {
        txvTitle.setText(R.string.browse_candidates_small);
        relativeChat.setVisibility(View.INVISIBLE);
        relativeDot.setVisibility(View.INVISIBLE);
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.menu_icon));
    }

    private void HomeMenu() {
        txvTitle.setText(R.string.home_small);
        relativeChat.setVisibility(View.VISIBLE);
        relativeDot.setVisibility(View.VISIBLE);
//        imvMainnaveicon.setImageDrawable(getResources().getDrawable(R.drawable.menu_icon));
        imgDots.setImageDrawable(getResources().getDrawable(R.drawable.dots_icon));
        imgChat.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
        chat = "2";
        saveshort ="1";
        relativeBack.setVisibility(View.GONE);
        linearHeader.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    protected void onResume() {
        super.onResume();
        relativeBack.setVisibility(View.GONE);
    }

    @OnClick({R.id.btn_menu_open, R.id.linear_header, R.id.btn_dot, R.id.btn_chat, R.id.frame_container, R.id.btn_sort_name, R.id.btn_sort_age})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sort_age:
                Global.Toast(MainActivityCompany.this, "Sort by Age");
                break;
            case R.id.btn_sort_name:
                Global.Toast(MainActivityCompany.this, "Sort by Name");
                break;
            case R.id.frame_container:
                relativeBack.setVisibility(View.GONE);
                break;
            case R.id.btn_menu_open:
                opendrawer();

                break;
            case R.id.btn_chat:
                Intent intentInbox = new Intent(MainActivityCompany.this, InboxCompanyActivity.class);
                startActivity(intentInbox);
                break;
            case R.id.linear_header:
                linearHeader.setBackgroundColor(getResources().getColor(R.color.colorHeader));
                Intent intent = new Intent(MainActivityCompany.this, CompanyProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_dot:
                Log.e("chatstring", chat);
                if (chat.equalsIgnoreCase("1")) {
                    Intent intentInbox1 = new Intent(MainActivityCompany.this, InboxCompanyActivity.class);
                    startActivity(intentInbox1);
                } else {
                    if (menushow.equals("1")) {
                        if(saveshort.equals("2")){
                            relativedate.setVisibility(View.VISIBLE);
                        }else {
                            relativedate.setVisibility(View.GONE);
                        }

                        relativeBack.setVisibility(View.VISIBLE);
                        menushow = "2";
                    } else {
                        relativeBack.setVisibility(View.GONE);
                        menushow = "1";
                    }
                }
                break;
        }
    }

    public void beginTransction(final Fragment fragment) {
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
