package com.example.projeto_ed.controllers;

import com.example.projeto_ed.dto.NovoElementoDTO;
import com.example.projeto_ed.lse.LSE;
import com.example.projeto_ed.lse.No;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lista-encadeada")
public class ListaEncadeada {
    private LSE listaEnc = new LSE();

    @GetMapping("/obterlista")
    public List<No> obterLista(){
        return listar();
    }

    @PostMapping("/adicionar")
    public void adicionar(@RequestBody NovoElementoDTO elemento){
        listaEnc.insere(elemento.getPosicao(), elemento.getValor());
    }

    @DeleteMapping("/remover/{posicao}")
    public void remover(@PathVariable("posicao") int posicao){
        listaEnc.remove(posicao);
    }

    @GetMapping("/obter-item/{pos}")
    public int obter(@PathVariable("pos") int pos){
        return listaEnc.elemento(pos).getConteudo();
    }

    private List<No> listar(){
        ArrayList<No> listaAux = new ArrayList<No>();
        for(int i=1; i<=listaEnc.tamanho(); i++){
            listaAux.add(listaEnc.elemento(i));
        }
        return listaAux;
    }
}
