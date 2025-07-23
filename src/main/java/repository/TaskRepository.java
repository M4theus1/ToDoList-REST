package repository;

import entity.Task;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findAllByUser(User user);

    List<Task> findAllByUserAndCompleted(User user, Boolean completed);

    List<Task> findAllByUserOrderByLimitDateAsc(User user);

    Long id(Long id);
}
