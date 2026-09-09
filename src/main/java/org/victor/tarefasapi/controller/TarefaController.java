package org.victor.tarefasapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.victor.tarefasapi.model.TarefaModel;
import org.victor.tarefasapi.service.TarefaService;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<TarefaModel> buscarTarefaPorId(@PathVariable Long id) {
        Optional<TarefaModel> tarefa =  tarefaService.buscarTarefaPorId(id);
        return tarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // ←- IDE fez isso, vou aceitar
    }

    @PostMapping
    public ResponseEntity<TarefaModel> adicionarTarefas(@Valid @RequestBody TarefaModel tarefa) {
        TarefaModel tarefaSalva = tarefaService.adicionarTarefa(tarefa);
        return ResponseEntity.status(201).body(tarefaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefasPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefaPorId(@Valid @PathVariable Long id, @RequestBody TarefaModel tarefa) {
        TarefaModel tarefaAtualizada = tarefaService.atualizarTarefaPorId(id,tarefa.getTitulo(),tarefa.getDescricao());
        if (tarefaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarefaAtualizada);
    }

}
