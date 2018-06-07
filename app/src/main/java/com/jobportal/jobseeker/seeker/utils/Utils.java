package com.jobportal.jobseeker.seeker.utils;

import android.view.View;
import android.widget.TextView;

import com.jobportal.jobseeker.seeker.R;


/**
 * Created by uniflyn on 14/5/18.
 */

public class Utils {

    public static void setupItem(final View view, final LibraryObject libraryObject) {
        final TextView txt = (TextView) view.findViewById(R.id.txt_item);
        txt.setText(libraryObject.getTitle());



    }

    public static class LibraryObject {

        private String mTitle;
        private int mRes;
        private int mBanner;

        public LibraryObject( final String title) {
            mTitle = title;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(final String title) {
            mTitle = title;
        }

        public int getRes() {
            return mRes;
        }

        public void setRes(final int res) {
            mRes = res;
        }

        public int getmBanner() {
            return mBanner;
        }

    }
}
