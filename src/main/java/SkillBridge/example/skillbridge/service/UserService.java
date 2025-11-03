package SkillBridge.example.skillbridge.service;

import SkillBridge.example.skillbridge.entity.User;
import SkillBridge.example.skillbridge.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Map<String, Object> registerUser(User user) {
        Map<String, Object> response = new HashMap<>();

        if (userRepo.findByEmail(user.getEmail()) != null) {
            response.put("success", false);
            response.put("message", "Email already registered");
            return response;
        }

        userRepo.save(user);
        response.put("success", true);
        response.put("message", "User registered successfully");
        return response;
    }

    // ✅ LOGIN
    public Map<String, Object> loginUser(String email, String pass) {
        Map<String, Object> response = new HashMap<>();
        User existingUser = userRepo.findByEmail(email);

        if (existingUser == null) {
            response.put("success", false);
            response.put("message", "User not found");
            return response;
        }

        if (!existingUser.getPass().equals(pass)) {
            response.put("success", false);
            response.put("message", "Incorrect password");
            return response;
        }

        response.put("success", true);
        response.put("message", "Login successful!");
        response.put("name", existingUser.getName());
        response.put("email", existingUser.getEmail());
        return response;
    }

    public Map<String, String> getUserDetailsByEmail(String email) {

        User user = userRepo.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found with email: " + email);
        }

        Map<String, String> data = new HashMap<>();
        data.put("name", user.getName());
        data.put("email", user.getEmail());

        return data;
    }
}




