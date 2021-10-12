package domain;

import domain.external.ContactRepository;
import domain.external.NotificationService;

import java.time.LocalDate;
import java.util.List;

public class Greetings {
    private ContactRepository contactRepository;
    private NotificationService notificationService;

    public Greetings(NotificationService notificationService, ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        this.notificationService = notificationService;
    }

    public void generateGreetings(LocalDate date) {
        List<String> contacts = contactRepository.findAll();
        String firstName = contacts.get(0);
        String messageText = String.format("Happy Birthday %s !", firstName);
        NotificationMessage message = new NotificationMessage(messageText);
        notificationService.send(message);
    }
}
