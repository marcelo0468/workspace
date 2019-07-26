package br.com.digitalhouse.exerciciomvvmapplication.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.exerciciomvvmapplication.model.Produtos;
import io.reactivex.Flowable;

@Dao
public interface ProdutosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Produtos produtos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Produtos> produtos);

    @Update
    void update(Produtos produtos);

    @Delete
    void delete(Produtos produtos);

    @Query("SELECT * FROM produtos")
    List<Produtos> getAll();

    @Query("SELECT * FROM produtos")
    Flowable<List<Produtos>> getAllRxJava();

    @Query("SELECT * FROM produtos WHERE id = :id")
    Produtos getById(long id);

    @Query("SELECT * FROM produtos WHERE nomeProduto = :nome")
    Produtos getByName(String nome);

}
