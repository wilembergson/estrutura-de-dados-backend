package com.example.projeto_ed.estruturas.lse;

public class No {
    private int conteudo;
    private No prox;

    public No(){
        setConteudo(0);
        setProx(null);
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}