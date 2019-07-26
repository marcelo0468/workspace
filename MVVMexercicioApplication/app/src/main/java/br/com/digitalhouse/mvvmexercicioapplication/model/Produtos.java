package br.com.digitalhouse.mvvmexercicioapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produtos")
public class Produtos implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nomedoproduto")
    private String nomeDoProduto;

    @ColumnInfo(name = "preco")
    private double preco;

    public Produtos() {
    }

    public Produtos(String nomeDoProduto, double preco) {
        this.nomeDoProduto = nomeDoProduto;
        this.preco = preco;
    }

    protected Produtos(Parcel in) {
        id = in.readLong();
        nomeDoProduto = in.readString();
        preco = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nomeDoProduto);
        dest.writeDouble(preco);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Produtos> CREATOR = new Creator<Produtos>() {
        @Override
        public Produtos createFromParcel(Parcel in) {
            return new Produtos(in);
        }

        @Override
        public Produtos[] newArray(int size) {
            return new Produtos[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
