package com.jobportal.jobseeker.seeker.JobSeekar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobSeekar.fragment.HomeFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.LettersFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.MyScheduleFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.RecordFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.SavedJobsFragment;
import com.jobportal.jobseeker.seeker.JobSeekar.fragment.SettingsFragment;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    View header;
    LinearLayout header_linear;
    CircleImageView profile_image;
    TextView txt_name;
    @BindView(R.id.txt_title)
    TextView txtTitle;
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
    String chat = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      /*  toolbar.setNavigationIcon(null);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.menu_icon));*/
        toolbar.setNavigationIcon(null);          // to hide Navigation icon



       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        displaySelectedScreen(R.id.nav_home);
        //Header navigation view
        header = navigationView.getHeaderView(0);
        header_linear = (LinearLayout) header.findViewById(R.id.linear_header);
        profile_image = (CircleImageView) header.findViewById(R.id.profile_image);
        txt_name = (TextView) header.findViewById(R.id.txt_name);

        header_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MainActivity.this, ProfileSeekarActivity.class);
                startActivity(profile);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);

        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:

                fragment = new HomeFragment();
                relativeChat.setVisibility(View.INVISIBLE);
                relativeDot.setVisibility(View.VISIBLE);
                imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
                //fragment = new Menu1();
                chat = "1";

                break;
            case R.id.nav_saved_jobs:
                fragment = new SavedJobsFragment();
                txtTitle.setText(R.string.saved_jobs_small);
                relativeChat.setVisibility(View.INVISIBLE);
                relativeDot.setVisibility(View.VISIBLE);
                imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
                chat = "1";
                break;
            case R.id.nav_record:
                fragment = new RecordFragment();
                txtTitle.setText(R.string.record_small);
                relativeChat.setVisibility(View.VISIBLE);
                relativeDot.setVisibility(View.VISIBLE);

                imgDots.setImageDrawable(getResources().getDrawable(R.drawable.dots_icon));
                imgChat.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
                chat = "2";
                break;
            case R.id.nav_my_schedule:
                txtTitle.setText(R.string.my_schedule_small);
                fragment = new MyScheduleFragment();
                relativeChat.setVisibility(View.INVISIBLE);
                relativeDot.setVisibility(View.VISIBLE);

                imgDots.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
                chat = "1";
                break;
            case R.id.nav_letters:
                txtTitle.setText(R.string.letters_small);
                fragment = new LettersFragment();
                relativeChat.setVisibility(View.VISIBLE);
                relativeDot.setVisibility(View.VISIBLE);
                imgDots.setImageDrawable(getResources().getDrawable(R.drawable.dots_icon));
                imgChat.setImageDrawable(getResources().getDrawable(R.drawable.chat_icon));
                chat = "2";
                break;
            case R.id.nav_settings:
                txtTitle.setText(R.string.settings_small);
                fragment = new SettingsFragment();
                relativeChat.setVisibility(View.INVISIBLE);
                relativeDot.setVisibility(View.INVISIBLE);
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @OnClick(R.id.relative_chat)
    public void onViewClicked() {
        Log.e("btnchat", "yes");
        Intent intentChat = new Intent(MainActivity.this, ChatActivity.class);
        startActivity(intentChat);

    }

    @OnClick({R.id.btn_chat, R.id.btn_dot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_chat:
                Intent intentChat2 = new Intent(MainActivity.this,ChatActivity.class);
                startActivity(intentChat2);
                break;
            case R.id.btn_dot:
                Log.e("chatstring",chat);
                if(chat.equalsIgnoreCase("1")){
                    Intent intentChat = new Intent(MainActivity.this,ChatActivity.class);
                    startActivity(intentChat);
                }
                break;
        }
    }

  /*  @OnClick({ R.id.btn_chat})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_chat:
                Log.e("btnchat","yes");
                Intent intentChat = new Intent(MainActivity.this,ChatActivity.class);
                startActivity(intentChat);
                break;
        }
    }*/
}
