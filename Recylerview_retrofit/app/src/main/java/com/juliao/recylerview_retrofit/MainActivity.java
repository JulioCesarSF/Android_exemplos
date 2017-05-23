package com.juliao.recylerview_retrofit;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.juliao.recylerview_retrofit.adapters.ListaProdutoAdapter;
import com.juliao.recylerview_retrofit.api.ProdutoService;
import com.juliao.recylerview_retrofit.beans.Produto;
import com.juliao.recylerview_retrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MAIN";
    private ActivityMainBinding binding;
    private ListaProdutoAdapter adapter;

    private final String URL = "http://192.168.1.30:8686/WebserviceREST/api/produto/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClasse(this);


        binding.rvLista.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListaProdutoAdapter(new ArrayList<Produto>());

        binding.rvLista.setAdapter(adapter);
        binding.rvLista.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public void listar() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        ProdutoService api = retrofit.create(ProdutoService.class);
        api.listar().enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                if (response.isSuccessful()) {
                    List<Produto> produtos = response.body();

                    adapter.setProdutos(produtos);
                    adapter.notifyDataSetChanged();

                } else {
                    Log.d(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });


        /*adapter.setProdutos(produtos);
        adapter.notifyDataSetChanged();*/
    }
}
