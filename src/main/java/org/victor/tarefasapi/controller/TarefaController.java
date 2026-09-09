package org.victor.tarefasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.victor.tarefasapi.model.TarefaModel;
import org.victor.tarefasapi.service.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscarTarefaPorId(@PathVariable int id) {
        TarefaModel tarefa =  tarefaService.buscarTarefaPorId(id);
        if(tarefa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> adicionarTarefas(@RequestBody TarefaModel tarefa) {
        tarefaService.adicionarTarefa(tarefa);
        return ResponseEntity.status(201).body(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefasPorId(@PathVariable int id) {
        boolean tarefaDeletada = tarefaService.deletarTarefaPorId(id);
        if(tarefaDeletada) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarTarefaPorId(@PathVariable int id, @RequestBody TarefaModel tarefa) {
          boolean tarefaAtualizada = tarefaService.atualizarTarefaPorId(id, tarefa.getTitulo(), tarefa.getDescricao());
          if(tarefaAtualizada) return ResponseEntity.ok().build();
          return ResponseEntity.notFound().build();
    }

}
