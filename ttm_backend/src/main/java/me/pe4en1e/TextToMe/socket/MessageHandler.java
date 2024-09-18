package me.pe4en1e.TextToMe.socket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.Session;
import me.pe4en1e.TextToMe.TtmBackendApplication;
import me.pe4en1e.TextToMe.entity.Message;
import me.pe4en1e.TextToMe.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageHandler implements WebSocketHandler {

    Logger logger = LoggerFactory.getLogger(TtmBackendApplication.class);

    List<WebSocketSession> activeSessions = new ArrayList<>();

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connection established: " + session.getId());
        activeSessions.add(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.info("Message received: " + message.getPayload());

        ObjectMapper objectMapper = new ObjectMapper();
        IncomingMessage incomingMessage = objectMapper.readValue(message.getPayload().toString(), IncomingMessage.class);

        for (var user : activeSessions) {
            user.sendMessage(new TextMessage(objectMapper.writeValueAsString(incomingMessage)));
        }

        Message messageData = Message.builder()
                .text(incomingMessage.getMessage())
                .author(incomingMessage.getAuthor())
                .build();

        messageRepository.save(messageData);

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error("Transport error", exception.getCause());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.info("Connection closed: " + session.getId());
        activeSessions.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
