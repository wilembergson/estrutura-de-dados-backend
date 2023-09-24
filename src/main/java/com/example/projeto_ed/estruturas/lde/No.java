package com.example.projeto_ed.estruturas.lde;

public class No {
    private No ant;
    private int conteudo;
    private No prox;

    public No(){
        setAnt(null);
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

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }
}
