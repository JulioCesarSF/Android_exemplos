package com.juliao.recylerview_retrofit.api;

import com.juliao.recylerview_retrofit.beans.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by schin on 23/05/2017.
 */

public interface ProdutoService {

    @GET("./")
    Call<List<Produto>> listar();
}
