package com.example.mon_mini_projet;


public class Model {
    String mSushiName;
    String mSushiDetails;
    int mSushiPhoto;

    public Model(String mSushiName,String mSushiDetails,int mSushiPhoto) {

        this.mSushiName = mSushiName;
        this.mSushiDetails = mSushiDetails;
        this.mSushiPhoto = mSushiPhoto;
    }
    public String getmSushiName() {
        return mSushiName;
    }

    public String getmSushiDetails() {
        return mSushiDetails;
    }

    public int getmSushiPhoto() {
        return mSushiPhoto;
    }
}