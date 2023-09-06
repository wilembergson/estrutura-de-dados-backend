package com.example.projeto_ed.lse;

import com.example.projeto_ed.exceptions.ErroPadrao;

public class LSE {
	private No cabeca;
	private int nElementos;

	public LSE(){
		cabeca = null;
		nElementos = 0;
	}
	
	/** Verifica se a Lista está vazia */
	public boolean vazia() {
	    if (nElementos == 0)
	        return true;
	    else
	        return false;
	}

	/**Obtém o tamanho da Lista*/
	public int tamanho() {
	    //return nElementos;
		
	    No aux = cabeca;
		int cont = 0;
		while(aux != null){
			aux = aux.getProx();
			cont++;
		}
		return cont;
	}

	/** Obtém o i-ésimo elemento de uma lista
	    Retorna o valor encontrado. */
	public No elemento (int pos) {
	    if (vazia()) {
			throw new ErroPadrao("Posição inválida."); // Consulta falhou
	    }

	    if ((pos < 1) || (pos > tamanho())){
			throw new ErroPadrao("Posição inválida."); // Posicao invalida
	    }
	    
	    No aux = cabeca;
	    // Percorre a lista do 1o elemento até pos 
	    for (int i =1; i < pos; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }
	    return aux;
	}

	/**Retorna a posição de um elemento pesquisado.
	    Retorna -1 caso não seja encontrado */
	public int posicao (int dado) {
	    /* Lista vazia */
	    if (vazia()) {
	        throw new ErroPadrao("A lista está vazia!");
	    }

	    /* Percorre a lista do inicio ao fim até encontrar o elemento*/
	    No aux = cabeca;
	    int cont = 1;
	    while (aux != null) {
	        // Se encontrar o elemento, retorna sua posicao n;
	        if (aux.getConteudo() == dado){
	            return cont;
	        }

	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	        cont++;
	    }

	    return -1;
	}

	/** Insere nó em lista vazia */
	private boolean insereInicioLista(int valor) {
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    
	    // Insere novo elemento na cabeca da lista
	    novoNo.setConteudo(valor);
	    
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    nElementos++;
		return true;
	}

	/** Insere nó no meio da lista */
	private boolean insereMeioLista(int pos, int valor){
	    
	    // Aloca memoria para novo no
	    No novoNo = new No();
	    novoNo.setConteudo(valor);

	    // Localiza a pos. ANTERIOR onde será inserido o novo nó
	    No aux = cabeca;
	    for (int i =1; i < pos-1; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }
	    
	    // Insere novo elemento apos aux
	    novoNo.setProx(aux.getProx());
	    aux.setProx(novoNo);
	   
	    nElementos++;
		return true;
	}


	/**Insere um elemento em uma determinada posição
	    Retorna true se conseguir inserir e 
	    false caso contrario */
	public boolean insere(int pos, int valor) {
		if ((vazia()) && (pos != 1)){
	        throw new ErroPadrao("Posição inválida."); /* lista vazia mas posicao inv*/
	    }
		
		if ((pos <= 0) || pos > (nElementos+1)) {
			throw new ErroPadrao("Posição inválida."); // posicao invalida
		}
		
	 	/* inserção no início da lista (ou lista vazia)*/
	    if (pos == 1){
	        return insereInicioLista(valor);
	    }
	    else{
	        return insereMeioLista(pos, valor);
	   }
	}

	/** Remove elemento do início da lista */
	private int removeInicioLista(){
	    No p = cabeca;

	    // Dado recebe o dado removido
	    int valorRemovido = p.getConteudo();

	    // Retira o 1o elemento da lista (p)
	    cabeca = p.getProx();
	    nElementos--;

	    // Sugere ao garbage collector que libere a memoria
	    //  da regiao apontada por p
	    p = null;

	    return valorRemovido;
	}

	/** Remove elemento no meio da lista */
	private int removeNaLista(int pos){
		// Localiza os nó a ser removido (atual) e o seu 
		// antecessor (antecessor) 
		No antecessor = cabeca;
		for(int i = 1; i < pos-1; i++) {
			antecessor = antecessor.getProx();
		}
		No atual = antecessor.getProx();
		
		// Guarda o valor a ser removido
		int valorRemovido = atual.getConteudo();
		
		// Faz o campo prox de antecessor apontar pro 
		// prox de atual
		//No aux = atual.getProx();
		//antecessor.setProx(aux);
		antecessor.setProx(atual.getProx());
		
		// Decrementa o numero de elementos
		nElementos--;
		
		// Sugere ao GC que libere a memoria do no atual
		atual = null;
		
		return valorRemovido;
	}

	/**Remove um elemento de uma determinada posição
	    Retorna o valor a ser removido. 
	    -1 se a posição for inválida ou a lista estiver vazia*/
	public int remove(int pos) {
		if (vazia()) {
			throw new ErroPadrao("A lista está vazia."); // Lista vazia
		}

	    if ((pos <= 0) || (pos > nElementos)) {
			throw new ErroPadrao("Posição inválida."); // Posicao invalida
	    }
	    
	    // Remoção do elemento da cabeça da lista 
	    if (pos == 1){
	        return removeInicioLista();
	    }
	    // Remoção em outro lugar da lista
	    else{
	        return removeNaLista(pos);
	    }
	}
}