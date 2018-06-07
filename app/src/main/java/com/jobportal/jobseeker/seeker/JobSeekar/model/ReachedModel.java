package com.jobportal.jobseeker.seeker.JobSeekar.model;

/**
 * Created by uniflyn on 26/5/18.
 */

public class ReachedModel {
    String companyName;
    String companyAddress;

    public ReachedModel(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
