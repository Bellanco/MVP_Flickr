
package com.deromang.daggersample.domain.data.detail;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("authorname")
    @Expose
    private String authorname;
    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("_content")
    @Expose
    private String content;
    @SerializedName("machine_tag")
    @Expose
    private Boolean machineTag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getMachineTag() {
        return machineTag;
    }

    public void setMachineTag(Boolean machineTag) {
        this.machineTag = machineTag;
    }

}
