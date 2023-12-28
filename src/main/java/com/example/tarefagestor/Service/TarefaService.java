package com.example.tarefagestor.Service;

import com.example.tarefagestor.Entity.Dto.TarefaDto;
import com.example.tarefagestor.Entity.Enum.Situacao;
import com.example.tarefagestor.Entity.Tarefa;
import com.example.tarefagestor.Repository.TarefaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    TarefaRepository tarefaRepository;

    public void create(Tarefa tarefa){
        save(tarefa);
    }
    public void save(Tarefa tarefa){
        if (tarefa.getSituacao() == null) {
            tarefa.setSituacao(Situacao.EMANDAMENTO);
        }
        tarefaRepository.save(tarefa);
    }

    public void concluir(Long id){
       Tarefa tarefa = tarefaRepository.findById(id).orElse( null);
       if (tarefa != null)
       tarefa.setSituacao(Situacao.CONCLUIDA);

       tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listTarefa(){
      return tarefaRepository.findAll();
    }


    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }
    public List<Tarefa> listTarefaAndamento() {
        return tarefaRepository.findAllBySituacaoEquals(Situacao.EMANDAMENTO);
    }

    public List<Tarefa> find(String numero, String titulo, String descricao, String responsavel, String situacao) {

      Long id = numero == "" ? 0L : Long.parseLong(numero);

        Situacao sit = null;
      if(situacao != null){
           sit = Situacao.EMANDAMENTO.name().equals(situacao) ? Situacao.EMANDAMENTO : Situacao.CONCLUIDA;

      }

      return tarefaRepository.findByIdOrTituloAndDescricaoOrResponsavelOrSituacao(id,titulo,descricao,responsavel,sit);
    }
}

