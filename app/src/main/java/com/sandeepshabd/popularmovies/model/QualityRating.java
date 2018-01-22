package com.sandeepshabd.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class QualityRating implements Parcelable {

    @SerializedName("ratingsBody")
    private String ratingsBody;

    @SerializedName("value")
    private String value;

    public void setRatingsBody(String ratingsBody) {
        this.ratingsBody = ratingsBody;
    }

    public String getRatingsBody() {
        return ratingsBody;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return
                "QualityRating{" +
                        "ratingsBody = '" + ratingsBody + '\'' +
                        ",value = '" + value + '\'' +
                        "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ratingsBody);
        dest.writeString(this.value);
    }

    public QualityRating() {
    }

    protected QualityRating(Parcel in) {
        this.ratingsBody = in.readString();
        this.value = in.readString();
    }

    public static final Parcelable.Creator<QualityRating> CREATOR = new Parcelable.Creator<QualityRating>() {
        @Override
        public QualityRating createFromParcel(Parcel source) {
            return new QualityRating(source);
        }

        @Override
        public QualityRating[] newArray(int size) {
            return new QualityRating[size];
        }
    };
}