package br.com.digitalhouse.todolist.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalhouse.todolist.model.Nota;
import io.reactivex.Flowable;

@Dao
public interface NotasDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Nota nota);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Nota> notas);

    @Update
    void update(Nota nota);

    @Delete
    void delete(Nota nota);

    @Query("SELECT * FROM notas")
    List<Nota> getAll();

    @Query("SELECT * FROM notas")
    Flowable<List<Nota>> getAllRxJava();

    @Query("SELECT * FROM notas WHERE id = :id")
    Nota getById(long id);

    @Query("SELECT * FROM notas WHERE titulo = :nome")
    Nota getByName(String nome);

}
