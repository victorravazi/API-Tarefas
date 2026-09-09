package org.victor.tarefasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victor.tarefasapi.model.TarefaModel;
import org.victor.tarefasapi.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<TarefaModel> buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public TarefaModel adicionarTarefa(TarefaModel tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public TarefaModel atualizarTarefaPorId(Long id, String titulo, String descricao) {
        Optional<TarefaModel> tarefaOptional = tarefaRepository.findById(id);

        if (tarefaOptional.isEmpty()) {
            return null;
        }

        TarefaModel tarefa = tarefaOptional.get();

        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);

        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);

    }

}