package domain;

import java.util.Objects;

public class NotificationMessage {
    private String messageText;

    public NotificationMessage(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationMessage that = (NotificationMessage) o;
        return Objects.equals(messageText, that.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageText);
    }
}
