package com.jobportal.jobseeker.seeker.JobSeekar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jobportal.jobseeker.seeker.JobSeekar.SavedJobsDetailActivity;
import com.jobportal.jobseeker.seeker.JobSeekar.adapter.AdapterApplied;
import com.jobportal.jobseeker.seeker.JobSeekar.model.AppliedModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by uniflyn on 28/4/18.
 */

public class AppliedFragemnt extends Fragment {

    View rootView;

    Unbinder unbinder;
    @BindView(R.id.recycleApplied)
    RecyclerView recycleApplied;
    List<AppliedModel> appliedModels;
    AdapterApplied adapterApplied;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_applied, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleApplied.setLayoutManager(new LinearLayoutManager(getContext()));
        appliedModels = new ArrayList<>();
        appliedModels.add(new AppliedModel("App Developer","Part Time","Pafos Cyprus"));
        appliedModels.add(new AppliedModel("App Developer","Full Time","Pafos Cyprus"));
        appliedModels.add(new AppliedModel("App Developer","Full Time","Pafos Cyprus"));
        appliedModels.add(new AppliedModel("App Developer","Part Time","Pafos Cyprus"));
        adapterApplied  = new AdapterApplied(appliedModels, getContext(), new AdapterApplied.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent detail=new Intent(getContext(), SavedJobsDetailActivity.class);
                startActivity(detail);
            }
        });
        recycleApplied.setAdapter(adapterApplied);
        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

   /* @OnClick(R.id.linear_parrent)
    public void onViewClicked() {

        Intent detail=new Intent(getContext(), SavedJobsDetailActivity.class);
        startActivity(detail);
    }*/
}
