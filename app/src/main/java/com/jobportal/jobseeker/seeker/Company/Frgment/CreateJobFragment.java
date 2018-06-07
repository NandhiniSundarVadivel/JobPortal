package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class CreateJobFragment extends Fragment {


    @BindView(R.id.linaeStage1)
    LinearLayout linaeStage1;
    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.txt2)
    TextView txt2;
    @BindView(R.id.txt3)
    TextView txt3;
    @BindView(R.id.txt4)
    TextView txt4;
    @BindView(R.id.txt5)
    TextView txt5;
    @BindView(R.id.linear_sub_stage1)
    LinearLayout linearSubStage1;
    @BindView(R.id.linearStage2)
    LinearLayout linearStage2;
    @BindView(R.id.linearStage3)
    LinearLayout linearStage3;
    Unbinder unbinder;
    @BindView(R.id.edtSL)
    EditText edtSL;
    @BindView(R.id.edtET)
    EditText edtET;
    @BindView(R.id.edtStage)
    EditText edtStage;
    @BindView(R.id.btn_clear)
    Button btnClear;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.linearStages)
    LinearLayout linearStages;
    @BindView(R.id.btn_stages)
    Button btnStages;
    boolean status = false,status1=false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_job, container, false);


        unbinder = ButterKnife.bind(this, view);
        edtSL.setEnabled(false);
        edtET.setEnabled(false);
        edtStage.setEnabled(false);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_stages,R.id.linaeStage1, R.id.txt1, R.id.txt2, R.id.txt3, R.id.txt4, R.id.txt5, R.id.btn_clear, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_stages:
                if(!status) {
                    linearStages.setVisibility(View.VISIBLE);
                    status = true;
                }else {
                    linearStages.setVisibility(View.GONE);
                    status = false;
                }
                break;
            case R.id.btn_submit:
                btnClear.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                btnSubmit.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                break;
            case R.id.btn_clear:
                btnClear.setBackgroundColor(getResources().getColor(R.color.colorSignup));
                btnSubmit.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                break;
            case R.id.linaeStage1:
                if(!status1) {
                    status1 = true;
                    linearSubStage1.setVisibility(View.VISIBLE);
                    linearStage2.setVisibility(View.GONE);
                    linearStage3.setVisibility(View.GONE);
                }else
                {   status1 = false;
                    linearSubStage1.setVisibility(View.GONE);
                    linearStage2.setVisibility(View.VISIBLE);
                    linearStage3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txt1:
                txt1.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                txt1.setTextColor(getResources().getColor(R.color.colorWhite));

                txt2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt2.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt3.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt4.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt5.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt5.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                break;
            case R.id.txt2:

                txt2.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                txt2.setTextColor(getResources().getColor(R.color.colorWhite));

                txt1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt1.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt3.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt4.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt5.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt5.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                break;
            case R.id.txt3:

                txt3.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                txt3.setTextColor(getResources().getColor(R.color.colorWhite));

                txt1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt1.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt2.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt4.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt5.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt5.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                break;
            case R.id.txt4:

                txt4.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                txt4.setTextColor(getResources().getColor(R.color.colorWhite));

                txt2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt2.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt3.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt1.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt5.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt5.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                break;
            case R.id.txt5:

                txt5.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));
                txt5.setTextColor(getResources().getColor(R.color.colorWhite));

                txt2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt2.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt3.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt4.setTextColor(getResources().getColor(R.color.colorBlackTwo));

                txt1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                txt1.setTextColor(getResources().getColor(R.color.colorBlackTwo));


                break;
        }
    }
}
