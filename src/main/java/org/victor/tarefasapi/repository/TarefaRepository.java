package org.victor.tarefasapi.repository;

import org.victor.tarefasapi.model.TarefaModel;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    List<TarefaModel> tarefas = new ArrayList<>();

    public void salvarTarefa(TarefaModel tarefa){
        tarefas.add(tarefa);
        System.out.print("Tarefa Adicionada");
    }

    public List<TarefaModel> listarTarefas(){
        return tarefas;
    }

    public TarefaModel buscarTarefaPorId(int id){
        for (TarefaModel tarefa : tarefas){
            if (tarefa.getID() == id){
                System.out.println("tarefa com id: " + id + " encontrada");
                break;
            }
        }
        return null;
    }
}
