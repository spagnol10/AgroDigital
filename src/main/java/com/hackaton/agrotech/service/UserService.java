package com.hackaton.agrotech.service;

import com.hackaton.agrotech.exception.ResponseUser;
import com.hackaton.agrotech.model.User;
import com.hackaton.agrotech.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    private final ResponseUser message;

    public UserService(UserRepository repository, ResponseUser message) {
        this.repository = repository;
        this.message = message;
    }

    public ResponseEntity<?> register(User user) {
        if (user.getName().isEmpty()) {
            message.setMessage("User name is required");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword().isEmpty()) {
            message.setMessage("User password type is required");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repository.save(user), HttpStatus.CREATED);
        }
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public ResponseEntity<?> update(User user) {
        if (user.getName().isEmpty()) {
            message.setMessage("User name is required");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword().isEmpty()) {
            message.setMessage("User password type is required");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repository.save(user), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        repository.deleteById(id);
        message.setMessage("User deleted");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
