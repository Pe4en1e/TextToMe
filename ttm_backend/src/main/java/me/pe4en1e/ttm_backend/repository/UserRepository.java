package me.pe4en1e.ttm_backend.repository;

import me.pe4en1e.ttm_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> save(List<User> user);

    boolean existsByUsername(String username);

    User findUserByUsername(String username);

}
