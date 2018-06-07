package com.jobportal.jobseeker.seeker.Company.Model;

/**
 * Created by uniflyn on 12/5/18.
 */

public class InboxModel  {

    String textName;
    String textTime;
    String textMessge;
    int image;

    public InboxModel(String textName, String textTime, String textMessge,int images) {
        this.textName = textName;
        this.textTime = textTime;
        this.textMessge = textMessge;
        this.image = images;
    }



    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextTime() {
        return textTime;
    }

    public void setTextTime(String textTime) {
        this.textTime = textTime;
    }

    public String getTextMessge() {
        return textMessge;
    }

    public void setTextMessge(String textMessge) {
        this.textMessge = textMessge;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
