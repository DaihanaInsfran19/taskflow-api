package com.empresasrl.taskflowapi.service;

import com.empresasrl.taskflowapi.exception.ResourceNotFoundException;
import com.empresasrl.taskflowapi.model.Task;
import com.empresasrl.taskflowapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAll(Boolean completed) {
        return completed == null
                ? repository.findAll()
                : repository.findByCompleted(completed);
    }

    public Task getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    /**
     * PUT should update title/description/priority only.
     * completed is handled only by PATCH /{id}/complete
     */
    public Task update(Long id, Task updated) {
        Task task = getById(id);
        task.setTitle(updated.getTitle());
        task.setDescription(updated.getDescription());
        task.setPriority(updated.getPriority());
        // IMPORTANT: do NOT overwrite completed here
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }

    public Task toggleCompleted(Long id) {
        Task task = getById(id);
        task.setCompleted(!task.isCompleted());
        return repository.save(task);
    }
}
