package com.jobportal.jobseeker.seeker.JobSeekar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobSeekar.model.TextModel;
import com.jobportal.jobseeker.seeker.R;

import java.util.List;

/**
 * Created by uniflyn on 27/4/18.
 */

public class CustomAdapter extends ArrayAdapter<TextModel> {
    List<TextModel> array;
    Context context;
    public CustomAdapter(@NonNull Context context, @NonNull List<TextModel> objects) {
        super(context, R.layout.item_text, objects);
        array=objects;
        this.context=context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        view = inflater.inflate(R.layout.item_text, null, true);

        TextView txtTitle = (TextView) view.findViewById(R.id.text);

        txtTitle.setText(array.get(position).getText());

        if (array.get(position).isSelect()){
            //view.setBackgroundColor(context.getResources().getColor(R.color.colorBlue));
            txtTitle.setBackgroundColor(context.getResources().getColor(R.color.colorBlue));
            txtTitle.setTextColor(context.getResources().getColor(R.color.colorWhite));
        }else {
            //view.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            txtTitle.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            txtTitle.setTextColor(context.getResources().getColor(R.color.colorGrayOne));
        }
        return view;
    }
}
