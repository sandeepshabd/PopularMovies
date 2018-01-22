package com.sandeepshabd.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieData implements Parcelable {

	@SerializedName("tmsId")
	private String tmsId;

	@SerializedName("longDescription")
	private String longDescription;

	@SerializedName("advisories")
	private List<String> advisories;

	@SerializedName("rootId")
	private String rootId;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("entityType")
	private String entityType;

	@SerializedName("directors")
	private List<String> directors;

	@SerializedName("titleLang")
	private String titleLang;

	@SerializedName("shortDescription")
	private String shortDescription;

	@SerializedName("title")
	private String title;

	@SerializedName("qualityRating")
	private QualityRating qualityRating;

	@SerializedName("holiday")
	private String holiday;

	@SerializedName("officialUrl")
	private String officialUrl;

	@SerializedName("topCast")
	private List<String> topCast;

	@SerializedName("descriptionLang")
	private String descriptionLang;

	@SerializedName("genres")
	private List<String> genres;

	@SerializedName("ratings")
	private List<RatingsItem> ratings;

	@SerializedName("showtimes")
	private List<ShowtimesItem> showtimes;

	@SerializedName("subType")
	private String subType;

	@SerializedName("runTime")
	private String runTime;

	@SerializedName("preferredImage")
	private PreferredImage preferredImage;

	@SerializedName("releaseYear")
	private int releaseYear;

	public void setTmsId(String tmsId){
		this.tmsId = tmsId;
	}

	public String getTmsId(){
		return tmsId;
	}

	public void setLongDescription(String longDescription){
		this.longDescription = longDescription;
	}

	public String getLongDescription(){
		return longDescription;
	}

	public void setAdvisories(List<String> advisories){
		this.advisories = advisories;
	}

	public List<String> getAdvisories(){
		return advisories;
	}

	public void setRootId(String rootId){
		this.rootId = rootId;
	}

	public String getRootId(){
		return rootId;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setEntityType(String entityType){
		this.entityType = entityType;
	}

	public String getEntityType(){
		return entityType;
	}

	public void setDirectors(List<String> directors){
		this.directors = directors;
	}

	public List<String> getDirectors(){
		return directors;
	}

	public void setTitleLang(String titleLang){
		this.titleLang = titleLang;
	}

	public String getTitleLang(){
		return titleLang;
	}

	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setQualityRating(QualityRating qualityRating){
		this.qualityRating = qualityRating;
	}

	public QualityRating getQualityRating(){
		return qualityRating;
	}

	public void setHoliday(String holiday){
		this.holiday = holiday;
	}

	public String getHoliday(){
		return holiday;
	}

	public void setOfficialUrl(String officialUrl){
		this.officialUrl = officialUrl;
	}

	public String getOfficialUrl(){
		return officialUrl;
	}

	public void setTopCast(List<String> topCast){
		this.topCast = topCast;
	}

	public List<String> getTopCast(){
		return topCast;
	}

	public void setDescriptionLang(String descriptionLang){
		this.descriptionLang = descriptionLang;
	}

	public String getDescriptionLang(){
		return descriptionLang;
	}

	public void setGenres(List<String> genres){
		this.genres = genres;
	}

	public List<String> getGenres(){
		return genres;
	}

	public void setRatings(List<RatingsItem> ratings){
		this.ratings = ratings;
	}

	public List<RatingsItem> getRatings(){
		return ratings;
	}

	public void setShowtimes(List<ShowtimesItem> showtimes){
		this.showtimes = showtimes;
	}

	public List<ShowtimesItem> getShowtimes(){
		return showtimes;
	}

	public void setSubType(String subType){
		this.subType = subType;
	}

	public String getSubType(){
		return subType;
	}

	public void setRunTime(String runTime){
		this.runTime = runTime;
	}

	public String getRunTime(){
		return runTime;
	}

	public void setPreferredImage(PreferredImage preferredImage){
		this.preferredImage = preferredImage;
	}

	public PreferredImage getPreferredImage(){
		return preferredImage;
	}

	public void setReleaseYear(int releaseYear){
		this.releaseYear = releaseYear;
	}

	public int getReleaseYear(){
		return releaseYear;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"tmsId = '" + tmsId + '\'' + 
			",longDescription = '" + longDescription + '\'' + 
			",advisories = '" + advisories + '\'' + 
			",rootId = '" + rootId + '\'' + 
			",releaseDate = '" + releaseDate + '\'' + 
			",entityType = '" + entityType + '\'' + 
			",directors = '" + directors + '\'' + 
			",titleLang = '" + titleLang + '\'' + 
			",shortDescription = '" + shortDescription + '\'' + 
			",title = '" + title + '\'' + 
			",qualityRating = '" + qualityRating + '\'' + 
			",holiday = '" + holiday + '\'' + 
			",officialUrl = '" + officialUrl + '\'' + 
			",topCast = '" + topCast + '\'' + 
			",descriptionLang = '" + descriptionLang + '\'' + 
			",genres = '" + genres + '\'' + 
			",ratings = '" + ratings + '\'' + 
			",showtimes = '" + showtimes + '\'' + 
			",subType = '" + subType + '\'' + 
			",runTime = '" + runTime + '\'' + 
			",preferredImage = '" + preferredImage + '\'' + 
			",releaseYear = '" + releaseYear + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.tmsId);
		dest.writeString(this.longDescription);
		dest.writeStringList(this.advisories);
		dest.writeString(this.rootId);
		dest.writeString(this.releaseDate);
		dest.writeString(this.entityType);
		dest.writeStringList(this.directors);
		dest.writeString(this.titleLang);
		dest.writeString(this.shortDescription);
		dest.writeString(this.title);
		dest.writeParcelable(this.qualityRating, flags);
		dest.writeString(this.holiday);
		dest.writeString(this.officialUrl);
		dest.writeStringList(this.topCast);
		dest.writeString(this.descriptionLang);
		dest.writeStringList(this.genres);
		dest.writeList(this.ratings);
		dest.writeList(this.showtimes);
		dest.writeString(this.subType);
		dest.writeString(this.runTime);
		dest.writeParcelable(this.preferredImage, flags);
		dest.writeInt(this.releaseYear);
	}

	public MovieData() {
	}

	protected MovieData(Parcel in) {
		this.tmsId = in.readString();
		this.longDescription = in.readString();
		this.advisories = in.createStringArrayList();
		this.rootId = in.readString();
		this.releaseDate = in.readString();
		this.entityType = in.readString();
		this.directors = in.createStringArrayList();
		this.titleLang = in.readString();
		this.shortDescription = in.readString();
		this.title = in.readString();
		this.qualityRating = in.readParcelable(QualityRating.class.getClassLoader());
		this.holiday = in.readString();
		this.officialUrl = in.readString();
		this.topCast = in.createStringArrayList();
		this.descriptionLang = in.readString();
		this.genres = in.createStringArrayList();
		this.ratings = new ArrayList<RatingsItem>();
		in.readList(this.ratings, RatingsItem.class.getClassLoader());
		this.showtimes = new ArrayList<ShowtimesItem>();
		in.readList(this.showtimes, ShowtimesItem.class.getClassLoader());
		this.subType = in.readString();
		this.runTime = in.readString();
		this.preferredImage = in.readParcelable(PreferredImage.class.getClassLoader());
		this.releaseYear = in.readInt();
	}

	public static final Parcelable.Creator<MovieData> CREATOR = new Parcelable.Creator<MovieData>() {
		@Override
		public MovieData createFromParcel(Parcel source) {
			return new MovieData(source);
		}

		@Override
		public MovieData[] newArray(int size) {
			return new MovieData[size];
		}
	};
}