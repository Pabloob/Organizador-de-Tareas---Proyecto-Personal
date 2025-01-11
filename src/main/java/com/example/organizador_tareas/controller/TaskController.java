package com.example.organizador_tareas.controller;

import com.example.organizador_tareas.model.Task;
import com.example.organizador_tareas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<Task>> getUserTasksById(@PathVariable Long userId) {
        List<Task> tasks = taskService.getUserTasksById(userId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = taskService.newTask(task);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTask(@PathVariable Long id) {
        taskService.removeTask(id);
        return ResponseEntity.noContent().build();
    }

}
