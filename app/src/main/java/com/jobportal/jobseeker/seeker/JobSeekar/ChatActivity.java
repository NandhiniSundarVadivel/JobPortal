package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends AppCompatActivity {

    @BindView(R.id.btn_chat_back)
    Button btnChatBack;
    @BindView(R.id.btn_chat_attach)
    Button btnChatAttach;
    @BindView(R.id.btn_chat_send)
    Button btnChatSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_chat_back, R.id.btn_chat_attach, R.id.btn_chat_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_chat_back:
                onBackPressed();
                break;
            case R.id.btn_chat_attach:
                break;
            case R.id.btn_chat_send:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
