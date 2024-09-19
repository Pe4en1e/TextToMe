package me.pe4en1e.TextToMe.repository;

import me.pe4en1e.TextToMe.entity.Message;
import me.pe4en1e.TextToMe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> save(List<Message> message);

    @Override
    List<Message> findAll();
}

