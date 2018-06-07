package com.jobportal.jobseeker.seeker.JobSeekar.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.Company.Model.ClassLeftDrawer;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

/**
 * Created by swesspos on 11/11/17.
 */

public class LeftNavAdapter extends ArrayAdapter<ClassLeftDrawer> {

    Context context;

    public LeftNavAdapter(Context context, int resourceId,
                          List<ClassLeftDrawer> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    public class ViewHolder {
        ImageView imageView;
        TextView txtTitle;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ClassLeftDrawer rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_main_left_drawer_menu, null);
            holder = new ViewHolder();
             holder.txtTitle = (TextView) convertView.findViewById(R.id.txv_nave);
            holder.imageView = (ImageView) convertView.findViewById(R.id.img_nave);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtTitle.setText(rowItem.getMenu_name());
        holder.imageView.setImageResource(rowItem.getMenu_img());

        return convertView;
    }
}