package com.jobportal.jobseeker.seeker.Company.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Company.Model.HomeDashBord;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

/**
 * Created by uniflyn on 16/10/17.
 */

public class AdapterHomeDashBorad extends RecyclerView.Adapter<AdapterHomeDashBorad.MyViewHolder> {
    private List<HomeDashBord> myProjectModels;
    static Context context;

    String userId;
    CustomItemClickListener listener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {



        TextView txt_name,txt_job_title,txt_loc;
        LinearLayout linearone;


        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            txt_name = (TextView) itemView.findViewById(R.id.txtName);
            txt_job_title = (TextView) itemView.findViewById(R.id.txtJobTitle);
            txt_loc = (TextView)itemView.findViewById(R.id.txtLoc);




        }

    }

    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }
    public AdapterHomeDashBorad(List<HomeDashBord> data, Context contexts) {
        this.myProjectModels = data;
//        listener = listener1;
        context = contexts;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_dashboard_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.txt_name.setText(myProjectModels.get(listPosition).getPrfName());
        holder.txt_job_title.setText(myProjectModels.get(listPosition).getPrfJobTitle());
        holder.txt_loc.setText(myProjectModels.get(listPosition).getPrfLocation());

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.linearone.setBackgroundColor(context.getResources().getColor(R.color.colorBlue));
              //  holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorBlue));
                listener.onItemClick(v, listPosition);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return myProjectModels.size();
    }

}
