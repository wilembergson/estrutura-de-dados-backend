package com.example.projeto_ed.estruturas.fila;

import com.example.projeto_ed.exceptions.ErroPadrao;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	private No inicio;
	private No fim;
	private int nElementos;

	public Fila() {
		inicio = null;
		fim = null;
		nElementos = 0;
	}

	public boolean vazia () {
		if (nElementos == 0)
			return true;
		else
			return false;
	}

	public int tamanho () {
		return nElementos;
	}

	public int primeiro () {
		if (vazia())
			throw new ErroPadrao("Fila vazía.");

		return inicio.getConteudo();
	}

	public boolean insere (int valor) {
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setProx(null);
	    if (vazia()){
	        inicio = novoNo;
	    }
	    else {
			fim.setProx(novoNo);
		}
		fim = novoNo;
	    nElementos++;
	    return true;
	}

	public List<Integer> list(){
		ArrayList<Integer> elementos = new ArrayList<Integer>();
		No atual = inicio;
		while (atual != null){
			elementos.add(atual.getConteudo());
			atual = atual.getProx();
		}
		return elementos;
	}

	public int remove() {
		if (vazia()) {
			throw new ErroPadrao("Fila vazía.");
	    }
		No aux = inicio;
		int valor = inicio.getConteudo();
		if (tamanho() == 1){
			fim = null;
		}
		inicio = aux.getProx();
		aux = null;
	    nElementos--;
		return valor;
	}
}
