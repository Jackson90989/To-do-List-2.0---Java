package com.example.demo.Service;


import com.example.demo.Repository.TarefaRepositorio;
import com.example.demo.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j


public class TarefaService {


    private TarefaRepositorio tarefaRepositorio;


    public Tarefa createdTask (Tarefa tarefa){

        return tarefaRepositorio.save(tarefa);
    }

    public List<Tarefa> listAllTasks(){
        return tarefaRepositorio.findAll();
    }


    public ResponseEntity<Tarefa> findTaskByid(Long id) {
        return tarefaRepositorio.findById(id)
                .map(tarefa -> ResponseEntity.ok().body(tarefa))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Tarefa> updateTarefaById(Tarefa tarefa, Long id){
        return tarefaRepositorio.findById(id)
                .map(taskToUpdate -> {
                    taskToUpdate.setTitle(tarefa.getDescription());
                    taskToUpdate.setDescription(tarefa.getDescription());
                    taskToUpdate.setDeadLine(tarefa.getDeadLine());
                    Tarefa updated = tarefaRepositorio.save(taskToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id) {
        return tarefaRepositorio.findById(id)
                .map(taskToDelete -> {
                    tarefaRepositorio.deleteById(id);
                    return ResponseEntity.noContent().build();

                }).orElse(ResponseEntity.notFound().build());
    }

}
