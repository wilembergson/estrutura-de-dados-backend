package com.example.projeto_ed.estruturas.pilha;
import com.example.projeto_ed.exceptions.ErroPadrao;
import java.util.ArrayList;
import java.util.List;

public class Pilha {
    private No topo;
    private int nElementos;

    public Pilha(){
        topo = null;
        nElementos = 0;
    }

    public boolean vazia () {
        if (nElementos == 0)
            return true;
        else
            return false;
    }

    public List<Integer> list(){
        ArrayList<Integer> elementos = new ArrayList<Integer>();
        No atual = topo;
        while (atual != null){
            elementos.add(atual.getConteudo());
            atual = atual.getProx();
        }
        return elementos;
    }

    public int tamanho() {
        return nElementos;
    }

    public int top (){
        if (vazia()) throw new ErroPadrao("Pilha vazía!");
        return topo.getConteudo();
    }

    public boolean push(int valor) {
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setProx(topo);
        topo = novoNo;
        nElementos++;
        return true;
    }

    public int pop () {
        //if (vazia()) throw new ErroPadrao("Pilha vazía!");
        No p = topo;
        int valor = p.getConteudo();
        topo = topo.getProx();
        nElementos--;
        p= null;
        return valor;
    }
}
