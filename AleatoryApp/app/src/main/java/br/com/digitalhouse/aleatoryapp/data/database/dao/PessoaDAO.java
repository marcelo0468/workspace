package br.com.digitalhouse.aleatoryapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.aleatoryapp.model.Result;
import io.reactivex.Flowable;

@Dao
public interface PessoaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Result> results);

    @Update
    void update(Result result);

    @Delete
    void delete(Result result);

    @Query("SELECT * FROM pessoas limit 30")
    List<Result> getAll();

    @Query("SELECT * FROM pessoas limit 30")
    Flowable<List<Result>> getAllRxJava();

    @Query("SELECT * FROM pessoas WHERE idBanco = :id")
    Result getById(long id);

    @Query("SELECT * FROM pessoas WHERE name = :name")
    Result getByName(String name);
}