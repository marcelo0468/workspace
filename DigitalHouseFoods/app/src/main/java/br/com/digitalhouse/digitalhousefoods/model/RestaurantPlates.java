package br.com.digitalhouse.digitalhousefoods.model;

import android.os.Parcel;

public class RestaurantPlates extends Restaurant {

    private String plateName;
    private String plateDescription;
    private int plateImage;


    public RestaurantPlates() {
    }

    public RestaurantPlates(String plateName, String plateDescription, int plateImage) {
        this.plateName = plateName;
        this.plateDescription = plateDescription;
        this.plateImage = plateImage;
    }

    protected RestaurantPlates(Parcel in) {
        plateName = in.readString();
        plateDescription = in.readString();
        plateImage = in.readInt();
    }

    public static final Creator<RestaurantPlates> CREATOR = new Creator<RestaurantPlates>() {
        @Override
        public RestaurantPlates createFromParcel(Parcel source) {
            return new RestaurantPlates(source);
        }

        @Override
        public RestaurantPlates[] newArray(int size) {
            return new RestaurantPlates[size];
        }
    };


    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getPlateDescription() {
        return plateDescription;
    }

    public void setPlateDescription(String plateDescription) {
        this.plateDescription = plateDescription;
    }

    public int getPlateImage() {
        return plateImage;
    }

    public void setPlateImage(int plateImage) {
        this.plateImage = plateImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(plateName);
        dest.writeString(plateDescription);
        dest.writeInt(plateImage);
    }
}
