package br.com.digitalhouse.digitalhousefoods.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Parcelable {
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantHours;
    private int restaurantImage;
    private List<RestaurantPlates> restaurantPlates = new ArrayList<RestaurantPlates>();

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String restaurantAddress, String restaurantHours, int restaurantImage, List<RestaurantPlates> restaurantPlates) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantHours = restaurantHours;
        this.restaurantImage = restaurantImage;
        this.restaurantPlates = restaurantPlates;

    }

    public Restaurant(String restaurantName, String restaurantAddress, String restaurantHours, int restaurantImage) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantHours = restaurantHours;
        this.restaurantImage = restaurantImage;

    }

    protected Restaurant(Parcel in) {
        restaurantName = in.readString();
        restaurantAddress = in.readString();
        restaurantHours = in.readString();
        restaurantImage = in.readInt();
        restaurantPlates = in.readArrayList(Restaurant.class.getClassLoader());
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public CharSequence getRestaurantPlates() {
        return (CharSequence) restaurantPlates;
    }

    public void setRestaurantPlates(List<RestaurantPlates> restaurantPlates) {
        this.restaurantPlates = restaurantPlates;
    }





    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantHours() {
        return restaurantHours;
    }

    public void setRestaurantHours(String restaurantHours) {
        this.restaurantHours = restaurantHours;
    }

    public int getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(int restaurantImage) {
        this.restaurantImage = restaurantImage;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(restaurantName);
        dest.writeString(restaurantAddress);
        dest.writeString(restaurantHours);
        dest.writeInt(restaurantImage);
        dest.writeList(restaurantPlates);
    }





}
