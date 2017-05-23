package com.juliao.recylerview_retrofit.beans;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by schin on 23/05/2017.
 */

public final class Produto extends BaseObservable {

    @Bindable
    private int codigo;

    @Bindable
    private String descricao;

    @Bindable
    private double valor;

    public Produto() {
    }

    public Produto(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
