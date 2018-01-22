package com.sandeepshabd.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Theatre implements Parcelable {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Theatre{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.id);
	}

	public Theatre() {
	}

	protected Theatre(Parcel in) {
		this.name = in.readString();
		this.id = in.readString();
	}

	public static final Parcelable.Creator<Theatre> CREATOR = new Parcelable.Creator<Theatre>() {
		@Override
		public Theatre createFromParcel(Parcel source) {
			return new Theatre(source);
		}

		@Override
		public Theatre[] newArray(int size) {
			return new Theatre[size];
		}
	};
}