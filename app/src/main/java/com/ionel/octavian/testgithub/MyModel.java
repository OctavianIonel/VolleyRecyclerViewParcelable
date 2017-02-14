package com.ionel.octavian.testgithub;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by octavian on 1/29/17.
 */

public class MyModel implements Parcelable {
    private String photo;
    private String name;
    private String repositoryName;
    private String description;
    private String url;
    private String stargazers;
    private String forks;
    private String watchers;
    private String openIssues;


    public static final Parcelable.Creator<MyModel> CREATOR = new Parcelable.Creator<MyModel>() {

        @Override
        public MyModel createFromParcel(Parcel parcel) {
            return new MyModel(parcel);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

    public MyModel(Parcel p) {
        photo = p.readString();
        name = p.readString();
        repositoryName = p.readString();
        description = p.readString();
        url = p.readString();
        stargazers = p.readString();
        forks = p.readString();
        watchers = p.readString();
        openIssues = p.readString();
    }

    public MyModel() {
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getStargazers() {
        return stargazers;
    }

    public void setStargazers(String stargazers) {
        this.stargazers = stargazers;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getWatchers() {
        return watchers;
    }

    public void setWatchers(String watchers) {
        this.watchers = watchers;
    }

    public String getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(String openIssues) {
        this.openIssues = openIssues;
    }

    public static Creator<MyModel> getCREATOR() {
        return CREATOR;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photo);
        dest.writeString(name);
        dest.writeString(repositoryName);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(stargazers);
        dest.writeString(forks);
        dest.writeString(watchers);
        dest.writeString(openIssues);

    }
}
