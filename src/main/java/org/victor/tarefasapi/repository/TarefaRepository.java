package org.victor.tarefasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.victor.tarefasapi.model.TarefaModel;

import java.util.*;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {

}
