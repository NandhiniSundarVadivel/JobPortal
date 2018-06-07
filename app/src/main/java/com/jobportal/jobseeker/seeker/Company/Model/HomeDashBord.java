package com.jobportal.jobseeker.seeker.Company.Model;

/**
 * Created by uniflyn on 21/5/18.
 */

public class HomeDashBord {
    public String prfName;
    public String prfLocation;
    public String prfJobTitle;

    public HomeDashBord(String prfName, String prfLocation, String prfJobTitle) {
        this.prfName = prfName;
        this.prfLocation = prfLocation;
        this.prfJobTitle = prfJobTitle;
    }

    public String getPrfName() {
        return prfName;
    }

    public void setPrfName(String prfName) {
        this.prfName = prfName;
    }

    public String getPrfLocation() {
        return prfLocation;
    }

    public void setPrfLocation(String prfLocation) {
        this.prfLocation = prfLocation;
    }

    public String getPrfJobTitle() {
        return prfJobTitle;
    }

    public void setPrfJobTitle(String prfJobTitle) {
        this.prfJobTitle = prfJobTitle;
    }
}
