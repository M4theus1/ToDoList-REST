package service;

import entity.Task;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task, User user){
        task.setUser(user);
        task.setCreationDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(User user){
        return taskRepository.findAllByUser(user);
    }

    public List<Task> getTasksByCompletion(User user, Boolean completed){
        return taskRepository.findAllByUserAndCompleted(user, completed);
    }

    public List<Task> getTasksOrderedByLimitDate(User user){
        return taskRepository.findAllByUserOrderByLimitDateAsc(user);
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}