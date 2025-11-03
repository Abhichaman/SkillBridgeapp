package SkillBridge.example.skillbridge.controller;

import SkillBridge.example.skillbridge.entity.Leaderboard;
import SkillBridge.example.skillbridge.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin
public class LeaderboardController {

    @Autowired
    private LeaderboardService service;

    // ✅ Get all records
    @GetMapping
    public List<Leaderboard> getAll() {
        return service.getAll();
    }

    // ✅ Insert or update record
    @PostMapping
    public ResponseEntity<String> saveScore(@RequestBody Leaderboard lb) {
        service.saveOrUpdate(lb);
        return ResponseEntity.ok("Score Saved");
    } }