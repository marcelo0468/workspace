package br.com.digitalhouse.mvvmexercicioapplication.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.mvvmexercicioapplication.database.DAO.ProdutosDAO;


@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public abstract ProdutosDAO contatosDAO();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
