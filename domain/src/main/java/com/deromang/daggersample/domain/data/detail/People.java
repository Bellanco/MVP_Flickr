
package com.deromang.daggersample.domain.data.detail;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class People {

    @SerializedName("haspeople")
    @Expose
    private Integer haspeople;

    public Integer getHaspeople() {
        return haspeople;
    }

    public void setHaspeople(Integer haspeople) {
        this.haspeople = haspeople;
    }

}
