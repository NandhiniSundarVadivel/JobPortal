package com.jobportal.jobseeker.seeker.JobSeekar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
    List<TextModel> array_language;
    CustomAdapter adapter, adapter_language;
    @BindView(R.id.linear_one)
    LinearLayout linearOne;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accomplishment);
        ButterKnife.bind(this);

        array_text = new ArrayList<>();
        array_language = new ArrayList<>();

        array_text.add(new TextModel("Certificate", false));
        array_text.add(new TextModel("Organization", false));
        array_text.add(new TextModel("Project", false));
        array_text.add(new TextModel("Language", false));
        adapter = new CustomAdapter(AddAccomplishmentActivity.this, array_text);
        listView.setAdapter(adapter);

        array_language.add(new TextModel("Basic", true));
        array_language.add(new TextModel("Fluent", false));
        array_language.add(new TextModel("Native", false));
        adapter_language = new CustomAdapter(AddAccomplishmentActivity.this, array_language);
        //  listViewLanguage.setAdapter(adapter_language);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // view.setBackgroundResource(R.color.colorBlue);

                for (int i = 0; i < array_text.size(); i++) {
                    if (position == i) {
                        array_text.get(i).setSelect(true);
                    } else {
                        array_text.get(i).setSelect(false);
                    }
                }
                adapter.notifyDataSetChanged();
                String title = array_text.get(position).getText();
                Log.e("title",title);

                Intent intent = new Intent(AddAccomplishmentActivity.this,AddAccomplishedDetailsActivity.class);

                intent.putExtra("title",title);
                startActivity(intent);


            }
        });



    }



    @OnClick({ R.id.btn_back, R.id.btn_upload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_upload:

                break;

        }
    }
}
