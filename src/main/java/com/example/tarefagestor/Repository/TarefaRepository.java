package com.example.tarefagestor.Repository;

import com.example.tarefagestor.Entity.Enum.Situacao;
import com.example.tarefagestor.Entity.Tarefa;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {


     List <Tarefa> findAllBySituacaoEquals(Situacao emandamento);
     List<Tarefa> findByIdOrTituloAndDescricaoOrResponsavelOrSituacao( long id, String titulo, String descricao, String Responsavel, Situacao situacao );

}
