package me.pe4en1e.TextToMe.route;

import me.pe4en1e.TextToMe.entity.Message;
import me.pe4en1e.TextToMe.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetAllMessages {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/getAllMessages")
    public List<Message> getAllMessages() {
        return new ArrayList<>(messageRepository.findAll());
    }
}
