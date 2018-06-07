package com.jobportal.jobseeker.seeker.Company.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Company.DashboardProfileActivity;
import com.jobportal.jobseeker.seeker.Company.Model.SavedModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

/**
 * Created by uniflyn on 16/10/17.
 */

public class AdapterSaved extends RecyclerView.Adapter<AdapterSaved.MyViewHolder> {
    private List<SavedModel> myProjectModels;
    static Context context;

    String userId;
    CustomItemClickListener listener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {



        TextView txt1,txt2,txt3;
        Button btn_delete,btn_report;
        LinearLayout lineOne;


        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt1 = (TextView)itemView.findViewById(R.id.txt_one);
            txt2 = (TextView)itemView.findViewById(R.id.txt_two);
            txt3 = (TextView)itemView.findViewById(R.id.txt_three);
            btn_delete = (Button)itemView.findViewById(R.id.btnDelete);
            btn_report = (Button)itemView.findViewById(R.id.btnReport);
            lineOne = (LinearLayout)itemView.findViewById(R.id.linearOne);





        }

    }

    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }
    public AdapterSaved(List<SavedModel> data, Context contexts, CustomItemClickListener customItemClickListener) {
        this.myProjectModels = data;
        context = contexts;
        this.listener = customItemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_saved_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.txt1.setText(myProjectModels.get(listPosition).getTxtOne());
        holder.txt2.setText(myProjectModels.get(listPosition).getTxtTwo());
        holder.txt3.setText(myProjectModels.get(listPosition).getTxtThree());
        holder.lineOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("click","adapter");
              /*  Intent intent = new Intent(context, ChatActivity.class);
                context.startActivity(intent);*/
            // listener.onItemClick(v,listPosition);
                Intent intet = new Intent(context, DashboardProfileActivity.class);
                intet.putExtra("page", "2");
                context.startActivity(intet);
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure you want to Delete Candidate?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                final AlertDialog alert = builder.create();
                alert.show();
            }
        });
        holder.btn_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
                dialog.setContentView(R.layout.dialog_report);
                dialog.show();
                Button btnCancel =  (Button)dialog.findViewById(R.id.btn_cancel);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return myProjectModels.size();
    }

}
