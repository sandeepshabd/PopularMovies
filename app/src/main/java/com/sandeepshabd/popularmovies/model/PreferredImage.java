package com.sandeepshabd.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PreferredImage implements Parcelable {

    @SerializedName("width")
    private String width;

    @SerializedName("text")
    private String text;

    @SerializedName("category")
    private String category;

    @SerializedName("uri")
    private String uri;

    @SerializedName("height")
    private String height;

    @SerializedName("primary")
    private String primary;

    public void setWidth(String width) {
        this.width = width;
    }

    public String getWidth() {
        return width;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getPrimary() {
        return primary;
    }

    @Override
    public String toString() {
        return
                "PreferredImage{" +
                        "width = '" + width + '\'' +
                        ",text = '" + text + '\'' +
                        ",category = '" + category + '\'' +
                        ",uri = '" + uri + '\'' +
                        ",height = '" + height + '\'' +
                        ",primary = '" + primary + '\'' +
                        "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.width);
        dest.writeString(this.text);
        dest.writeString(this.category);
        dest.writeString(this.uri);
        dest.writeString(this.height);
        dest.writeString(this.primary);
    }

    public PreferredImage() {
    }

    protected PreferredImage(Parcel in) {
        this.width = in.readString();
        this.text = in.readString();
        this.category = in.readString();
        this.uri = in.readString();
        this.height = in.readString();
        this.primary = in.readString();
    }

    public static final Parcelable.Creator<PreferredImage> CREATOR = new Parcelable.Creator<PreferredImage>() {
        @Override
        public PreferredImage createFromParcel(Parcel source) {
            return new PreferredImage(source);
        }

        @Override
        public PreferredImage[] newArray(int size) {
            return new PreferredImage[size];
        }
    };
}