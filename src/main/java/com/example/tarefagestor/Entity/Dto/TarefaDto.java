package com.example.tarefagestor.Entity.Dto;

import com.example.tarefagestor.Entity.Enum.Situacao;
import com.example.tarefagestor.Entity.Tarefa;

import java.time.LocalDate;

public record TarefaDto(String titulo, String descricao, String responsavel, Situacao situacao, int prioridade, LocalDate deadline) {

    public TarefaDto() {
        this(null, null, null, null, 0, null);
    }

    public Tarefa TarefaDto(TarefaDto tarefaDto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaDto.titulo);
        tarefa.setDescricao(tarefaDto.descricao);
        tarefa.setResponsavel(tarefaDto.responsavel);
        tarefa.setSituacao(tarefaDto.situacao);
        tarefa.setPrioridade(tarefaDto.prioridade);
        tarefa.setDeadline(tarefaDto.deadline);
        return  tarefa;
    }
}
