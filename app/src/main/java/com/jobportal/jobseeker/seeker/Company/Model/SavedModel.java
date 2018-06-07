package com.jobportal.jobseeker.seeker.Company.Model;

/**
 * Created by uniflyn on 28/5/18.
 */

public class SavedModel {
    String txtOne;
    String txtTwo;
    String txtThree;

    public SavedModel(String txtOne, String txtTwo, String txtThree) {
        this.txtOne = txtOne;
        this.txtTwo = txtTwo;
        this.txtThree = txtThree;
    }

    public String getTxtOne() {
        return txtOne;
    }

    public void setTxtOne(String txtOne) {
        this.txtOne = txtOne;
    }

    public String getTxtTwo() {
        return txtTwo;
    }

    public void setTxtTwo(String txtTwo) {
        this.txtTwo = txtTwo;
    }

    public String getTxtThree() {
        return txtThree;
    }

    public void setTxtThree(String txtThree) {
        this.txtThree = txtThree;
    }
}
