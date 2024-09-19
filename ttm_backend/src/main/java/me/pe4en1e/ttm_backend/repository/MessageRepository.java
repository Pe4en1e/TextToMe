package me.pe4en1e.ttm_backend.repository;

import me.pe4en1e.ttm_backend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> save(List<Message> message);

    @Override
    List<Message> findAll();

}
