package communication.platform.challenge.controller.dto;

import communication.platform.challenge.entity.Channel;
import communication.platform.challenge.entity.Notification;
import communication.platform.challenge.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                message,
                dateTime,
                destination,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
