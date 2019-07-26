package br.com.digitalhouse.exerciciomvvmapplication.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.exerciciomvvmapplication.data.database.dao.ProdutosDAO;
import br.com.digitalhouse.exerciciomvvmapplication.model.Produtos;

@androidx.room.Database(entities = Produtos.class, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public abstract ProdutosDAO produtosDAO();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "meu_bd")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }




}
