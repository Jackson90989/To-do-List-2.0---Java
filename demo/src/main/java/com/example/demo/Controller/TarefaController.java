package com.example.demo.Controller;

import com.example.demo.Service.TarefaService;
import com.example.demo.model.Tarefa;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j


public class TarefaController {



    TarefaService tarefaService;

    @ApiOperation(value = "Criando uma nova tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 201, message = "Tarefa criada com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar a tarefa, verifique as informações")
    })


    @PostMapping("/tarefas")
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa createdTask (@RequestBody Tarefa tarefa) {
        log.info("Criando uma nova tarefa com as informações [{}]", tarefa);
        return tarefaService.createdTask(tarefa);
    }

    @ApiOperation(value = "Listando todas as tarefas")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefa listada com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao listar a tarefa, verifique as informações")
    })



    @GetMapping("/tarefas")
    @ResponseStatus(HttpStatus.OK)
    public List<Tarefa> getAllTasks(){
        log.info("Listando todas as tarefa");
        return tarefaService.listAllTasks();



    }

    @ApiOperation(value = "Buscando uma tarefa pelo id")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefa encontrada com sucesso"),
            @ApiResponse(code = 404, message = "Não foi enontrada nenhuma  tarefa com esse id ")
    })

    @GetMapping("/tarefas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Tarefa> getTaskById(@PathVariable(value = "id") Long id){
        log.info("Buscando a tarefa com o Id [{}", id);
        return tarefaService.findTaskByid(id);




    }

    @ApiOperation(value = "Atualizando uma nova tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefa criada com sucesso"),
            @ApiResponse(code = 404, message = "Houve um erro ao Atualizar a tarefa, verifique as informações")
    })

    @PutMapping("/tarefas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Tarefa> updateTaskById(@PathVariable(value = "id") Long id, @RequestBody Tarefa tarefa){
        log.info("Atualizando a tarefa  com id [{}] as novas informacoes são: [{}]", id, tarefa);
        return tarefaService.updateTarefaById(tarefa, id);




    }


    @ApiOperation(value = "Deletando uma nova tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 204, message = "tarefa deletada com sucesso"),
            @ApiResponse(code = 404, message = "Houve um erro ao deletar a tarefa, verifique as informações")
    })

    @DeleteMapping("/tarefas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteTaskById(@PathVariable(value = "id") Long id) {
        log.info("Excluindo tarefa com o id [{}]",id );
        return tarefaService.deleteById(id);

    }


    }
