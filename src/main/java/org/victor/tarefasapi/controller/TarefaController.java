package org.victor.tarefasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.victor.tarefasapi.model.TarefaModel;
import org.victor.tarefasapi.repository.TarefaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTarefas() {
        return ResponseEntity.ok(tarefaRepository.listarTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscarTarefaPorId(@PathVariable int id) {
        TarefaModel tarefa =  tarefaRepository.buscarTarefaPorId(id);
        if(tarefa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> adicionarTarefas(@RequestBody TarefaModel tarefa) {
        tarefaRepository.salvarTarefa(tarefa);
        return ResponseEntity.status(201).body(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefasPorId(@PathVariable int id) {
        boolean tarefa = tarefaRepository.deletarTarefaPorId(id);
        if(tarefa) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarTarefaPorId(@PathVariable int id, @RequestBody TarefaModel tarefa) {
          boolean tarefaAtualizada = tarefaRepository.atualizarTarefaPorId(tarefa.getTitulo(), tarefa.getDescricao(), id);
          if(tarefaAtualizada) return ResponseEntity.ok().build();
          return ResponseEntity.notFound().build();
    }

}
