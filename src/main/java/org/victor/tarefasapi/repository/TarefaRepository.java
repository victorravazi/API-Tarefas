package org.victor.tarefasapi.repository;

import org.springframework.stereotype.Repository;
import org.victor.tarefasapi.model.TarefaModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class TarefaRepository {
    List<TarefaModel> tarefas = new ArrayList<>();

    public void salvarTarefa(TarefaModel tarefa){
        tarefas.add(tarefa);
    }

    public List<TarefaModel> listarTarefas(){
        return tarefas;
    }

    public TarefaModel buscarTarefaPorId(int id) {
        for (TarefaModel tarefa : tarefas) {
            if (tarefa.getID() == id) {
                return tarefa;
            }
        }
        return null;
    }

    public boolean atualizarTarefaPorId(String titulo,String descricao, int id){
        for (TarefaModel tarefa : tarefas){
            if (tarefa.getID() == id){
                tarefa.setTitulo(titulo);
                tarefa.setDescricao(descricao);
                return true;
            }
        }
        return false;
    }

    public boolean deletarTarefaPorId(int id){
        Iterator<TarefaModel> iterator = tarefas.iterator();
        while(iterator.hasNext()) {
            TarefaModel tarefa = iterator.next();
            if (tarefa.getID() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
