package controller;

import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import entity.Task;
import entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TaskService;
import service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    //Simulando usuario autenticado
    private User getAuthenticatedUser(){
        return userService.findById(1L).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskRequestDTO dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setLimitDate(dto.getLimitDate());

        Task saved = taskService.createTask(task, getAuthenticatedUser());

        return ResponseEntity.ok(new TaskResponseDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getCreationDate(), saved.getLimitDate(), saved.getCompleted()));

    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks(getAuthenticatedUser());
        List<TaskResponseDTO> response = tasks.stream()
                .map(t -> new TaskResponseDTO(t.getId(), t.getTitle(), t.getDescription(), t.getCreationDate(), t.getLimitDate(), t.getCompleted()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
