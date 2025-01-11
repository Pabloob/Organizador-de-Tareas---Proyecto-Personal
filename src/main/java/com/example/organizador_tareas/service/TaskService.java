package com.example.organizador_tareas.service;

import com.example.organizador_tareas.model.Task;
import com.example.organizador_tareas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getUserTasksById(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task newTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task currentTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe tarea con el id " + id));

        currentTask.setTaskName(updatedTask.getTaskName());
        currentTask.setDescription(updatedTask.getDescription());
        currentTask.setPriority(updatedTask.getPriority());
        currentTask.setExpirationDate(updatedTask.getExpirationDate());
        currentTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(currentTask);

    }

    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }
}
