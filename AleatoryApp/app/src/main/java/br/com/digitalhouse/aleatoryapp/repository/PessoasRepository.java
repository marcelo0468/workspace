package br.com.digitalhouse.aleatoryapp.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.digitalhouse.aleatoryapp.data.network.ApiService;
import br.com.digitalhouse.aleatoryapp.model.PessoasResponse;
import io.reactivex.Single;

public class PessoasRepository {

    public Single<PessoasResponse> obterListaNoticiasDoArquivo(Context context) {
        try {
            AssetManager manager = context.getAssets();
            InputStream newJson = manager.open("aleatory.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(newJson));

            Gson gson = new Gson();

            PessoasResponse resposta = gson.fromJson(reader, PessoasResponse.class);

            return Single.just(resposta);

        } catch (IOException e) {
            e.printStackTrace();
            return Single.error(e);
        }
    }

    public Single<PessoasResponse> obterListaNoticiasInternet(){
        return ApiService.getApiService().getPessoas(30);
    }

}
