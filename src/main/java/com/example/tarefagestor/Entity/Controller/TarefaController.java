package com.example.tarefagestor.Entity.Controller;

import com.example.tarefagestor.Entity.Tarefa;
import com.example.tarefagestor.Service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
     public String cadastrar(Model m){

         Tarefa tarefa = new Tarefa();
         m.addAttribute("tarefa", tarefa);
         return "cadastrar";
     }
     @PostMapping("/create")
     public String create(@ModelAttribute Tarefa tarefa){

        tarefaService.create(tarefa);
        return "cadastrar";
     }

     @GetMapping("/listAll")
     public ModelAndView listarTarefas(){

        ModelAndView modelAndView = new ModelAndView("listar");
        modelAndView.addObject("atividades",tarefaService.listTarefaAndamento());
        return modelAndView;
     }

     @PostMapping("/listAll")
     public ModelAndView listarTarefas(String numero, String tituloAndDescricao, String responsavel, String situacao){

        List<Tarefa> findList = tarefaService.find(numero, tituloAndDescricao, tituloAndDescricao,  responsavel,  situacao);
        ModelAndView modelAndView = new ModelAndView("listar");
        modelAndView.addObject("atividades",findList);
        return modelAndView;
     }

     @GetMapping("/concluir/{id}")
     public ModelAndView concluir (@PathVariable(name = "id")Long id){
         tarefaService.concluir(id);
         return listarTarefas();
     }

     @GetMapping("/excluir/{id}")
     public ModelAndView excluir (@PathVariable(name = "id")Long id){
        tarefaService.excluir(id);
        return listarTarefas();
     }

 }


