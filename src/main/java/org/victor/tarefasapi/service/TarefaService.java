package org.victor.tarefasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victor.tarefasapi.model.TarefaModel;
import org.victor.tarefasapi.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.listarTarefas();
    }

    public TarefaModel buscarTarefaPorId(int id) {
        return tarefaRepository.buscarTarefaPorId(id);
    }

    public void adicionarTarefa(TarefaModel tarefa) {
        tarefaRepository.salvarTarefa(tarefa);
    }

    public boolean atualizarTarefaPorId(int id, String titulo, String descricao) {
        return tarefaRepository.atualizarTarefaPorId(titulo,descricao,id);
    }

    public boolean deletarTarefaPorId(int id) {
        if(tarefaRepository.deletarTarefaPorId(id)) return true;
        return false;
    }
}