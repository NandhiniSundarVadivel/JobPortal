package com.jobportal.jobseeker.seeker.JobSeekar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobPortalIntro.Activity.SplashPageActivity;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountSettingActivity extends AppCompatActivity {

    @BindView(R.id.btn_change_pswd)
    Button btnChangePswd;
    @BindView(R.id.relative_chgpswd_option_show)
    RelativeLayout relativeChgpswdOptionShow;
    @BindView(R.id.btn_change_mail)
    Button btnChangeMail;
    @BindView(R.id.relative_changeemail_option_show)
    RelativeLayout relativeChangeemailOptionShow;
    @BindView(R.id.switch_be_reached)
    Switch switchBeReached;
    @BindView(R.id.btn_delete_my_accounts)
    Button btnDeleteMyAccounts;
    @BindView(R.id.btn_logout)
    Button btnLogout;
    @BindView(R.id.btn_back_as)
    Button btnBackAs;
    String subTitleTwo = "<p>By clicking<strong> \" Proceed \"</strong> your account will be permanently deleted</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back_as,R.id.btn_change_pswd, R.id.btn_change_mail, R.id.btn_delete_my_accounts, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_change_pswd:
                relativeChgpswdOptionShow.setVisibility(View.VISIBLE);
               /* relativeChgpswdOptionShow.setVisibility(View.VISIBLE);
                relativeChangeemailOptionShow.setVisibility(View.GONE);*/
                break;
            case R.id.btn_change_mail:
                relativeChangeemailOptionShow.setVisibility(View.VISIBLE);
              /*  relativeChgpswdOptionShow.setVisibility(View.GONE);
                relativeChangeemailOptionShow.setVisibility(View.VISIBLE);*/
                break;
            case R.id.btn_delete_my_accounts:
                callDialogDelete();
                break;
            case R.id.btn_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to Logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent intentTerms = new Intent(AccountSettingActivity.this, SplashPageActivity.class);
                                intentTerms.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intentTerms);
                                finish();


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                final AlertDialog alert = builder.create();
                alert.show();
                break;
            case R.id.btn_back_as:
                onBackPressed();
                break;
        }
    }

    private void callDialogDelete() {
        final Dialog dialog = new Dialog(AccountSettingActivity.this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_delete_as);
        dialog.show();
        TextView txtSubTitle = (TextView)dialog.findViewById(R.id.txt_subtitle_two);
        txtSubTitle.setText(Html.fromHtml(subTitleTwo));
        Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel_delete);
        Button btnProcessed = (Button)dialog.findViewById(R.id.btn_proceed_delete);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnProcessed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
