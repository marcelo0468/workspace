package br.com.digitalhouse.mycarapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.mycarapplication.model.Abastecimento;
import io.reactivex.Flowable;

@Dao
public interface AbastecimentoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Abastecimento abastecimento);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Abastecimento> abastecimentos);

    @Update
    void update(Abastecimento abastecimento);

    @Delete
    void delete(Abastecimento abastecimento);

    @Query("SELECT * FROM abastecimento")
    List<Abastecimento> getAll();

    @Query("SELECT * FROM abastecimento")
    Flowable<List<Abastecimento>> getAllRxJava();

    @Query("SELECT * FROM abastecimento WHERE id = :id")
    Abastecimento getById(long id);

    @Query("SELECT * FROM abastecimento WHERE dataAbastecimento = :data")
    Abastecimento getByName(String data);

}
