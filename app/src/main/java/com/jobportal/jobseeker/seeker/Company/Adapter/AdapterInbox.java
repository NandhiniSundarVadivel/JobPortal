package com.jobportal.jobseeker.seeker.Company.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Company.Model.InboxModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by uniflyn on 16/10/17.
 */

public class AdapterInbox extends RecyclerView.Adapter<AdapterInbox.MyViewHolder> {
    private List<InboxModel> myProjectModels;
    static Context context;

    String userId;
    CustomItemClickListener listener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {



        TextView txt_name;
        LinearLayout linearone;
        ImageView imagStar;
        CircleImageView imgUserPic;


        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txt_name = (TextView)itemView.findViewById(R.id.txtName);
            imagStar = (ImageView)itemView.findViewById(R.id.img_star);
            linearone = (LinearLayout)itemView.findViewById(R.id.linear);
            imgUserPic = (CircleImageView)itemView.findViewById(R.id.userPrf);



        }

    }

    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }
    public AdapterInbox(List<InboxModel> data, Context contexts,CustomItemClickListener customItemClickListener) {
        this.myProjectModels = data;
        context = contexts;
        this.listener = customItemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_inbox_lyout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.txt_name.setText(myProjectModels.get(listPosition).getTextName());
        holder.imgUserPic.setImageDrawable(context.getResources().getDrawable(R.drawable.placeholder_image_two));
        holder.imagStar.setImageResource(myProjectModels.get(listPosition).getImage());
        holder.linearone.setOnClickListener(new View.OnClickListener() {
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
