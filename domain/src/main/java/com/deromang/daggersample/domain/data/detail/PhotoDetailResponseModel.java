
package com.deromang.daggersample.domain.data.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoDetailResponseModel {

    @SerializedName("photo")
    @Expose
    private PhotoModel photo;
    @SerializedName("stat")
    @Expose
    private String stat;

    public PhotoModel getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoModel photo) {
        this.photo = photo;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
