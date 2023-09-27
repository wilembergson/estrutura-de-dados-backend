package com.example.projeto_ed.controllers;

import com.example.projeto_ed.dto.LDEdto;
import com.example.projeto_ed.dto.NovoElementoDTO;
import com.example.projeto_ed.estruturas.lde.LDE;
import com.example.projeto_ed.exceptions.ErroPadrao;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lde")
public class LDEController {
    private LDE lista = new LDE();

    private List<LDEdto> listar(){
        ArrayList<LDEdto> listaAux = new ArrayList<LDEdto>();
        for(int i = 1; i<= lista.tamanho(); i++){
            LDEdto dado = new LDEdto();
            if(lista.elemento(i).getAnt() == null) dado.setAnt(false);
            if(lista.elemento(i).getProx() == null) dado.setProx(false);
            dado.setConteudo(lista.elemento(i).getConteudo());
            listaAux.add(dado);
        }
        return listaAux;
    }

    @PostMapping("/adicionar")
    public void adicionar(@RequestBody NovoElementoDTO elemento){
        lista.insere(elemento.getPosicao(), elemento.getValor());
    }

    @GetMapping("/obterlista")
    public List<LDEdto> obterLista(){
        return listar();
    }

    @DeleteMapping("/remover/{posicao}")
    public void remover(@PathVariable("posicao") int posicao){
        lista.remove(posicao);
    }

    @GetMapping("/obter-item")
    public int obter(@RequestParam(name = "pos", required = false) Integer pos, @RequestParam(name = "val", required = false) Integer val){
        if(pos == null && val == null) throw new ErroPadrao("Selecione 'Posição' ou 'Valor'.");
        if(pos != null) return lista.elemento(pos).getConteudo();
        for(LDEdto no: listar()){
            if(no.getConteudo().equals(val)) return val;
        }
        throw new ErroPadrao("Valor não encontrado na lista.");
    }
}
