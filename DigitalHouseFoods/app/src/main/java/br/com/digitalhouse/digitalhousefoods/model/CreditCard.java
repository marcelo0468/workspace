package br.com.digitalhouse.digitalhousefoods.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CreditCard implements Parcelable {

    private String name;
    private String cardNumber;
    private int secureNumber;

    public CreditCard() {
    }

    public CreditCard(String name, String cardNumber, int secureNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.secureNumber = secureNumber;
    }

    protected CreditCard(Parcel in) {
        name = in.readString();
        cardNumber = in.readString();
        secureNumber = in.readInt();
    }

    public static final Creator<CreditCard> CREATOR = new Creator<CreditCard>() {
        @Override
        public CreditCard createFromParcel(Parcel in) {
            return new CreditCard(in);
        }

        @Override
        public CreditCard[] newArray(int size) {
            return new CreditCard[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSecureNumber() {
        return secureNumber;
    }

    public void setSecureNumber(int secureNumber) {
        this.secureNumber = secureNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(cardNumber);
        dest.writeInt(secureNumber);
    }
}
