package com.example.projeto_ed.controllers;

import com.example.projeto_ed.dto.NovoElementoDTO;
import com.example.projeto_ed.dto.TamanhoMaxDTO;
import com.example.projeto_ed.exceptions.ErroPadrao;
import com.example.projeto_ed.estruturas.sequencial.Sequencial;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lista-sequencial")
public class SequencialController {
    private Sequencial listaEnc;

    private void listaInicializadaCheck(){
        if(listaEnc == null) throw new ErroPadrao("Lista não iniciada.");;
    }
    @PostMapping("/tamanho-max")
    public void setMaxTamanho(@RequestBody TamanhoMaxDTO tamanho){
        listaEnc = new Sequencial(tamanho.getTamanho());
    }

    @GetMapping("/tamanho-max")
    public Integer getMaxTamanho(){
        listaInicializadaCheck();
        return listaEnc.getTamanhoMax();
    }
    @GetMapping("/obterlista")
    public List<Integer> obterLista(){
        listaInicializadaCheck();
        return listar();
    }

    @PostMapping("/adicionar")
    public void adicionar(@RequestBody NovoElementoDTO elemento){
        listaInicializadaCheck();
        listaEnc.insere(elemento.getPosicao(), elemento.getValor());
    }

    @DeleteMapping("/remover/{posicao}")
    public void remover(@PathVariable("posicao") int posicao){
        listaEnc.remove(posicao);
    }

    @GetMapping("/obter-item")
    public int obter(@RequestParam(name = "pos", required = false) Integer pos, @RequestParam(name = "val", required = false) Integer val){
        listaInicializadaCheck();
        if(pos == null && val == null) throw new ErroPadrao("Selecione 'Posição' ou 'Valor'.");
        if(val != null){
           List<Integer> lista = listar();
           for(Integer item: lista){
               if(item == val) return val;
           }
           throw new ErroPadrao("Valor não encontrado na lista.");
       }
        return listaEnc.elemento(pos);
    }

    private List<Integer> listar(){
        if(listaEnc.getTamanhoMax() == 0) throw  new ErroPadrao("lista não definida!");
        ArrayList<Integer> listaAux = new ArrayList<Integer>();
        for(int i=1; i<=listaEnc.tamanho(); i++){
            listaAux.add(listaEnc.elemento(i));
        }
        return listaAux;
    }
}
