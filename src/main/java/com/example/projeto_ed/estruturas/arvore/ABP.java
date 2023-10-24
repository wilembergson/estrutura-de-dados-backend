package com.example.projeto_ed.estruturas.arvore;

import com.example.projeto_ed.exceptions.ErroPadrao;

public class ABP {
	private No raiz;
	
	public ABP(){
		raiz = null;
	}
	
	/** Verifica se a árvore está vazia */
	public boolean vazia (){
		return (raiz == null);
	}

	/**Buscar recursivamente a partir da raiz.
	    Retorna o endereço se o elemento for
	    encontrado, caso contrário retorna NULL*/
	private No busca(No T, int valor) {
		if (T == null)
			throw new ErroPadrao("Número não encontrado.");

		if(T.getConteudo() == valor)
			return T; 	// Elem. encontrado na raiz
		
		if (valor < T.getConteudo())
			return busca(T.getEsq(), valor);
	    else
			return busca(T.getDir(), valor);
	}
	
	/**Buscar um elemento na ABP
    		Retorna o endereço se o elemento for
    		encontrado, caso contrário retorna NULL*/
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
	
	
	/**Exibe o conteúdo de uma árvore no formato in-ordem
	    (preserva a ordenação)*/
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

	/**Exibe o conteúdo de uma árvore no formato in-ordem
    (preserva a ordenação)*/
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
	
	/**Insere um nó em uma árvore ABP
	    Retorna 1 se a inserção for com sucesso.
	    Caso contrário retorna 0*/
	public boolean insere(int valor){

		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);

		// Quando a arvore estiver vazia, o novoNó será a raiz da arv
		if (raiz == null){ 
	 		raiz = novoNo;
			return true;
		}

	    // Procura a posicao correta pra inserir o novo no
	    No aux = raiz;
	    No p = null;
	    while (aux != null) {
	    	p = aux;
			if (valor < aux.getConteudo())
				aux = aux.getEsq();
			else
				aux = aux.getDir();
		}

		// Encontrou um nó folha para inserir
		if (valor < p.getConteudo())
			p.setEsq(novoNo);
		else
			p.setDir(novoNo);
		return true;
	}
}
