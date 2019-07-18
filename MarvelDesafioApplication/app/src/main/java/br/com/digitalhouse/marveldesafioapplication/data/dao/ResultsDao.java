//package br.com.digitalhouse.marveldesafioapplication.data.dao;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import java.util.List;
//
//import br.com.digitalhouse.marveldesafioapplication.model.MarvelResponse;
//import br.com.digitalhouse.marveldesafioapplication.model.Result;
//import io.reactivex.Flowable;
//
//@Dao
//public interface ResultsDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insert(MarvelResponse result);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insert(List<MarvelResponse> results);
//
//    @Update
//    void update(MarvelResponse result);
//
//    @Query("Delete from result")
//    void deleteAll();
//
//    @Delete
//    void delete(MarvelResponse result);
//
//    @Query("Select * from result limit 30")
//    Flowable<List<MarvelResponse>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE
//}
