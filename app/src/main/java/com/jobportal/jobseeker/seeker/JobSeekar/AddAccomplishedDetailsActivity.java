package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAccomplishedDetailsActivity extends AppCompatActivity {

    String title;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.edit_description)
    EditText editDescription;
    @BindView(R.id.linear_description)
    LinearLayout linearDescription;
    @BindView(R.id.edit_language)
    EditText editLanguage;
    @BindView(R.id.btn_down_lan)
    Button btnDownLan;
    @BindView(R.id.txtBasic)
    TextView txtBasic;
    @BindView(R.id.linearBasic)
    LinearLayout linearBasic;
    @BindView(R.id.txtFl)
    TextView txtFl;
    @BindView(R.id.linearFl)
    LinearLayout linearFl;
    @BindView(R.id.txtNative)
    TextView txtNative;
    @BindView(R.id.linearNative)
    LinearLayout linearNative;
    @BindView(R.id.linearLan)
    LinearLayout linearLan;
    @BindView(R.id.linear_two)
    LinearLayout linearTwo;
    @BindView(R.id.linear_language)
    LinearLayout linearLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accomplished_details);
        ButterKnife.bind(this);
        try {
            if (getIntent() != null) {
                title = getIntent().getStringExtra("title");
                if (title.equalsIgnoreCase("Language")) {
                    linearDescription.setVisibility(View.GONE);
                    linearLanguage.setVisibility(View.VISIBLE);
                    editText.setText(title);
                } else {
                    linearDescription.setVisibility(View.VISIBLE);
                    linearLanguage.setVisibility(View.GONE);
                    editText.setText(title);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.btn_down_lan,R.id.btn_back, R.id.linearBasic, R.id.linearFl, R.id.linearNative})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_down_lan:
                linearLan.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.linearBasic:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearBasic.setBackground(getResources().getDrawable(R.drawable.background_box_fill_up));
                    linearFl.setBackground(getResources().getDrawable(R.drawable.background_box_fill));
                    linearNative.setBackground(getResources().getDrawable(R.drawable.background_box_fill_down_line));
                    linearLan.setBackground(getResources().getDrawable(R.drawable.background_stroke_white));
                }
                txtBasic.setTextColor(getResources().getColor(R.color.colorWhite));
                txtFl.setTextColor(getResources().getColor(R.color.colorBlackTwo));
                txtNative.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                break;
            case R.id.linearFl:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearBasic.setBackground(getResources().getDrawable(R.drawable.background_box_fill_up_line));
                    linearFl.setBackground(getResources().getDrawable(R.drawable.background_box_fill_blue));
                    linearNative.setBackground(getResources().getDrawable(R.drawable.background_box_fill_down_line));
                    linearLan.setBackground(getResources().getDrawable(R.drawable.background_stroke_white));
                }
                txtBasic.setTextColor(getResources().getColor(R.color.colorBlackTwo));
                txtFl.setTextColor(getResources().getColor(R.color.colorWhite));
                txtNative.setTextColor(getResources().getColor(R.color.colorBlackTwo));


                break;
            case R.id.linearNative:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearBasic.setBackground(getResources().getDrawable(R.drawable.background_box_fill_up_line));
                    linearFl.setBackground(getResources().getDrawable(R.drawable.background_box_fill));
                    linearNative.setBackground(getResources().getDrawable(R.drawable.background_box_fill_down));
                    linearLan.setBackground(getResources().getDrawable(R.drawable.background_stroke_white));
                }
                txtBasic.setTextColor(getResources().getColor(R.color.colorBlackTwo));
                txtFl.setTextColor(getResources().getColor(R.color.colorBlackTwo));
                txtNative.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
