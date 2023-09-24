package com.example.projeto_ed.estruturas.sequencial;

import com.example.projeto_ed.exceptions.ErroPadrao;

public class Sequencial {
	private int dados[]; // Vetor que contém os dados da lista
	private int nElementos;

    public Sequencial(){
    		nElementos = 0;
    		dados = new int[10];
    }

    public Sequencial(int tamMax){
    		nElementos = 0;
			dados = new int[tamMax];
    }

    public boolean vazia(){
		if (nElementos == 0 )
			return true;
		else
			return false;
	}
	public int getTamanhoMax(){
		return dados.length;
	}

    public boolean cheia(){
		if (nElementos == dados.length)
			return true;
		else
			return false;
	}

    public int tamanho(){
		return nElementos;
	}

    public int elemento(int pos){
        if ((pos > nElementos) || (pos <= 0))
			throw new ErroPadrao("Posição inválida.");
       return dados[pos-1];
	}

	public int posicao (int valor){
	    for (int i = 0; i < nElementos; i++){
	        if (dados[i] == valor){
	            return (i + 1);
	        }
	    }
		throw new ErroPadrao("Posição inválida.");
	}

	public int posicao (int valor, int desloc){
		for (int i = desloc; i < nElementos; i++){
		    if (dados[i] == valor){
		        return (i + 1);
		    }
		}
		throw new ErroPadrao("Posição inválida.");
	}

	public boolean insere (int pos, int valor){
		if ((pos > nElementos+1) || (pos <=0)) throw new ErroPadrao("Posição inválida.");
		if(cheia())throw new ErroPadrao("Lista cheia.");
	    for (int i = nElementos; i >= pos; i--){
	 		 dados[i] = dados[i-1];
	    }
	    dados[pos - 1] = valor;
		nElementos++;
	    return true;
	}

	public int remove(int pos){
	    if ((pos > nElementos) || (pos < 1 ))
			   throw new ErroPadrao("Posição inválida.");
	    int aux = dados[pos-1];
	    for (int i = pos - 1; i < nElementos - 1; i++){
	 		  dados[i] = dados[i+1];
		 }
	    nElementos--;
	    return aux;
	}
}
