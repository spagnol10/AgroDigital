package com.hackaton.agrotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.agrotech.model.User;
import com.hackaton.agrotech.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User user) {
    return service.register(user);
  }

  @GetMapping("/list")
  public ResponseEntity<List<User>> listAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User obj = service.findById(id);
    return ResponseEntity.ok(obj);
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody User user) {
    return service.update(user);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    return service.delete(id);
  }
}
