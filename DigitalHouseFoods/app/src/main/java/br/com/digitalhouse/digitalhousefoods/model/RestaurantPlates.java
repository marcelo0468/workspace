package br.com.digitalhouse.digitalhousefoods.model;

import android.os.Parcel;

public class RestaurantPlates extends Restaurant {

    private String plateName;
    private String plateDescription;
    private int plateImage;



    public RestaurantPlates(Parcel in) {
    }

    public RestaurantPlates(String plateName, String plateDescription, int plateImage) {
        this.plateName = plateName;
        this.plateDescription = plateDescription;
        this.plateImage = plateImage;

    }

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

}

