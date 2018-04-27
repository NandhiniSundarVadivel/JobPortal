package com.jobportal.jobseeker.seeker.JobSeekar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by uniflyn on 26/4/18.
 */

public class ProfileSeekarActivity extends AppCompatActivity {
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_profile_edit)
    Button btnProfilrEdit;
    @BindView(R.id.img_edit_profile_pic)
    ImageView imgEditProfilePic;
    @BindView(R.id.btn_add_experience)
    Button btnAddExperience;
    @BindView(R.id.btn_edit_experience)
    Button btnEditExperience;
    @BindView(R.id.btn_add_education)
    Button btnAddEducation;
    @BindView(R.id.btn_edit_education)
    Button btnEditEducation;
    @BindView(R.id.btn_add_accomplishment)
    Button btnAddAccomplishment;
    @BindView(R.id.btn_edit_language)
    Button btnEditLanguage;
    @BindView(R.id.btn_edit_project)
    Button btnEditProject;
    @BindView(R.id.btn_edit_organization)
    Button btnEditOrganization;
    @BindView(R.id.btn_edit_certificate)
    Button btnEditCertificate;

    //testing
    //hi how are you shankari

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_seeker);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_profile_edit, R.id.img_edit_profile_pic, R.id.btn_add_experience, R.id.btn_edit_experience, R.id.btn_add_education, R.id.btn_edit_education, R.id.btn_add_accomplishment, R.id.btn_edit_language, R.id.btn_edit_project, R.id.btn_edit_organization, R.id.btn_edit_certificate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_profile_edit:
                Intent edit_profile=new Intent(ProfileSeekarActivity.this,EditProfileSeekerActivity.class);
                startActivity(edit_profile);
                break;
            case R.id.img_edit_profile_pic:
                break;
            case R.id.btn_add_experience:
                Intent add_experience=new Intent(ProfileSeekarActivity.this,AddExperienceActivity.class);
                add_experience.putExtra("edit_add","add");
                startActivity(add_experience);
                break;
            case R.id.btn_edit_experience:
                Intent edit_experience=new Intent(ProfileSeekarActivity.this,AddExperienceActivity.class);
                edit_experience.putExtra("edit_add","edit");
                startActivity(edit_experience);
                break;
            case R.id.btn_add_education:
                Intent add_education=new Intent(ProfileSeekarActivity.this,AddEducationActivity.class);
                add_education.putExtra("edit_add","add");
                startActivity(add_education);
                break;
            case R.id.btn_edit_education:
                Intent edit_education=new Intent(ProfileSeekarActivity.this,AddEducationActivity.class);
                edit_education.putExtra("edit_add","edit");
                startActivity(edit_education);
                break;
            case R.id.btn_add_accomplishment:
                Intent add_accomplishment=new Intent(ProfileSeekarActivity.this,AddAccomplishmentActivity.class);
                startActivity(add_accomplishment);
                break;
            case R.id.btn_edit_language:
                break;
            case R.id.btn_edit_project:
                break;
            case R.id.btn_edit_organization:
                break;
            case R.id.btn_edit_certificate:
                break;
        }
    }
}
