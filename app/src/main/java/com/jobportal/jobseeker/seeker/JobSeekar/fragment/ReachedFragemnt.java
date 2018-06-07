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

import com.jobportal.jobseeker.seeker.JobSeekar.CompanyProfileViewActivity;
import com.jobportal.jobseeker.seeker.JobSeekar.adapter.AdapterReached;
import com.jobportal.jobseeker.seeker.JobSeekar.model.ReachedModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by uniflyn on 28/4/18.
 */

public class ReachedFragemnt extends Fragment {

    View rootView;

    Unbinder unbinder;
    @BindView(R.id.recycleApplied)
    RecyclerView recycleApplied;
    List<ReachedModel> reachedModels;
    AdapterReached adapterReached;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_reached, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleApplied.setLayoutManager(new LinearLayoutManager(getContext()));
        reachedModels = new ArrayList<>();
        reachedModels.add(new ReachedModel("Scientronics Limited","California"));
        reachedModels.add(new ReachedModel("Scientronics Limited","California"));
        reachedModels.add(new ReachedModel("Scientronics Limited","California"));
        adapterReached = new AdapterReached(reachedModels,getContext(), new AdapterReached.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent detail=new Intent(getContext(), CompanyProfileViewActivity.class);
                startActivity(detail);
            }
        });
        recycleApplied.setAdapter(adapterReached);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
/*
    @OnClick(R.id.linear_parrent)
    public void onViewClicked() {

        Intent detail=new Intent(getContext(), CompanyProfileViewActivity.class);
        startActivity(detail);
    }*/
}
