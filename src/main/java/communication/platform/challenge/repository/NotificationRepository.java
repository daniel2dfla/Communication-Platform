package communication.platform.challenge.repository;

import communication.platform.challenge.entity.Notification;
import communication.platform.challenge.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dataTime);
}
