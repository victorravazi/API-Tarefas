package org.victor.tarefasapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@Getter
@Setter

public class TarefaModel {

    private Long ID;

    @NotBlank
    @Size(max = 40)
    private String titulo;

    @NotBlank
    @Size(max = 200)
    private String descricao;
    private boolean concluido = false;
}
