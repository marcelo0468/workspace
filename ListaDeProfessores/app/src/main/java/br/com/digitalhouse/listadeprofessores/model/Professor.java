package br.com.digitalhouse.listadeprofessores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Professor implements Parcelable {

    private String nome;
    private String curso;
    private String curriculum;
    private int foto;


    public Professor() {
    }

    public Professor(String nome, String curso, String curriculum, int foto) {
        this.nome = nome;
        this.curso = curso;
        this.curriculum = curriculum;
        this.foto = foto;
    }

    protected Professor(Parcel in) {
        nome = in.readString();
        curso = in.readString();
        curriculum = in.readString();
        foto = in.readInt();
    }

    public static final Creator<Professor> CREATOR = new Creator<Professor>() {
        @Override
        public Professor createFromParcel(Parcel in) {
            return new Professor(in);
        }

        @Override
        public Professor[] newArray(int size) {
            return new Professor[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(curso);
        dest.writeString(curriculum);
        dest.writeInt(foto);
    }
}
