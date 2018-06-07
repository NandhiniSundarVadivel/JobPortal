package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.Company.Adapter.AdapterSaved;
import com.jobportal.jobseeker.seeker.Company.DashboardProfileActivity;
import com.jobportal.jobseeker.seeker.Company.Model.SavedModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class SavedListFragment extends Fragment {


    @BindView(R.id.linearOne)
    LinearLayout linearOne;
    Unbinder unbinder;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    List<SavedModel> savedModels;
    AdapterSaved adapterSaved;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_list, container, false);

        unbinder = ButterKnife.bind(this, view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        savedModels = new ArrayList<>();
        savedModels.add(new SavedModel("Marios Papakonstantinou 25 - PhD","KPMG Specialist","Laranca, Cyprus"));
        savedModels.add(new SavedModel("Marios Papakonstantinou 25 - PhD","KPMG Specialist","Laranca, Cyprus"));
        savedModels.add(new SavedModel("Marios Papakonstantinou 25 - PhD","KPMG Specialist","Laranca, Cyprus"));
        savedModels.add(new SavedModel("Marios Papakonstantinou 25 - PhD","KPMG Specialist","Laranca, Cyprus"));
        savedModels.add(new SavedModel("Marios Papakonstantinou 25 - PhD","KPMG Specialist","Laranca, Cyprus"));
        adapterSaved = new AdapterSaved(savedModels, getContext(), new AdapterSaved.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intet = new Intent(getContext(), DashboardProfileActivity.class);
                intet.putExtra("page", "2");
                startActivity(intet);
            }
        });
        recycleView.setAdapter(adapterSaved);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.linearOne)
    public void onViewClicked() {
     /*   Intent intet = new Intent(getContext(), DashboardProfileActivity.class);
        intet.putExtra("page", "2");
        startActivity(intet);*/
    }
}
