package com.jobportal.jobseeker.seeker.Company;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Company.Adapter.LeftNavAdapter;
import com.jobportal.jobseeker.seeker.Company.Frgment.HomeCompanyFragment;
import com.jobportal.jobseeker.seeker.Company.Model.ClassLeftDrawer;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class NavigationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.imv_mainnaveicon)
    ImageView imvMainnaveicon;
    @BindView(R.id.txv_title)
    TextView txvTitle;
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
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
    private ActionBarDrawerToggle mDrawerToggle;
    List<ClassLeftDrawer> rowItems;
    LeftNavAdapter leftNavAdapter;

    public static final String[] titles = new String[]{"HOME",
            "BROWSE CANDIDATES", "SAVED / SHORTLISTED PROFILES", "CREATE A JOB", "JOB LISTING", "STAGES", "SCHEDULE","SETTINGS"};


    public static final Integer[] images = {R.drawable.home_icon,
            R.drawable.search_icon, R.drawable.verify_icon, R.drawable.as_job_icon,R.drawable.job_list, R.drawable.stage_icon,
            R.drawable.my_schedule_icon, R.drawable.setting_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);
        ButterKnife.bind(this);
        setupDrawer();
        setupnavigation();
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayoutNew, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()

            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()

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
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        if (i == 0) {
            beginTransction(new HomeCompanyFragment());
        } else if (i == 1) {
           // beginTransction(new HomeFragment());
        } else if (i == 2) {
          //  beginTransction(new HomeFragment());
        } else if (i == 3) {
           // beginTransction(new HomeFragment());
        } else if (i == 4) {
           // beginTransction(new HomeFragment());
        } else if (i == 5) {
            //beginTransction(new HomeFragment());
        } else if (i == 6) {
         //   beginTransction(new HomeFragment());
        } else if (i == 7) {
           // beginTransction(new HomeFragment());
        }
    }

    @OnClick({R.id.imv_mainnaveicon, R.id.txv_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imv_mainnaveicon:
                opendrawer();

                break;
            case R.id.txv_title:
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
