package communication.platform.challenge.service;

import communication.platform.challenge.controller.dto.ScheduleNotificationDto;
import communication.platform.challenge.entity.Notification;
import communication.platform.challenge.entity.Status;
import communication.platform.challenge.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if(notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dataTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()
        ), dataTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return n -> {
            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }
}
