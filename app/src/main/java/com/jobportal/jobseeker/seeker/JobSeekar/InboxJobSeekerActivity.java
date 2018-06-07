package com.jobportal.jobseeker.seeker.JobSeekar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jobportal.jobseeker.seeker.Company.Model.InboxModel;
import com.jobportal.jobseeker.seeker.JobSeekar.adapter.AdapterInboxJobSeeker;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InboxJobSeekerActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.recycleInbox)
    RecyclerView recycleInbox;
    List<InboxModel> inboxModelList;
    AdapterInboxJobSeeker adapterInbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_job_seeker);
        ButterKnife.bind(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleInbox.setLayoutManager(new LinearLayoutManager(this));
        inboxModelList = new ArrayList<>();
        inboxModelList.add(new InboxModel("Scientronics Limited","8:30AM","Hey, I wanted to ask about something related to your job",R.drawable.fav_icon));
        inboxModelList.add(new InboxModel("Scientronics Limited","8:30AM","Hey, I wanted to ask about something related to your job",R.drawable.star_icon));
        inboxModelList.add(new InboxModel("Scientronics Limited","8:30AM","Hey, I wanted to ask about something related to your job",R.drawable.star_icon));
        inboxModelList.add(new InboxModel("Scientronics Limited","8:30AM","Hey, I wanted to ask about something related to your job",R.drawable.fav_icon));
        inboxModelList.add(new InboxModel("Scientronics Limited","8:30AM","Hey, I wanted to ask about something related to your job",R.drawable.fav_icon));
        inboxModelList.add(new InboxModel("Scientronics Limited","8:30AM","Hey, I wanted to ask about something related to your job",R.drawable.star_icon));
        inboxModelList.add(new InboxModel("Scientronics Limited","8:30AM","Hey, I wanted to ask about something related to your job",R.drawable.star_icon));
        adapterInbox = new AdapterInboxJobSeeker(inboxModelList,InboxJobSeekerActivity.this, new AdapterInboxJobSeeker.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.e("move","chat");

                Intent intent = new Intent(InboxJobSeekerActivity.this, ChatActivity.class);
                startActivity(intent);

            }
        });
        recycleInbox.setAdapter(adapterInbox);
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
