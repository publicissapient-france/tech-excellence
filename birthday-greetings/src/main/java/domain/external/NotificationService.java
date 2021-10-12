package domain.external;

import domain.NotificationMessage;

public interface NotificationService {
    void send();

    void send(NotificationMessage message);
}
