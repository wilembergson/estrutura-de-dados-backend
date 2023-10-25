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


    @PostMapping("/adicionar-teste")
    public void adicionarTeste(@RequestBody NovoElementoDTO elemento){
        arvore.insere(10);
        arvore.insere(6);
        arvore.insere(22);
        arvore.insere(15);
        arvore.insere(2);
        arvore.insere(8);
        arvore.insere(3);
        arvore.insere(35);
        arvore.insere(16);
        arvore.insere(14);
        arvore.insere(9);
        arvore.insere(36);
        arvore.insere(34);
        arvore.insere(1);
        arvore.insere(7);
    }
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
}
