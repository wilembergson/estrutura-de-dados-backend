package com.example.projeto_ed.controllers;

import com.example.projeto_ed.dto.NovoElementoDTO;
import com.example.projeto_ed.estruturas.arvore.ABP;
import com.example.projeto_ed.estruturas.arvore.No;
import com.example.projeto_ed.estruturas.fila.Fila;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arvore")
public class ArvoreController {
    private ABP arvore = new ABP();

    @PostMapping("/adicionar")
    public void adicionar(@RequestBody NovoElementoDTO elemento){
        arvore.insere(elemento.getValor());
    }
    @GetMapping("/listar")
    public No obterArvore(){
        return arvore.exibeRaiz();
    }

    @GetMapping("/obter/{valor}")
    public Integer obterItem(@PathVariable("valor") String valor){
        return arvore.busca(Integer.parseInt(valor)).getConteudo();
    }

    @DeleteMapping("/delete/{valor}")
    public void deletarItem(@PathVariable("valor") String valor){
        arvore.deleta(Integer.parseInt(valor));
    }

    @GetMapping("/preordem")
    public String preOrdem(){
        return arvore.caminhamento("preordem");
    }

    @GetMapping("/inordem")
    public String inOrdem(){
        return arvore.caminhamento("inordem");
    }

    @GetMapping("/posordem")
    public String posOrdem(){
        return arvore.caminhamento("posordem");
    }
}
