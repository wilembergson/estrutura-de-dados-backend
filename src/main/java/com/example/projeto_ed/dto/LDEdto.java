package com.example.projeto_ed.dto;

public class LDEdto {
    private boolean ant;
    private Integer valor;
    private boolean prox;

    public LDEdto(){
        this.ant = true;
        this.prox = true;
    }

    public  boolean getAnt(){
        return ant;
    }

    public void setAnt(boolean ant) {
        this.ant = ant;
    }

    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor){
        this.valor = valor;
    }

    public boolean getProx(){
        return prox;
    }
    public void setProx(boolean prox) {
        this.prox = prox;
    }
}
