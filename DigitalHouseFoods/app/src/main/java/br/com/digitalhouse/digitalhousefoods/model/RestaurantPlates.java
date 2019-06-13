package br.com.digitalhouse.digitalhousefoods.model;

public class RestaurantPlates extends Restaurant {

    private String plateName;
    private String plateDescription;
    private int plateImage;
    private Restaurant restaurant;


    public RestaurantPlates() {
    }

    public RestaurantPlates(String plateName, String plateDescription, int plateImage) {
        this.plateName = plateName;
        this.plateDescription = plateDescription;
        this.plateImage = plateImage;

    }

    public static boolean get(int i) {
        return true;
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

