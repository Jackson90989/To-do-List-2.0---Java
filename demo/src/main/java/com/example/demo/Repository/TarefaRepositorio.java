package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tarefa;


@Repository
public interface TarefaRepositorio extends JpaRepository <Tarefa, Long > {
}
