package com.jobportal.jobseeker.seeker.JobPortalIntroAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public callbackListener callbackListener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {



        TextView txt_company_size;


        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            txt_company_size = (TextView) itemView.findViewById(R.id.txt_complany_size);



        }

    }

    public  interface callbackListener{
        public void  callback();
    }
    public AdapterCompanySize(List<CompanySizeModel> data, Context contexts) {
        this.myProjectModels = data;
//        listener = listener1;
        context = contexts;

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

    }

    @Override
    public int getItemCount() {
        return myProjectModels.size();
    }

}
