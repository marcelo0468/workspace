package br.com.digitalhouse.listacontato.model;

public class Contatos {

    private String nome;
    private int telefone;

    public Contatos() {
    }

    public Contatos(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
