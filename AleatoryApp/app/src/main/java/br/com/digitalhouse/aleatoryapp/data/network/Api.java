package br.com.digitalhouse.aleatoryapp.data.network;

import br.com.digitalhouse.aleatoryapp.model.PessoasResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("api/")
    Single<PessoasResponse> getPessoas(@Query("results")int total);
}
