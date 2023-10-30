package com.example.projeto_ed.controllers;

import com.example.projeto_ed.dto.NovoElementoDTO;
import com.example.projeto_ed.estruturas.fila.Fila;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila")
public class FilaController {
    private Fila fila = new Fila();

    @PostMapping("/adicionar")
    public void adicionar(@RequestBody NovoElementoDTO elemento){
        fila.insere(elemento.getValor());
    }

    @GetMapping("/obter-fila")
    public List<Integer> obterPilha(){
        return fila.list();
    }

    @GetMapping("/obter-primeiro")
    public int obterPrimeiro(){
        return fila.primeiro();
    }

    @DeleteMapping("/remover")
    public void removerTopo(){
        fila.remove();
    }
}
