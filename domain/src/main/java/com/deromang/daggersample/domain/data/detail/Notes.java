
package com.deromang.daggersample.domain.data.detail;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notes {

    @SerializedName("note")
    @Expose
    private List<Object> note = null;

    public List<Object> getNote() {
        return note;
    }

    public void setNote(List<Object> note) {
        this.note = note;
    }

}
