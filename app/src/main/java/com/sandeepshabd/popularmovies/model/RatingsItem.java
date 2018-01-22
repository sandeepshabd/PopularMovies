package com.sandeepshabd.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RatingsItem implements Parcelable {

    @SerializedName("code")
    private String code;

    @SerializedName("body")
    private String body;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return
                "RatingsItem{" +
                        "code = '" + code + '\'' +
                        ",body = '" + body + '\'' +
                        "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.body);
    }

    public RatingsItem() {
    }

    protected RatingsItem(Parcel in) {
        this.code = in.readString();
        this.body = in.readString();
    }

    public static final Parcelable.Creator<RatingsItem> CREATOR = new Parcelable.Creator<RatingsItem>() {
        @Override
        public RatingsItem createFromParcel(Parcel source) {
            return new RatingsItem(source);
        }

        @Override
        public RatingsItem[] newArray(int size) {
            return new RatingsItem[size];
        }
    };
}