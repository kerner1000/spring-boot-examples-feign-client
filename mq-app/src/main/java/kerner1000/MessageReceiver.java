package kerner1000;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@RequiredArgsConstructor
@Slf4j
@Component
public class MessageReceiver {

    private final HelloClient client;

    @JmsListener(destination = "testQueue")
    public void onMessage(Message message) throws JMSException {
        if (message instanceof TextMessage textMessage) {
            log.info("Received message {}", textMessage.getText());
            sendMessage(textMessage);
        } else {
            log.warn("Received unknown message type {}", message.getJMSType());
        }
    }

    private void sendMessage(TextMessage textMessage) throws JMSException {

            ResponseEntity<Object> response = client.hello(textMessage.getText());
            log.info("Got a response: {}", response.getBody());

    }
}
