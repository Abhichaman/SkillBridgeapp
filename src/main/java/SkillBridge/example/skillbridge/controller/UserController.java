package SkillBridge.example.skillbridge.controller;


import SkillBridge.example.skillbridge.entity.User;
import SkillBridge.example.skillbridge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
        public Map<String, Object> register(@RequestBody User user){
        return  userService.registerUser(user);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user){
        return userService.loginUser(user.getEmail(),user.getPass());
    }

    @GetMapping("/details/{email}")
    public ResponseEntity<?> getUserDetails(@PathVariable String email) {
        try {
            return ResponseEntity.ok(userService.getUserDetailsByEmail(email));
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

}
