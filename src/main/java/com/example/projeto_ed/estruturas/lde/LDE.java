package com.example.projeto_ed.estruturas.lde;

import com.example.projeto_ed.exceptions.ErroPadrao;

public class LDE {
    private No inicio;
    private No fim;
    private int tamanho;

    public LDE(){
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public boolean vazia() {
        if (tamanho == 0)
            return true;
        else
            return false;
    }

    public int tamanho() {
        return tamanho;
    }

    public No elemento (int pos) {
        No aux = inicio;
        int cont = 1;

        if (vazia()) {
            throw new ErroPadrao("Lista vazia.");
        }

        if ((pos < 1) || (pos > tamanho())){
            throw new ErroPadrao("Posição inválida.");
        }

        while (cont < pos){
            aux = aux.getProx();
            cont++;
        }
        return aux;
    }

    private boolean insereInicioLista(int valor) {
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setProx(inicio);
        novoNo.setAnt(null);
        if (vazia())
            fim = novoNo;
        else
            inicio.setAnt(novoNo);
        inicio = novoNo;
        tamanho++;
        return true;
    }

    private boolean insereMeioLista(int pos, int dado){
        int cont = 1;
        No novoNo = new No();
        novoNo.setConteudo(dado);
        No aux = inicio;
        while ((cont < pos-1) && (aux != null)){
            aux = aux.getProx();
            cont++;
        }
        if (aux == null) return false;
        novoNo.setAnt(aux);
        novoNo.setProx(aux.getProx());
        aux.getProx().setAnt(novoNo);
        aux.setProx(novoNo);
        tamanho++;
        return true;
    }

    private boolean insereFimLista(int dado){
        No novoNo = new No();
        novoNo.setConteudo(dado);
        No aux = inicio;
        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        novoNo.setProx(null);
        aux.setProx(novoNo);
        novoNo.setAnt(fim);
        fim.setProx(novoNo);
        fim = novoNo;
        this.tamanho++;
        return true;
    }

    public boolean insere(int pos, int dado) {
        if ((vazia()) && (pos != 1)){
            throw new ErroPadrao("Lista vazia mas posição inválida.");
        }
        if ((!vazia()) && (pos > tamanho + 1) || (pos < 1)){
            throw new ErroPadrao("Posição inválida.");
        }
        if (pos == 1){
            return insereInicioLista(dado);
        }
        else if (pos == tamanho+1){
            return insereFimLista(dado);
        }
        else{
            return insereMeioLista(pos, dado);
        }
    }

    private int removeInicioListaUnitaria(){
        int dado = inicio.getConteudo();
        inicio = null;
        fim = null;
        tamanho--;
        return dado;
    }

    private int removeInicioLista(){
        No p = inicio;
        int dado = p.getConteudo();
        inicio = p.getProx();
        p.getProx().setAnt(null);
        tamanho--;
        p = null;
        return dado;
    }

    private int removeMeioLista(int pos){
        No p = inicio;
        int n = 1;
        while((n <= pos-1) && (p != null)){
            p = p.getProx();
            n++;
        }
        if (p == null) {
            return -1;
        }
        int dado = p.getConteudo();
        p.getAnt().setProx(p.getProx());
        p.getProx().setAnt(p.getAnt());
        tamanho--;
        p = null;
        return dado;
    }

    private int removeFimLista(){
        No p = fim;
        int dado = p.getConteudo();

        fim.getAnt().setProx(null);
        fim = fim.getAnt();
        tamanho--;

        p = null;
        return dado;
    }

    public int remove(int pos) {
        if (vazia()) {
            throw new ErroPadrao("Lista vazia.");
        }
        if ((pos > tamanho) || (pos < 1)){
            throw new ErroPadrao("Posição inválida.");
        }
        if ((pos == 1) && (tamanho() == 1)){
            return removeInicioListaUnitaria();
        }
        else if (pos == 1){
            return removeInicioLista();
        }
        else if (pos == tamanho()){
            return removeFimLista();
        }
        else{
            return removeMeioLista(pos);
        }
    }
}
