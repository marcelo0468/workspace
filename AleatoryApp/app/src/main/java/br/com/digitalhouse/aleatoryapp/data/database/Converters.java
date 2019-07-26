package br.com.digitalhouse.aleatoryapp.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.com.digitalhouse.aleatoryapp.model.Dob;
import br.com.digitalhouse.aleatoryapp.model.Id;
import br.com.digitalhouse.aleatoryapp.model.Location;
import br.com.digitalhouse.aleatoryapp.model.Login;
import br.com.digitalhouse.aleatoryapp.model.Name;
import br.com.digitalhouse.aleatoryapp.model.Picture;
import br.com.digitalhouse.aleatoryapp.model.Registered;

public class Converters {

    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }

    /// Type converter para uam lista de String

    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uam lista de String

    @TypeConverter
    public Dob fromDob(String value) {
        Type listType = (Type) new TypeToken<Dob>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromDob(Dob dob) {
        Gson gson = new Gson();
        return gson.toJson(dob);
    }

    @TypeConverter
    public Id fromId(String value) {
        Type listType = (Type) new TypeToken<Id>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromId(Id id) {
        Gson gson = new Gson();
        return gson.toJson(id);
    }

    @TypeConverter
    public Location fromLocation(String value) {
        Type listType = (Type) new TypeToken<Location>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromLocation(Location location) {
        Gson gson = new Gson();
        return gson.toJson(location);
    }

    @TypeConverter
    public Login fromLogin(String value) {
        Type listType = (Type) new TypeToken<Location>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromLogin(Login login) {
        Gson gson = new Gson();
        return gson.toJson(login);
    }

    @TypeConverter
    public Name fromName(String value) {
        Type listType = (Type) new TypeToken<Location>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromName(Name name) {
        Gson gson = new Gson();
        return gson.toJson(name);
    }

    @TypeConverter
    public Picture fromPicture(String value) {
        Type listType = (Type) new TypeToken<Picture>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPicture(Picture picture) {
        Gson gson = new Gson();
        return gson.toJson(picture);
    }

    @TypeConverter
    public Registered fromRegistered(String value) {
        Type listType = (Type) new TypeToken<Registered>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPicture(Registered registered) {
        Gson gson = new Gson();
        return gson.toJson(registered);
    }
}
