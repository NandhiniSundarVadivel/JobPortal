package com.jobportal.jobseeker.seeker.JobSeekar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobSeekar.model.ReachedModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

/**
 * Created by uniflyn on 16/10/17.
 */

public class AdapterReached extends RecyclerView.Adapter<AdapterReached.MyViewHolder> {
    private List<ReachedModel> myProjectModels;
    static Context context;

    String userId;
    CustomItemClickListener listener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {



        TextView txt_name,txt_option,txt_address;



        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_name = (TextView)itemView.findViewById(R.id.txtOne);
            txt_option = (TextView)itemView.findViewById(R.id.txtTwo);
            txt_address = (TextView)itemView.findViewById(R.id.txtThree);




        }

    }

    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }
    public AdapterReached(List<ReachedModel> data, Context contexts, CustomItemClickListener customItemClickListener) {
        this.myProjectModels = data;
        context = contexts;
        this.listener = customItemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_record, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.txt_name.setText(myProjectModels.get(listPosition).getCompanyName());
        holder.txt_option.setVisibility(View.GONE);
        holder.txt_address.setText(myProjectModels.get(listPosition).getCompanyAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("click","adapter");
              /*  Intent intent = new Intent(context, ChatActivity.class);
                context.startActivity(intent);*/
               listener.onItemClick(v,listPosition);
            }
        });


    }

    @Override
    public int getItemCount() {
        return myProjectModels.size();
    }

}
