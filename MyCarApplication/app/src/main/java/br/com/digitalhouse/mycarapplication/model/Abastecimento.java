package br.com.digitalhouse.mycarapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "abastecimento")
public class Abastecimento implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "dataAbastecimento")
    private Date dataAbastecimento;

    @ColumnInfo(name = "horaAbastecimento")
    private String horaAbastecimento;

    @ColumnInfo(name = "odometro")
    private int odometro;

    @ColumnInfo(name = "combustivel")
    private String combustivel;

    @ColumnInfo(name = "preco")
    private double preco;

    @ColumnInfo(name = "valorTotal")
    private double valorTotal;

    @ColumnInfo(name = "litros")
    private double litros;

    @ColumnInfo(name = "completando")
    private boolean completando;

    @ColumnInfo(name = "nomeDoPosto")
    private String nomeDoPosto;

    public Abastecimento(int odometro, double litros, String nomeDoPosto) {
        this.odometro = odometro;
        this.litros = litros;
        this.nomeDoPosto = nomeDoPosto;
    }

//    public Abastecimento(Date dataAbastecimento, String horaAbastecimento, int odometro, String combustivel, double preco, double valorTotal, double litros, boolean completando, String nomeDoPosto) {
//        this.dataAbastecimento = dataAbastecimento;
//        this.horaAbastecimento = horaAbastecimento;
//        this.odometro = odometro;
//        this.combustivel = combustivel;
//        this.preco = preco;
//        this.valorTotal = valorTotal;
//        this.litros = litros;
//        this.completando = completando;
//        this.nomeDoPosto = nomeDoPosto;
//    }


    protected Abastecimento(Parcel in) {
        id = in.readLong();
        odometro = in.readInt();
        combustivel = in.readString();
        preco = in.readDouble();
        valorTotal = in.readDouble();
        litros = in.readDouble();
        completando = in.readByte() != 0;
        nomeDoPosto = in.readString();
    }

    public static final Creator<Abastecimento> CREATOR = new Creator<Abastecimento>() {
        @Override
        public Abastecimento createFromParcel(Parcel in) {
            return new Abastecimento(in);
        }

        @Override
        public Abastecimento[] newArray(int size) {
            return new Abastecimento[size];
        }
    };


    public Date getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(Date dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public String getHoraAbastecimento() {
        return horaAbastecimento;
    }

    public void setHoraAbastecimento(String horaAbastecimento) {
        this.horaAbastecimento = horaAbastecimento;
    }

    public int getOdometro() {
        return odometro;
    }

    public void setOdometro(int odometro) {
        this.odometro = odometro;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public boolean isCompletando() {
        return completando;
    }

    public void setCompletando(boolean completando) {
        this.completando = completando;
    }

    public String getNomeDoPosto() {
        return nomeDoPosto;
    }

    public void setNomeDoPosto(String nomeDoPosto) {
        this.nomeDoPosto = nomeDoPosto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(odometro);
        dest.writeString(combustivel);
        dest.writeDouble(preco);
        dest.writeDouble(valorTotal);
        dest.writeDouble(litros);
        dest.writeByte((byte) (completando ? 1 : 0));
        dest.writeString(nomeDoPosto);
    }
}
