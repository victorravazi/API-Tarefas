package org.victor.tarefasapi.repository;

import org.victor.tarefasapi.model.TarefaModel;

import java.util.ArrayList;
import java.util.List;

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

    public void atualizarTarefa(String titulo,String descricao, int id){
        for (TarefaModel tarefa : tarefas){
            if (tarefa.getID() == id){
                tarefa.setTitulo(titulo);
                tarefa.setDescricao(descricao);
            }
        }

    }

    public void deletarTarefa(int id){
        for (TarefaModel tarefa : tarefas) {
            if (tarefa.getID() == id){

            }
        }
    }
}
