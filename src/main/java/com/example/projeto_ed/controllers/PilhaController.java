package com.example.projeto_ed.controllers;

import com.example.projeto_ed.dto.NovoElementoDTO;
import com.example.projeto_ed.estruturas.pilha.Pilha;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilha")
public class PilhaController {
    private Pilha pilha = new Pilha();

    @PostMapping("/adicionar")
    public void adicionar(@RequestBody NovoElementoDTO elemento){
        pilha.push(elemento.getValor());
    }

    @GetMapping("/obter-pilha")
    public List<Integer> obterPilha(){
        return pilha.list();
    }

    @GetMapping("/obter-topo")
    public int obterTopo(){
        return pilha.top();
    }

    @DeleteMapping("/remover-topo")
    public void removerTopo(){
        pilha.pop();
    }
}
