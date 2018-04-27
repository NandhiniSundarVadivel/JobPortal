package com.jobportal.jobseeker.seeker.JobSeekar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.jobportal.jobseeker.seeker.JobSeekar.adapter.CustomAdapter;
import com.jobportal.jobseeker.seeker.JobSeekar.model.TextModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by uniflyn on 27/4/18.
 */

public class AddAccomplishmentActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.list_view)
    ListView listView;

    List<TextModel> array_text;
    List<TextModel> array_language ;
    CustomAdapter adapter,adapter_language;
    @BindView(R.id.linear_one)
    LinearLayout linearOne;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.edit_description)
    EditText editDescription;
    @BindView(R.id.linear_two)
    LinearLayout linearTwo;
    @BindView(R.id.linear_description)
    LinearLayout linearDescription;
    @BindView(R.id.edit_language)
    EditText editLanguage;
    @BindView(R.id.list_view_language)
    ListView listViewLanguage;
    @BindView(R.id.linear_language)
    LinearLayout linearLanguage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accomplishment);
        ButterKnife.bind(this);
        editText.setEnabled(false);
        array_text=new ArrayList<>();
        array_language=new ArrayList<>();

        array_text.add(new TextModel("Certificate",false));
        array_text.add(new TextModel("Organization",false));
        array_text.add(new TextModel("Project",false));
        array_text.add(new TextModel("Language",false));
        adapter = new CustomAdapter(AddAccomplishmentActivity.this, array_text);
        listView.setAdapter(adapter);

        array_language.add(new TextModel("Basic",true));
        array_language.add(new TextModel("Fluent",false));
        array_language.add(new TextModel("Native",false));
        adapter_language = new CustomAdapter(AddAccomplishmentActivity.this, array_language);
        listViewLanguage.setAdapter(adapter_language);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // view.setBackgroundResource(R.color.colorBlue);

                for (int i=0;i<array_text.size();i++){
                    if (position==i){
                        array_text.get(i).setSelect(true);
                    }else {
                        array_text.get(i).setSelect(false);
                    }
                }
                adapter.notifyDataSetChanged();

                callVisible(position);

            }
        });


        listViewLanguage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i=0;i<array_language.size();i++){
                    if (position==i){
                        array_language.get(i).setSelect(true);
                    }else {
                        array_language.get(i).setSelect(false);
                    }
                }
                adapter_language.notifyDataSetChanged();
            }
        });
    }

    private void callVisible(int certificate) {
        linearOne.setVisibility(View.GONE);
        linearTwo.setVisibility(View.VISIBLE);
        editText.setText(array_text.get(certificate).getText());

        if (certificate==3){
            linearDescription.setVisibility(View.GONE);
            linearLanguage.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.btn_back, R.id.btn_upload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_upload:
                onBackPressed();
                break;
        }
    }
}
