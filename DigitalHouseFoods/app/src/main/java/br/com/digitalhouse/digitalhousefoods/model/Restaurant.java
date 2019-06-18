package br.com.digitalhouse.digitalhousefoods.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Restaurant extends ArrayList<Parcelable> implements Parcelable {
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantHours;
    private int restaurantImage;
    private ArrayList<Restaurant> restaurantPlates = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String restaurantAddress, String restaurantHours, int restaurantImage, List<RestaurantPlates> restaurantPlates) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantHours = restaurantHours;
        this.restaurantImage = restaurantImage;
        //this.restaurantPlates = restaurantPlates;

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
        restaurantPlates = in.createTypedArrayList(RestaurantPlates.CREATOR);

         final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
            @Override
            public Restaurant createFromParcel(Parcel in) {
                return new Restaurant(in);
            }

            @Override
            public Restaurant[] newArray(int size) {
                return new Restaurant[size];
            }
        };



    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(restaurantName);
        dest.writeString(restaurantAddress);
        dest.writeString(restaurantHours);
        dest.writeInt(restaurantImage);
        dest.writeTypedList(restaurantPlates);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public ArrayList<Restaurant> getRestaurantPlates() {
        return restaurantPlates;
    }

    public void setRestaurantPlates(ArrayList<Restaurant> restaurantPlates) {
        this.restaurantPlates = restaurantPlates;
    }

    public static Creator<Restaurant> getCREATOR() {
        return CREATOR;
    }

    @Override
    public Stream<Parcelable> stream() {
        return null;
    }
}
