package org.victor.tarefasapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tarefas")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Long Id;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 40, message = "O título deve ter no máximo 40 caracteres")
    @Column(name = "titulo_tarefa")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 200, message = "A descrição deve ter no máximo 200 caracteres")
    @Column(name = "descricao_tarefa")
    private String descricao;

    @Column(name = "concluido")
    private boolean concluido = false;
}
