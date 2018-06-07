package com.jobportal.jobseeker.seeker.JobPortalIntroAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobPortalIntroModel.CompanySizeModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

/**
 * Created by uniflyn on 16/10/17.
 */

public class AdapterCompanySize extends RecyclerView.Adapter<AdapterCompanySize.MyViewHolder> {
    private List<CompanySizeModel> myProjectModels;
    static Context context;

    String userId;
    CustomItemClickListener listener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {



        TextView txt_company_size;
        LinearLayout linearone;


        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            txt_company_size = (TextView) itemView.findViewById(R.id.txt_complany_size);
            linearone = (LinearLayout)itemView.findViewById(R.id.linearOne);




        }

    }

    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }
    public AdapterCompanySize(List<CompanySizeModel> data, Context contexts,CustomItemClickListener itemClickListener) {
        this.myProjectModels = data;
//        listener = listener1;
        context = contexts;
        this.listener = itemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_company_size, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.txt_company_size.setText(myProjectModels.get(listPosition).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.linearone.setBackgroundColor(context.getResources().getColor(R.color.colorBlue));
              //  holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorBlue));
                listener.onItemClick(v, listPosition);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myProjectModels.size();
    }

}
