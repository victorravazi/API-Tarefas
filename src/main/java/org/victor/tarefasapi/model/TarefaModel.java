package org.victor.tarefasapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class TarefaModel {

    private int ID;
    private String titulo;
    private String descricao;
    private boolean concluido;
}
