package com.jobportal.jobseeker.seeker.JobSeekar.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.JobSeekar.HomeDetailsZoomActivity;
import com.jobportal.jobseeker.seeker.R;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeHead;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

import static com.jobportal.jobseeker.seeker.JobSeekar.fragment.HomeFragment.viewGreen;
import static com.jobportal.jobseeker.seeker.JobSeekar.fragment.HomeFragment.viewRed;

/**
 * Created by janisharali on 19/08/16.
 */
@NonReusable
@Layout(R.layout.tinder_card_view)
public class TinderCard {

    @View(R.id.img_logo)
    ImageView img_logo;

    @View(R.id.txt_designation)
    TextView txt_designation;

    @View(R.id.txt_company_name)
    TextView txt_company_name;

    @View(R.id.txt_location)
    TextView txt_location;

    @View(R.id.layout_main)
    RelativeLayout layout_main;


    String txtDesignation,txtCompanyName,txtCompanyLocation;

    Context context;

    public TinderCard(Context context, String designation, String company, String location) {
        this.txtDesignation = designation;
        this.txtCompanyName = company;
        this.txtCompanyLocation = location;
        this.context  = context;
    }


    @Resolve
    public void onResolve() {
        txt_designation.setText( txtDesignation);
        txt_company_name.setText( txtCompanyName);
        txt_location.setText( txtCompanyLocation);
    }

    @SwipeOut
    public void onSwipedOut() {
        Log.e("DEBUG", "onSwipedOut");
        viewGreen.setVisibility(android.view.View.GONE);
        viewRed.setVisibility(android.view.View.GONE);

    }

    @SwipeCancelState
    public void onSwipeCancelState() {
        Log.e("DEBUG", "onSwipeCancelState");
        viewGreen.setVisibility(android.view.View.GONE);
        viewRed.setVisibility(android.view.View.GONE);
    }

    @SwipeIn
    public void onSwipeIn() {
        Log.e("DEBUG", "onSwipedIn");
        viewGreen.setVisibility(android.view.View.GONE);
        viewRed.setVisibility(android.view.View.GONE);
    }

    @SwipeInState
    public void onSwipeInState() {
        Log.e("DEBUG", "onSwipeInState");
        viewGreen.setVisibility(android.view.View.VISIBLE);
        viewRed.setVisibility(android.view.View.GONE);
    }

    @SwipeOutState
    public void onSwipeOutState() {
        Log.e("DEBUG", "onSwipeOutState");
        viewGreen.setVisibility(android.view.View.GONE);
        viewRed.setVisibility(android.view.View.VISIBLE);
    }

    @SwipeHead
    public void onSwipeHead() {
       // img_logo.setBackgroundColor(Color.BLUE);
        Log.d("DEBUG", "onSwipeHead");
    }

    @Click(R.id.layout_main)
    public void onProfileImageViewClick() {
        Log.d("DEBUG", "onProfileImageViewClick");
        Intent in = new Intent(context, HomeDetailsZoomActivity.class);
        context.startActivity(in);
    }

}
