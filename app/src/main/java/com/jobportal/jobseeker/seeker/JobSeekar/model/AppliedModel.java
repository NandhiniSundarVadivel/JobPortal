package com.jobportal.jobseeker.seeker.JobSeekar.model;

/**
 * Created by uniflyn on 26/5/18.
 */

public class AppliedModel {
    String userName;
    String userJobType;
    String userAddreess;

    public AppliedModel(String userName, String userJobType, String userAddreess) {
        this.userName = userName;
        this.userJobType = userJobType;
        this.userAddreess = userAddreess;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserJobType() {
        return userJobType;
    }

    public void setUserJobType(String userJobType) {
        this.userJobType = userJobType;
    }

    public String getUserAddreess() {
        return userAddreess;
    }

    public void setUserAddreess(String userAddreess) {
        this.userAddreess = userAddreess;
    }
}
