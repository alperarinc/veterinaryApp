package com.arinc.veterinaryApp.api;



import com.arinc.veterinaryApp.dto.UserDto;
import com.arinc.veterinaryApp.entity.User;
import com.arinc.veterinaryApp.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class UserController {

    private final UserServiceImpl userServiceImpl;


    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable (value = "id",required = true)Long id) {
        User user = userServiceImpl.getById(id);
        return ResponseEntity.ok(user);

        //insert into customer(id,customer_name,customer_code) values (60,'deneme','test01')

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
            return ResponseEntity.ok(userServiceImpl.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id",required = true)Long id, @Valid @RequestBody UserDto user){
        return ResponseEntity.ok(userServiceImpl.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(userServiceImpl.delete(id));
    }

}
