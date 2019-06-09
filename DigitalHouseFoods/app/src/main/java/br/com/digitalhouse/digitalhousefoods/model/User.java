package br.com.digitalhouse.digitalhousefoods.model;

public class User {

    private String nome;
    private String email;
    private int password;

    public User() {
    }

    public User(String nome, String email, int password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
