package com.jobportal.jobseeker.seeker.Company;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Global.Global;
import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompanyAboutEditActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    @BindView(R.id.txtAu)
    TextView txtAu;
    @BindView(R.id.edt_aboutus)
    EditText edtAboutus;
    @BindView(R.id.btn_enter)
    Button btnEnter;
    String abouts;
    @BindView(R.id.linearBootom)
    LinearLayout linearBootom;
    @BindView(R.id.btn_about)
    Button btnAbout;
    private KeyListener originalKeyListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_about_edit);
        ButterKnife.bind(this);
        originalKeyListener = edtAboutus.getKeyListener();
        edtAboutus.setKeyListener(null);

    }

    @OnClick({R.id.btn_back, R.id.btn_upload, R.id.btn_enter, R.id.txtAu,R.id.btn_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_about:
                linearBootom.setVisibility(View.VISIBLE);
                edtAboutus.setKeyListener(originalKeyListener);
                // Focus the field.
                edtAboutus.requestFocus();
                // Show soft keyboard for the user to enter the value.
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edtAboutus, InputMethodManager.SHOW_IMPLICIT);
                break;
            case R.id.txtAu:

                break;
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_upload:
                break;
            case R.id.btn_enter:
                abouts = edtAboutus.getText().toString();
                if (TextUtils.isEmpty(abouts)) {
                    Global.Toast(CompanyAboutEditActivity.this, getString(R.string.aboutus_empty));
                } else {
                    txtAu.setText(abouts);
                    edtAboutus.setText("");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
