package com.sandeepshabd.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ShowtimesItem implements Parcelable {

	@SerializedName("theatre")
	private Theatre theatre;

	@SerializedName("dateTime")
	private String dateTime;

	@SerializedName("barg")
	private boolean barg;

	public void setTheatre(Theatre theatre){
		this.theatre = theatre;
	}

	public Theatre getTheatre(){
		return theatre;
	}

	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	public void setBarg(boolean barg){
		this.barg = barg;
	}

	public boolean isBarg(){
		return barg;
	}

	@Override
 	public String toString(){
		return 
			"ShowtimesItem{" + 
			"theatre = '" + theatre + '\'' + 
			",dateTime = '" + dateTime + '\'' + 
			",barg = '" + barg + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(this.theatre, flags);
		dest.writeString(this.dateTime);
		dest.writeByte(this.barg ? (byte) 1 : (byte) 0);
	}

	public ShowtimesItem() {
	}

	protected ShowtimesItem(Parcel in) {
		this.theatre = in.readParcelable(Theatre.class.getClassLoader());
		this.dateTime = in.readString();
		this.barg = in.readByte() != 0;
	}

	public static final Parcelable.Creator<ShowtimesItem> CREATOR = new Parcelable.Creator<ShowtimesItem>() {
		@Override
		public ShowtimesItem createFromParcel(Parcel source) {
			return new ShowtimesItem(source);
		}

		@Override
		public ShowtimesItem[] newArray(int size) {
			return new ShowtimesItem[size];
		}
	};
}