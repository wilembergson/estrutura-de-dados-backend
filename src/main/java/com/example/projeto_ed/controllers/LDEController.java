package com.example.projeto_ed.controllers;

import com.example.projeto_ed.dto.NovoElementoDTO;
import com.example.projeto_ed.estruturas.lde.LDE;
import com.example.projeto_ed.estruturas.lde.No;
import com.example.projeto_ed.exceptions.ErroPadrao;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lde")
public class LDEController {
    private LDE listaEnc = new LDE();

    private List<No> listar(){
        ArrayList<No> listaAux = new ArrayList<No>();
        for(int i=1; i<=listaEnc.tamanho(); i++){
            listaAux.add(listaEnc.elemento(i));
        }
        return listaAux;
    }
    @PostMapping("/adicionar")
    public void adicionar(@RequestBody NovoElementoDTO elemento){
        listaEnc.insere(elemento.getPosicao(), elemento.getValor());
    }

    @GetMapping("/obterlista")
    public List<No> obterLista(){
        return listar();
    }

    /*@DeleteMapping("/remover/{posicao}")
    public void remover(@PathVariable("posicao") int posicao){
        listaEnc.remove(posicao);
    }

    @GetMapping("/obter-item")
    public int obter(@RequestParam(name = "pos", required = false) Integer pos, @RequestParam(name = "val", required = false) Integer val){
        if(pos == null && val == null) throw new ErroPadrao("Selecione 'Posição' ou 'Valor'.");
        if(val != null){
           List<No> lista = listar();
           for(No no: lista){
               if(no.getConteudo() == val) return val;
           }
           throw new ErroPadrao("Valor não encontrado na lista.");
       }
        return listaEnc.elemento(pos).getConteudo();
    }*/
}
