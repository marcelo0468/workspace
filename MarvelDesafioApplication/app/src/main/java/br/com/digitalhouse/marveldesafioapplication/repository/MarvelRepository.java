package br.com.digitalhouse.marveldesafioapplication.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.digitalhouse.marveldesafioapplication.model.MarvelResponse;
import io.reactivex.Single;

import static br.com.digitalhouse.marveldesafioapplication.data.network.ApiService.getApiService;
import static br.com.digitalhouse.marveldesafioapplication.util.AppUtils.md5;

public class MarvelRepository {

    public Single<MarvelResponse> obterListaMarvelDoArquivo(Context context) {
        try {
            AssetManager manager = context.getAssets();
            InputStream newJson = manager.open("response.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(newJson));

            Gson gson = new Gson();

            MarvelResponse resposta = gson.fromJson(reader, MarvelResponse.class);

            return Single.just(resposta);


        } catch (IOException e) {
            e.printStackTrace();
            return Single.error(e);
        }
    }

    public static final String PUBLIC_KEY = "df01fa24a26772eacbca24090d120325" ;
    public static final String PRIVATE_KEY = "85e82eb670932a44982ae2245ebec0921e8b7e39" ;

    public Single<MarvelResponse> obterListaMarvelInternet(){
        String ts = Long.toString(System.currentTimeMillis() / 1000);
        String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

        return getApiService().getMarvel("magazine", "comic", true, "focDate", "50", ts, hash, PUBLIC_KEY);
    }
}
