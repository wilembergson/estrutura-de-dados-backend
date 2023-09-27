package com.example.projeto_ed.dto;

public class LDEdto {
    private boolean ant;
    private Integer conteudo;
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

    public Integer getConteudo() {
        return conteudo;
    }
    public void setConteudo(Integer conteudo){
        this.conteudo = conteudo;
    }

    public boolean getProx(){
        return prox;
    }
    public void setProx(boolean prox) {
        this.prox = prox;
    }
}
