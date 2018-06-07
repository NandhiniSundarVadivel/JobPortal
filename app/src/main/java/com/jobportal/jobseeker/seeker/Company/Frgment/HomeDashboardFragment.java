package com.jobportal.jobseeker.seeker.Company.Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jobportal.jobseeker.seeker.Company.Adapter.AdapterHomeDashBorad;
import com.jobportal.jobseeker.seeker.Company.DashboardProfileActivity;
import com.jobportal.jobseeker.seeker.Company.Model.HomeDashBord;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class HomeDashboardFragment extends Fragment {
    AdapterHomeDashBorad adapterHomeDashBorad;

    @BindView(R.id.linearItem)
    LinearLayout linearItem;
    Unbinder unbinder;
    @BindView(R.id.recyclePrf)
    RecyclerView recyclePrf;
    List<HomeDashBord> homeDashBordList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_dashboard_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);
       /* homeDashBordList = new ArrayList<>();
        homeDashBordList.add(new HomeDashBord("Marios Papakonstantinou 25 - PhD","Sales Executive, Scientronics","Nicosia, Cyprus"));
        homeDashBordList.add(new HomeDashBord("Marios Papakonstantinou 25 - PhD","Sales Executive, Scientronics","Nicosia, Cyprus"));
        homeDashBordList.add(new HomeDashBord("Marios Papakonstantinou 25 - PhD","Sales Executive, Scientronics","Nicosia, Cyprus"));
        homeDashBordList.add(new HomeDashBord("Marios Papakonstantinou 25 - PhD","Sales Executive, Scientronics","Nicosia, Cyprus"));
        homeDashBordList.add(new HomeDashBord("Marios Papakonstantinou 25 - PhD","Sales Executive, Scientronics","Nicosia, Cyprus"));
        homeDashBordList.add(new HomeDashBord("Marios Papakonstantinou 25 - PhD","Sales Executive, Scientronics","Nicosia, Cyprus"));


        recyclePrf.setLayoutManager(new  GridLayoutManager(getContext(), 2));
        adapterHomeDashBorad = new AdapterHomeDashBorad(homeDashBordList,getContext());
        recyclePrf.setAdapter(adapterHomeDashBorad);*/
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.linearItem)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), DashboardProfileActivity.class);
        intent.putExtra("page", "1");
        startActivity(intent);
    }
}
