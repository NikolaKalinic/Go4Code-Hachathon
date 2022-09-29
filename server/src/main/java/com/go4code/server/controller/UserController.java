package com.go4code.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.go4code.server.dto.UserDTO;
import com.go4code.server.model.User;
import com.go4code.server.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired
    UserService userService;

    @GetMapping(value = "api/users")
    public ResponseEntity<List<UserDTO>> getUsersPage() {
        final List<UserDTO> retVal = userService.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    
    @GetMapping(value = "api/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        final User user = userService.findOne(id);

        if (user == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        final UserDTO userDTO = new UserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    
    @PostMapping(value = "api/users")
    public ResponseEntity create(@RequestBody UserDTO userDTO) {
        final User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        final User savedUser = userService.save(user);
        return new ResponseEntity<>(new UserDTO(savedUser), HttpStatus.CREATED);
    }

    @PutMapping(value = "api/users/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody UserDTO userDTO) {
        final User user = userService.findOne(id);

        if (user == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        user.setId(id);
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        final User savedUser = userService.save(user);
        return new ResponseEntity<>(new UserDTO(savedUser), HttpStatus.OK);
    }

    @DeleteMapping(value = "api/users/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        final User user = userService.findOne(id);
        if (user == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        userService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
