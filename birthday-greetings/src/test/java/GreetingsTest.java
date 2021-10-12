import domain.Greetings;
import domain.NotificationMessage;
import domain.external.ContactRepository;
import domain.external.NotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

public class GreetingsTest {

    @Test
    void should_send_greetings_to_jane_on_her_birthday() {
        //ARRANGE
        NotificationService notificationService = BDDMockito.mock(NotificationService.class);
        ContactRepository contactRepository = BDDMockito.mock(ContactRepository.class);
        BDDMockito.given(contactRepository.findAll()).willReturn(List.of("Jane"));
        Greetings greetings = new Greetings(notificationService, contactRepository);

        //ACT
        greetings.generateGreetings(LocalDate.of(2021, 3, 13));

        //ASSERT
        NotificationMessage message = new NotificationMessage("Happy Birthday Jane !");
        Mockito.verify(notificationService).send(message);
    }

    @Test
    void should_send_greetings_to_jane_on_her_birthday() {
        //ARRANGE
        NotificationService notificationService = BDDMockito.mock(NotificationService.class);
        ContactRepository contactRepository = BDDMockito.mock(ContactRepository.class);
        BDDMockito.given(contactRepository.findAll()).willReturn(List.of("Jane"));
        Greetings greetings = new Greetings(notificationService, contactRepository);

        //ACT
        greetings.generateGreetings(LocalDate.of(2021, 3, 13));

        //ASSERT
        NotificationMessage message = new NotificationMessage("Happy Birthday Jane !");
        Mockito.verify(notificationService).send(message);
    }
}
