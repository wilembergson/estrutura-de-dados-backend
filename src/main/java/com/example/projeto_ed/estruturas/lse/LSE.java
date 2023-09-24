package com.example.projeto_ed.estruturas.lse;

import com.example.projeto_ed.exceptions.ErroPadrao;

public class LSE {
	private No cabeca;
	private int nElementos;

	public LSE(){
		cabeca = null;
		nElementos = 0;
	}

	public boolean vazia() {
	    if (nElementos == 0)
	        return true;
	    else
	        return false;
	}

	public int tamanho() {
	    No aux = cabeca;
		int cont = 0;
		while(aux != null){
			aux = aux.getProx();
			cont++;
		}
		return cont;
	}

	public No elemento (int pos) {
	    if (vazia()) {
			throw new ErroPadrao("Posição inválida.");
	    }
	    if ((pos < 1) || (pos > tamanho())){
			throw new ErroPadrao("Posição inválida.");
	    }
	    No aux = cabeca;
	    for (int i =1; i < pos; i++){
	        aux = aux.getProx();
	    }
	    return aux;
	}

	public int posicao (int dado) {
	    if (vazia()) {
	        throw new ErroPadrao("A lista está vazia!");
	    }

	    No aux = cabeca;
	    int cont = 1;
	    while (aux != null) {
	        if (aux.getConteudo() == dado){
	            return cont;
	        }
	        aux = aux.getProx();
	        cont++;
	    }
	    return -1;
	}

	private boolean insereInicioLista(int valor) {
	    No novoNo = new No();
	    novoNo.setConteudo(valor);
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    nElementos++;
		return true;
	}

	private boolean insereMeioLista(int pos, int valor){
	    No novoNo = new No();
	    novoNo.setConteudo(valor);

	    No aux = cabeca;
	    for (int i =1; i < pos-1; i++){
	        aux = aux.getProx();
	    }
	    novoNo.setProx(aux.getProx());
	    aux.setProx(novoNo);
	    nElementos++;
		return true;
	}

	public boolean insere(int pos, int valor) {
		if ((vazia()) && (pos != 1)){
	        throw new ErroPadrao("Posição inválida.");
	    }

		if ((pos <= 0) || pos > (nElementos+1)) {
			throw new ErroPadrao("Posição inválida.");
		}

	    if (pos == 1){
	        return insereInicioLista(valor);
	    }
	    else{
	        return insereMeioLista(pos, valor);
	   }
	}

	private int removeInicioLista(){
	    No p = cabeca;
	    int valorRemovido = p.getConteudo();
	    cabeca = p.getProx();
	    nElementos--;
	    p = null;
	    return valorRemovido;
	}

	private int removeNaLista(int pos){
		No antecessor = cabeca;
		for(int i = 1; i < pos-1; i++) {
			antecessor = antecessor.getProx();
		}
		No atual = antecessor.getProx();
		int valorRemovido = atual.getConteudo();
		antecessor.setProx(atual.getProx());
		nElementos--;
		atual = null;
		return valorRemovido;
	}

	public int remove(int pos) {
		if (vazia()) {
			throw new ErroPadrao("A lista está vazia.");
		}

	    if ((pos <= 0) || (pos > nElementos)) {
			throw new ErroPadrao("Posição inválida.");
	    }

	    if (pos == 1){
	        return removeInicioLista();
	    }
	    else{
	        return removeNaLista(pos);
	    }
	}
}