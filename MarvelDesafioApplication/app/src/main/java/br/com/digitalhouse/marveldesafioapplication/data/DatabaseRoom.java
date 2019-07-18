//package br.com.digitalhouse.marveldesafioapplication.data;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//import androidx.room.TypeConverters;
//
//import br.com.digitalhouse.marveldesafioapplication.data.dao.ResultsDao;
//import br.com.digitalhouse.marveldesafioapplication.model.MarvelResponse;
//import br.com.digitalhouse.marveldesafioapplication.model.Result;
//
//@Database(entities = {MarvelResponse.class}, version = 1, exportSchema = false)
//@TypeConverters(Converters.class) // Adicionamos os conversores
//public abstract class DatabaseRoom extends RoomDatabase {
//
//    // Criamos o DAO que será retornado
//    public abstract ResultsDao resultsDAO();
//
//    private static volatile DatabaseRoom INSTANCE;
//
//
//
//    public static DatabaseRoom getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (DatabaseRoom.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            DatabaseRoom.class, "marvel_db")
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//}
