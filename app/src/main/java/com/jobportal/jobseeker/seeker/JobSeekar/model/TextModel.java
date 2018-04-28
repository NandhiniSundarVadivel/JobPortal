package com.jobportal.jobseeker.seeker.JobSeekar.model;

/**
 * Created by uniflyn on 27/4/18.
 */

public class TextModel {

    String text;
    boolean isSelect;

    public TextModel(String text, boolean isSelect) {
        this.text = text;
        this.isSelect = isSelect;
    }

    public String getText() {
        return text;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
