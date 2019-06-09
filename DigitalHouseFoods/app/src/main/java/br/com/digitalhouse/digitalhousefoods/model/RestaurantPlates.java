package br.com.digitalhouse.digitalhousefoods.model;

public class RestaurantPlates extends Restaurant {

    private String plateName;
    private String plateDescription;

    public RestaurantPlates() {
    }

    public RestaurantPlates(String plateName, String plateDescription) {
        this.plateName = plateName;
        this.plateDescription = plateDescription;
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
}
