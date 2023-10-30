package com.example.projeto_ed.estruturas.arvore;

import com.example.projeto_ed.exceptions.ErroPadrao;

import java.util.ArrayList;
import java.util.List;

public class ABP {
	private No raiz;
	
	public ABP(){
		raiz = null;
	}

	public boolean vazia (){
		return (raiz == null);
	}

	private No busca(No T, int valor) {
		if (T == null)
			throw new ErroPadrao("Número não encontrado.");
		if(T.getConteudo() == valor)
			return T;
		if (valor < T.getConteudo())
			return busca(T.getEsq(), valor);
	    else
			return busca(T.getDir(), valor);
	}

	public No busca(int valor) {
			return busca(raiz, valor);
	}
	
	public No buscaIterativa(int valor) {          
		if (vazia())
			return null;
		
		No aux = raiz;
		while (aux != null) {
			// Verificando se o conteudo do no atual 
			// é igual ao valor procurado
			if (aux.getConteudo() == valor) {
				return aux;
			}
			
			// Se o valor procurado for menor que raiz,
			// continue pesquisando na sub-arv da esq.
			if (valor < aux.getConteudo()){
				aux = aux.getEsq();
			}
			// Caso contratio, pesquise na sub-arv 
			// da direita
			else {
				aux = aux.getDir();
			}
		}

		return null;
	}

	private void exibe (No T){
		if (T != null) {
			exibe(T.getEsq());
			System.out.print(" " + T.getConteudo());
			exibe(T.getDir());
		}
	}

	public void exibe() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibe(raiz);
	}

	public No exibeRaiz (){
		return raiz;
	}

	private void exibeDec(No T){
		if (T != null) {
			exibeDec(T.getDir());
			System.out.print(" " + T.getConteudo());
			exibeDec(T.getEsq());
		}
	}
	
	public void exibeDec() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibeDec(raiz);
	}

	public boolean insere(int valor){
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);
		if (raiz == null){ 
	 		raiz = novoNo;
			return true;
		}
		No aux = raiz;
	    No p = null;
	    while (aux != null) {
	    	p = aux;
			if (valor < aux.getConteudo())
				aux = aux.getEsq();
			else
				aux = aux.getDir();
		}
		if (valor < p.getConteudo())
			p.setEsq(novoNo);
		else
			p.setDir(novoNo);
		return true;
	}

	public void deleta(int valor) {
		if (raiz == null) throw new ErroPadrao("Árvore vazia.");
		busca(valor);
		raiz = deletaRecursivo(raiz, valor);
	}

	private No deletaRecursivo(No raiz, int valor) {
		if (raiz == null) {
			return raiz;
		}

		if (valor < raiz.getConteudo()) {
			raiz.setEsq(deletaRecursivo(raiz.getEsq(), valor));
		} else if (valor > raiz.getConteudo()) {
			raiz.setDir(deletaRecursivo(raiz.getDir(), valor));
		} else {
			// Nó com o valor a ser deletado encontrado.
			// Caso 1: Nó com um filho ou nenhum filho
			if (raiz.getEsq() == null) {
				return raiz.getDir();
			} else if (raiz.getDir() == null) {
				return raiz.getEsq();
			}
			// Caso 2: Nó com dois filhos, encontre o sucessor in-order (nó mínimo na subárvore direita).
			raiz.setConteudo(encontraMenorValor(raiz.getDir()));
			raiz.setDir(deletaRecursivo(raiz.getDir(), raiz.getConteudo()));
		}
		return raiz;
	}

	private int encontraMenorValor(No raiz) {
		int menorValor = raiz.getConteudo();
		while (raiz.getEsq() != null) {
			menorValor = raiz.getEsq().getConteudo();
			raiz = raiz.getEsq();
		}
		return menorValor;
	}

	private List<Integer> caminhamento = new ArrayList<>();
	public void preOrdem(No T) {
		if (T != null) {
			caminhamento.add(T.getConteudo());
			preOrdem(T.getEsq()); // Percorre a subárvore esquerda
			preOrdem(T.getDir()); // Percorre a subárvore direita
		}
	}

	public void inOrdem(No T) {
		if (T != null) {
			inOrdem(T.getEsq()); // Percorre a subárvore esquerda
			caminhamento.add(T.getConteudo()); // Visita o nó
			inOrdem(T.getDir()); // Percorre a subárvore direita
		}
	}

	public void posOrdem(No T) {
		if (T != null) {
			posOrdem(T.getEsq()); // Percorre a subárvore esquerda
			posOrdem(T.getDir()); // Percorre a subárvore direita
			caminhamento.add(T.getConteudo()); // Visita o nó
		}
	}

	public String caminhamento(String tipoCaminhamento) {
		if (raiz == null) {
			throw new ErroPadrao("Árvore vazia.");
		} else {
			if(tipoCaminhamento == "preordem"){
				preOrdem(raiz);
			}else if(tipoCaminhamento == "inordem"){
				inOrdem(raiz);
			}else if( tipoCaminhamento == "posordem"){
				posOrdem(raiz);
			}else{
				throw new ErroPadrao("Adicione um tipo de caminhamento válido.");
			}
			String result = caminhamento.toString();
			caminhamento.clear();
			return result;
		}
	}
}
