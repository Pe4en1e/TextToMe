package me.pe4en1e.TextToMe.repository;

import me.pe4en1e.TextToMe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> save(List<User> user);

    boolean existsByUsername(String username);

}
