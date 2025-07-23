package dto;

import java.time.LocalDateTime;

public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime limitDate;
    private Boolean completed;

    public TaskResponseDTO(Long id, String title, String description, LocalDateTime creationDate, LocalDateTime limitDate, Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.limitDate = limitDate;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(LocalDateTime limitDate) {
        this.limitDate = limitDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
