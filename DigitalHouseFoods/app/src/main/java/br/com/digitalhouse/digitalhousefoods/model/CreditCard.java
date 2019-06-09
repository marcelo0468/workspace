package br.com.digitalhouse.digitalhousefoods.model;

public class CreditCard extends User{

    private String name;
    private String cardNumber;
    private int secureNumber;

    public CreditCard(String nome, String email, int password) {
        super(nome, email, password);
    }

    public CreditCard() {
    }

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
}
