package com.juliao.recylerview_retrofit.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juliao.recylerview_retrofit.R;
import com.juliao.recylerview_retrofit.beans.Produto;
import com.juliao.recylerview_retrofit.databinding.ItemListaBinding;

import java.util.List;

/**
 * Created by schin on 23/05/2017.
 */

public class ListaProdutoAdapter extends RecyclerView.Adapter<ListaProdutoAdapter.ViewHolder> {

    private List<Produto> produtos;

    public ListaProdutoAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setProduto(produtos.get(position));
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemListaBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ItemListaBinding getBinding() {
            return binding;
        }
    }
}
